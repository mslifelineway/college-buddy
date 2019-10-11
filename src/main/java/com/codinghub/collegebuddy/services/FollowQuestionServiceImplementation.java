package com.codinghub.collegebuddy.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codinghub.collegebuddy.domain.FollowQuestion;
import com.codinghub.collegebuddy.repositories.FollowQuestionRepository;

@Service
public class FollowQuestionServiceImplementation implements FollowQuestionService {

	@Autowired
	private FollowQuestionRepository followQuestionRepo;

	@Override
	public FollowQuestion followAQuestion(FollowQuestion followQuestion) {
		if (followQuestion != null)
			return followQuestionRepo.save(followQuestion);
		return null;
	}

	@Override
	public FollowQuestion updateFollowedQuestion(FollowQuestion followedQuestion) {
		if (followedQuestion != null)
			return followQuestionRepo.save(followedQuestion);
		return null;
	}

	@Override
	public boolean unFollowAQuestion(Long followedQuestionId) {
		if (followedQuestionId != 0) {
			followQuestionRepo.deleteById(followedQuestionId);
			return true;
		}
		return false;
	}

	@Override
	public long countAllFollowedQuestions() {
		return followQuestionRepo.count();
	}

	@Override
	public long countAllFollowedQuestionsByUserId(long userId) {
		if (userId != 0)
			return followQuestionRepo.countByUserId(userId);
		return 0;
	}

	@Override
	public long countAllFollowedQuestionsByQuestionId(long questionId) {
		System.out.println("Question Id " + questionId);
		if (questionId != 0)
			return followQuestionRepo.countByQuestionId(questionId);
		return 0;
	}

	@Override
	public Iterable<FollowQuestion> findAllFollowedQuestions() {
		return followQuestionRepo.findAll();
	}

	@Override
	public Optional<FollowQuestion> findAllFollowedQuestionsById(long followedQuestionId) {
		if (followedQuestionId != 0)
			return followQuestionRepo.findById(followedQuestionId);
		return null;
	}

	@Override
	public Collection<FollowQuestion> findAllFollowedQuestionsByUserId(long userId) {
		if (userId != 0)
			return followQuestionRepo.findAllByUserId(userId);
		return null;
	}

	@Override
	public Collection<FollowQuestion> findAllFollowedQuestionsByQuestionId(long questionId) {
		if (questionId != 0)
			return followQuestionRepo.findAllByQuestionId(questionId);
		return null;
	}

	@Override
	public boolean isUserFollowThisQuestion(Long userId, Long questionId) {
		if (userId != 0 && questionId != 0) {
			FollowQuestion fq = followQuestionRepo.findByUserIdAndQuestionId(userId, questionId);
			if (fq != null)
				return true;
		}
		return false;
	}

}
