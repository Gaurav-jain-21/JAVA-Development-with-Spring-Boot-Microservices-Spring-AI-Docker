package com.gaurav.quizeapp.service;

import com.gaurav.quizeapp.model.Question;
import com.gaurav.quizeapp.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepo questionRepo;
    public List<Question> getAllQuestions() {
        return questionRepo.findAll();
    }

    public ResponseEntity<List<Question>> getQuestionBYCategory(String category) {
        return new ResponseEntity<>(questionRepo.findByCategory(category), HttpStatus.OK);
    }

    public void addQuestion(Question question) {
        questionRepo.save(question);
    }
}
