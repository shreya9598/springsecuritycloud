package com.example.springsecuritycloud;

import com.example.springsecuritycloud.model.Coupon;
import com.example.springsecuritycloud.model.Role;
import com.example.springsecuritycloud.model.User;
import com.example.springsecuritycloud.repo.CouponRepo;
import com.example.springsecuritycloud.repo.RoleRepo;
import com.example.springsecuritycloud.repo.UserRepo;
import com.example.springsecuritycloud.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class SpringsecuritycloudApplicationTests {

	@Autowired
	CouponRepo repo;

	@Autowired
	UserRepo userRepo;

	@Lazy
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	RoleRepo roleRepo;

	@Autowired
	UserService userService;

	@Test
	void contextLoads() {
	}

//	@Test
////	@Transactional
//	void createUser() {

//
//
//		User user2= new User();
//		user2.setEmail("shreya@");
//		user2.setFirstName("shreya");
//		user2.setLastName("gupta");
//		user2.setPassword(passwordEncoder.encode("shreya"));
//		Role role= new Role();
//		role.setName("ADMIN");
//
//		roleRepo.save(role);
//
//		user2.addRole(role);
//
//		userRepo.save(user2);
//	}

	@Test
	void createUser(){
		User user2= new User();
		user2.setEmail("shreya@");
		user2.setFirstName("shreya");
		user2.setLastName("gupta");
		user2.setPassword(passwordEncoder.encode("shreya"));

		userService.saveUser(user2);

	}

	@Test
	void testAddUser(){
		User user = new User();
		Role role = new Role();

		user.setEmail("shreya@");
		role.setName("ADMIN");

		userService.addRole(user,role);


	}


}
