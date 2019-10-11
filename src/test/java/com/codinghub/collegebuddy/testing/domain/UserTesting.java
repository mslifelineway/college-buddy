package com.codinghub.collegebuddy.testing.domain;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.codinghub.collegebuddy.domain.College;
import com.codinghub.collegebuddy.domain.User;
import com.codinghub.collegebuddy.helper.HelperClass;
import com.codinghub.collegebuddy.services.CollegeService;
import com.codinghub.collegebuddy.services.UserService;
import com.codinghub.collegebuddy.utils.ConstantRequired;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTesting {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CollegeService collegeService;
	
	@Test
	public void test() throws NoSuchAlgorithmException {
		saveUser();
	}

	private void saveUser() throws NoSuchAlgorithmException {
		
		String firstName = "oyedost";
		String lastName = "";
		String fullName = firstName + " " + lastName;
		String college = "cits warangal";
		String email = "oyedost@yahoo.com";
		String password = "123";
		String profession = "Developer";
		String username = HelperClass.generateUsername(email);

		User u = new User();
		u.setName(fullName);
		u.setCollege(college);
		u.setEmail(email);
		u.setPassword(HelperClass.encyptPassword(password));
		u.setProfession(profession);
		u.setUsername(username);
		u.setRegDate(new Date());
		u.setImage("default.png");
		
		User user = userService.findByEamilAndUsername(email,username);
		if(user == null)
		{
			System.out.println("User not found yet.");
			User newUser = userService.saveUser(u);
			if(newUser != null)
			{
				System.out.println("\n\n User saved.");
				College c = new College();
				c.setUser(newUser);
				c.setRegDate(new Date());
				c.setProfileImage(ConstantRequired.DEFAULT_COLLEGE_PROFILE_IMAGE);
				c.setCoverImage(ConstantRequired.DEFAULT_COLLEGE_COVER_IMAGE);
				c.setCollegeName(newUser.getCollege());
				c.setAbout(ConstantRequired.COLLEGE_ABOUT);
				c.setTitle(ConstantRequired.COLLEGE_TITLE);
				c.setOpen(ConstantRequired.COLLEGE_STATUS); // college status = true
				College savedCollege = collegeService.saveCollege(c);
				/// now after saving new college of the user set it default college for the user
				if (savedCollege.getId() != 0) {
					System.out.println("------ new saved user id : " + newUser.getId());
					newUser.setDefaultCollege(savedCollege);
					userService.saveUser(newUser);
				}
				
			}
			else
				System.out.println("\n\n User not saved.");
			
			
		}
		else {
			System.out.println("\n\n user already exists...\n\n");
		}
	}
}
