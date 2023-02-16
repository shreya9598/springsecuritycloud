package com.example.springsecuritycloud;

import com.example.springsecuritycloud.model.Coupon;
import com.example.springsecuritycloud.model.Role;
import com.example.springsecuritycloud.model.User;
import com.example.springsecuritycloud.repo.CouponRepo;
import com.example.springsecuritycloud.repo.UserRepo;
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

	@Test
	void contextLoads() {
	}

	@Test
//	@Transactional
	void createUser() {
//		User user= new User();
//		user.setEmail("ghhjjh");
//		user.setFirstName("ghghda");
//		user.setLastName("jhjh");
//		user.setPassword("sfd");


		User user2= new User();
		user2.setEmail("shreya@");
		user2.setFirstName("shreya");
		user2.setLastName("gupta");
		user2.setPassword(passwordEncoder.encode("shreya"));

		userRepo.save(user2);
	}


}
