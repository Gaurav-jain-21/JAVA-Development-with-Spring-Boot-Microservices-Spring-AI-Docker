package com.gaurav.questionservice.service;


import com.gaurav.questionservice.dao.QuestionDao;
import com.gaurav.questionservice.model.Question;
import com.gaurav.questionservice.model.QuestionWrapper;
import com.gaurav.questionservice.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> addQuestion(Question question) {
        questionDao.save(question);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }

    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, int numQuestions) {

        List<Integer> questionId=questionDao.findRandomQuestionsByCategory(categoryName,numQuestions);

        return new ResponseEntity<>(questionId,HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(List<Integer> questionId) {

        List<QuestionWrapper> wrappers= new ArrayList<>();
        List<Question> questions= new ArrayList<>();
        for(int id: questionId){
            questions.add(questionDao.findById(id).orElse(null));
        }
        for (Question question: questions){
            QuestionWrapper wapper= new QuestionWrapper();
            wapper.setId(question.getId());
            wapper.setQuestionTitle(question.getQuestionTitle());
            wapper.setOption1(question.getOption1());
            wapper.setOption2(question.getOption2());
            wapper.setOption3(question.getOption3());
            wapper.setOption4(question.getOption4());
            wrappers.add(wapper);
        }
        return new ResponseEntity<>(wrappers, HttpStatus.CREATED);
    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {

        int right=0;
        for(Response response: responses){
            Question question = questionDao.findById(response.getId()).get();
            if(response.getResponse().equals(question.getRightAnswer()))
                right++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
