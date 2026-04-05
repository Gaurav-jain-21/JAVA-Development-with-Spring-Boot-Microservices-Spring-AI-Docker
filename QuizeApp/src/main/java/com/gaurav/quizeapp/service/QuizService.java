package com.gaurav.quizeapp.service;

import com.gaurav.quizeapp.model.Question;
import com.gaurav.quizeapp.model.QuestionWrapper;
import com.gaurav.quizeapp.model.Quiz;
import com.gaurav.quizeapp.repo.QuestionRepo;
import com.gaurav.quizeapp.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    private QuizRepo quizRepo;
    @Autowired
    private QuestionRepo questionRepo;
    public ResponseEntity<String> createQuiz(String category, int numQ, String title){
        List<Question> question= questionRepo.findRandomQuestionsByCategory(category,numQ);

        Quiz quiz= new Quiz();

        quiz.setTitle(title);
        quiz.setQuestions(question);
        quizRepo.save(quiz);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
        Optional<Quiz> quiz=quizRepo.findById(id);
        List<Question> questionFromDB= quiz.get().getQuestions();
        List<QuestionWrapper> questionForUser= new ArrayList<>();
        for(Question q: questionFromDB){
            QuestionWrapper qw= new QuestionWrapper(q.getId(), q.getQuestionTitle(),q.getOption1(),q.getOption2(), q.getOption3(),q.getOption4());
            questionForUser.add(qw);
        }
        return new ResponseEntity<>(questionForUser, HttpStatus.OK);
    }
}
