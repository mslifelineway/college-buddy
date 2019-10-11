package com.codinghub.collegebuddy.testing.domain;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.codinghub.collegebuddy.domain.Skill;
import com.codinghub.collegebuddy.services.SkillService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SkillTesting {
	
	@Autowired
	private SkillService skillService;
	
	@Test
	public void test() throws NoSuchAlgorithmException {
		
		saveSkills();
	}

	private void saveSkills() {

		Collection<Skill> skills = new ArrayList<Skill>();
		
		Skill s1 = new Skill();
		s1.setName("Java");
		s1.setType("Programming Language");
		
		Skill s2 = new Skill();
		s2.setName("Spring Boot");
		s2.setType("Spring FrameWork");
		
		Skill s3 = new Skill();
		s3.setName("Spring Mvc");
		s3.setType("Spring FrameWork");
		
		Skill s4 = new Skill();
		s4.setName("Php");
		s4.setType("Scripting Language");
		
		Skill s5 = new Skill();
		s5.setName("C");
		s5.setType("Programming Language");
		
		Skill s6 = new Skill();
		s6.setName("C++");
		s6.setType("Programming Language");
		
		Skill s7 = new Skill();
		s7.setName("Android Studio");
		s7.setType("Android PlatForm");
		
		skills.add(s1);
		skills.add(s2);
		skills.add(s3);
		skills.add(s4);
		skills.add(s5);
		skills.add(s6);
		skills.add(s7);
		
		Collection<Skill> savedSkills = skillService.addSkills(skills);
		if(savedSkills.size() != 0) {
			System.out.println("\n\n All the skills are saved successfully! \n\n " + savedSkills);
			
		}
		else
			System.out.println("\n\n skills are not saved....");
	}

}
