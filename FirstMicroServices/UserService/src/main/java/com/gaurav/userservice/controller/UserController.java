package com.gaurav.userservice.controller;

import com.gaurav.userservice.entities.User;
import com.gaurav.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public User addUser(@RequestBody User user){
        return  userService.saveUser(user);
    }


    @GetMapping("/allusers")
    public List<User> getUser(){
        return userService.getAllUser();
    }

    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable String userId){
        return userService.getUser(userId);
    }
}
