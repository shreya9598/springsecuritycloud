package com.example.springsecuritycloud.controller;

import com.example.springsecuritycloud.model.User;
import com.example.springsecuritycloud.repo.CouponRepo;
import com.example.springsecuritycloud.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/add")
    void createUser(@RequestBody User user){
        userRepo.save(user);
    }
}
