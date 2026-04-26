package com.gaurav.basiceample3.controller;

import com.gaurav.basiceample3.model.Post;
import com.gaurav.basiceample3.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostRepo repo;

    @GetMapping("/posts")
    public List<Post> getAllPost(){
        return repo.findAll();
    }
}
