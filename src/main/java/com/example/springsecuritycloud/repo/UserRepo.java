package com.example.springsecuritycloud.repo;

import com.example.springsecuritycloud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
