package com.gaurav.userservice.service;

import com.gaurav.userservice.entities.User;

import java.util.List;

public interface UserService {

    //create
    User saveUser(User user);

    List<User> getAllUser();

    User getUser(String userId);
}
