package com.codinghub.collegebuddy.testing.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.codinghub.collegebuddy.domain.User;
import com.codinghub.collegebuddy.repositories.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserFollow {

	@Autowired
	private UserRepository userRepo;
	
	@Test
	public void test() {

		User u1= new User();
		User u2= new User();
		
		u1.setUsername("abc");
		u1.setName("abcd");
		u1.setPassword("abc1");
		u1.setProfession("current user");
		u1.setCollege("abc world");
		u1.setEmail("abc.gmail.com");
		
		u2.setUsername("abc");
		u2.setName("abcd");
		u2.setPassword("abc1");
		u2.setProfession("current user");
		u2.setCollege("abc world");
		u2.setEmail("abc.gmail.com");
		
		
		
	}

}
