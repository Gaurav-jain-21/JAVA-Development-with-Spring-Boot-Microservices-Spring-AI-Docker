package com.gaurav.quizapp.service;

import com.gaurav.quizapp.model.Question;
import com.gaurav.quizapp.model.QuestionWrapper;
import com.gaurav.quizapp.model.Quiz;
import com.gaurav.quizapp.repository.QuestionRepo;
import com.gaurav.quizapp.repository.QuizRepo;
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
    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Question> questions= questionRepo.findRandomQuestionsByCategory(category,numQ);
        Quiz quiz= new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepo.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
        Optional<Quiz> quiz=quizRepo.findById(id);
        List<Question> questionFromDB= quiz.get().getQuestions();
        List<QuestionWrapper> questionForUser= new ArrayList<>();
        for(Question q: questionFromDB){
            QuestionWrapper qw= new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionForUser.add(qw);
        }
        return new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }
}
