package com.codinghub.collegebuddy.testing.domain;

import java.util.Date;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.codinghub.collegebuddy.domain.College;
import com.codinghub.collegebuddy.domain.JoinCollege;
import com.codinghub.collegebuddy.domain.User;
import com.codinghub.collegebuddy.services.JoinCollegeService;
import com.codinghub.collegebuddy.utils.ConstantRequired;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class JoinCollegeTesting {

	@Autowired
	private JoinCollegeService joinCollegeService;
	
	@Test
	public void test() {
		
		/// let join a college by a user
		joinCollege();
		
		
	}

	private void joinCollege() {

		User u = new User();
		u.setId((long) 6);
		
		College c = new College();
		c.setId((long) 3);
		
		JoinCollege jc = new JoinCollege();
		jc.setCollege(c);
		jc.setUser(u);
		jc.setJoinedDate(new Date());
		jc.setStatus(ConstantRequired.JOIN_COLLEGE_STATUS_PENDING);
		
		JoinCollege newJc = joinCollegeService.joinCollege(jc);
		
		if(newJc != null) {
			System.out.println("User Just joined the college and status is in pending , \n so just wait for approved by the college admin");
		}
		else {
			System.out.println("Request to join the college has cancelled due to the termination or process.");
		}
		
		
		
	}
}
