package com.example.springsecuritycloud.service;

import com.example.springsecuritycloud.model.Role;
import com.example.springsecuritycloud.model.User;
import com.example.springsecuritycloud.repo.RoleRepo;
import com.example.springsecuritycloud.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Component
public class UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void saveUser(User user){
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
    }

    public void addRole(User user, Role role){
        User userres= userRepo.findByEmail(user.getEmail());

        Role roleres = roleRepo.findByName(role.getName());
        if(userres == null){
            throw new UsernameNotFoundException("User not found" + user.getEmail());
        }

        if(roleres == null){
            roleRepo.save(role);
        }

        userres.addRole(roleres);

        userRepo.save(userres);

    }

    public ArrayList<User> findAllUsers(){
        return userRepo.findAllUsers();
    }

}
