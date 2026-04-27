package com.gaurav.quizapp.controller;

import com.gaurav.quizapp.model.Question;
import com.gaurav.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();

    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategroy(category);

    }

    @PostMapping("/addQuestion")
    public ResponseEntity<String> addOneQuestion(@RequestBody Question question){
        return questionService.addOneQuestion(question);
    }
}
