package com.codinghub.collegebuddy.testing.domain;

import java.util.Date;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.codinghub.collegebuddy.domain.Answer;
import com.codinghub.collegebuddy.domain.LikeDislikeAnswer;
import com.codinghub.collegebuddy.domain.User;
import com.codinghub.collegebuddy.services.LikeDislikeAnswerService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class LikeDislikeAnswerTesting {

	@Autowired
	private LikeDislikeAnswerService likeDislikeAnswerService;
	
	@Test
	public void test() {

		//// do like to an answer 
//		likeAnAnswer();
		
		//// count all the liked answer
//		countAllLikedAnswer();
		
		//// count all disliked answer
//		countAllDislikedAnswer();
		
		/// count all the liked answer by answerId
		countAllLikedAnswerByAnswerId();
	}

	private void countAllLikedAnswerByAnswerId() {
		Long count = likeDislikeAnswerService.countAllLikedAnswerByAnswerId((long) 1);
		System.out.println("count : " + count);
		
	}

	private void countAllDislikedAnswer() {
		Long count = likeDislikeAnswerService.countAllDislikedAnswer();
		System.out.println("count : " + count);
	}

	private void countAllLikedAnswer() {
		
		Long count = likeDislikeAnswerService.countAllLikedAnswer();
		System.out.println("count : " + count);
	}

	private void likeAnAnswer() {
		Answer a = new Answer();
		a.setId((long) 1);
		
		User u = new User();
		u.setId((long) 4);
		
		LikeDislikeAnswer ld = new LikeDislikeAnswer();
		ld.setActionDate(new Date());
		ld.setAnswer(a);
		ld.setStatus(1);
		ld.setUser(u);
		
		LikeDislikeAnswer ld1 = likeDislikeAnswerService.likeDislikeAnswer(ld);
		if(ld1 == null)
			System.out.println("failed to like the answer");
		else
			System.out.println("Answer Liked!");
	}

	
}
