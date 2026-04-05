package com.gaurav.quizeapp.service;

import com.gaurav.quizeapp.model.Question;
import com.gaurav.quizeapp.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepo questionRepo;
    public List<Question> getAllQuestions() {
        return questionRepo.findAll();
    }

    public List<Question> getQuestionBYCategory(String category) {
        return questionRepo.findByCategory(category);
    }

    public void addQuestion(Question question) {
        questionRepo.save(question);
    }
}
