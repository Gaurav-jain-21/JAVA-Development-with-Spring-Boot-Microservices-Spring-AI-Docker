package com.gaurav.user.service.userservice.controller;

import com.gaurav.user.service.userservice.entities.User;
import com.gaurav.user.service.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public void addUser(@RequestBody User user){
        userService.saveUser(user);
    }

    @GetMapping("/allUser")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
    @GetMapping("/{userId}")
    public User getById(@PathVariable String userId){
        return userService.getUserById(userId);
    }
}
