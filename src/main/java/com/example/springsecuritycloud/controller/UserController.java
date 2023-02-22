package com.example.springsecuritycloud.controller;

import com.example.springsecuritycloud.dto.UserDto;
import com.example.springsecuritycloud.model.Role;
import com.example.springsecuritycloud.model.User;
import com.example.springsecuritycloud.repo.CouponRepo;
import com.example.springsecuritycloud.repo.UserRepo;
import com.example.springsecuritycloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("")
    ArrayList<User> getAllUsers(){
        return userService.findAllUsers();
    }

    //@PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/add")
    void createUser(@RequestBody User user){
        userService.saveUser(user);
    }

    @PostMapping("/addrole")
    void addRole(@RequestBody UserDto userDto){
        User user = new User();
        Role role = new Role();

        user.setEmail(userDto.getEmail());
        role.setName(userDto.getRolename());

        userService.addRole(user,role);
//        userService.saveUser(user);
    }


}
