package com.gaurav.userservice.impl;

import com.gaurav.userservice.entities.User;
import com.gaurav.userservice.exception.ResoucreNotFoundException;
import com.gaurav.userservice.repository.UserRepo;
import com.gaurav.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User saveUser(User user){
        String randomUserId= UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User getUser(String userId) {
        return userRepo.findById(userId).orElseThrow(()-> new ResoucreNotFoundException("User with given id id not found exception"));
    }


}
