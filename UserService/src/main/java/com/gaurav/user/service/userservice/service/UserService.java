package com.gaurav.user.service.userservice.service;

import com.gaurav.user.service.userservice.entities.User;
import com.gaurav.user.service.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user){
        // Keep manual ID support, but generate one if the client omits it.
        if (user.getUserId() == null || user.getUserId().isBlank()) {
            user.setUserId(UUID.randomUUID().toString());
        }
        userRepository.save(user);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    public User getUserById(String userId){
        return userRepository.findById(userId).orElse(null);
    }

}
