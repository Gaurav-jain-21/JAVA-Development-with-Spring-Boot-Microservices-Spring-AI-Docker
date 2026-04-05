package com.gaurav.quizeapp.controller;

import com.gaurav.quizeapp.model.Question;
import com.gaurav.quizeapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    @GetMapping("/allQuestion")
    public List<Question> getAllQuestion(){
        return questionService.getAllQuestions();

    }
    @GetMapping("/{category}")
    public List<Question> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionBYCategory(category);
    }

    @PostMapping("/add")
    public String addQuestion(@RequestBody Question question){
        questionService.addQuestion(question);
        return "question added sucs";
    }

}
