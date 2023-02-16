package com.example.springsecuritycloud.repo;

import com.example.springsecuritycloud.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
}
