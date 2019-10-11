package com.codinghub.collegebuddy.repositories;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.codinghub.collegebuddy.domain.FollowQuestion;

public interface FollowQuestionRepository extends CrudRepository<FollowQuestion, Long> {

	/**
	 * count all the FollowedQuestions by userId
	 * 
	 * @param userId
	 * @return
	 */
	public long countByUserId(long userId);

	/**
	 * count all the FollowedQuestions by questionId
	 * 
	 * @param questionId
	 * @return
	 */
	public long countByQuestionId(long questionId);

	/**
	 * find all the followedQuestion of a particular user or by userId
	 * 
	 * @param userId
	 * @return
	 */
	public Collection<FollowQuestion> findAllByUserId(long userId);

	/**
	 * find all the FollowedQuestion of a particular Question or by questionId
	 * 
	 * @param questionId
	 * @return
	 */
	public Collection<FollowQuestion> findAllByQuestionId(long questionId);
	
	/**
	 * Find out userId with questionId already exists or not 
	 * @param userId
	 * @param questionId
	 * @return
	 */
	public FollowQuestion findByUserIdAndQuestionId(Long userId, long questionId);
}
