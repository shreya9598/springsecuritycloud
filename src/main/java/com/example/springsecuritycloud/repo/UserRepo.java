package com.example.springsecuritycloud.repo;

import com.example.springsecuritycloud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByEmail(String email);
    @Query(value = "from User")
    ArrayList<User> findAllUsers();
}
