package com.codinghub.collegebuddy.services;

import java.util.Collection;
import java.util.Optional;

import com.codinghub.collegebuddy.domain.FollowQuestion;

public interface FollowQuestionService {

	/**
	 * save a FollowQuestion object
	 * 
	 * @param followQuestion
	 * @return
	 */
	public FollowQuestion followAQuestion(FollowQuestion followQuestion);

	/**
	 * Update a FollowedQuestion
	 * 
	 * @param followedQuestion
	 * @return
	 */
	public FollowQuestion updateFollowedQuestion(FollowQuestion followedQuestion);

	/**
	 * Delete a FollowedQuestion by followedQuestionId
	 * 
	 * @param followedQuestionId
	 * @return
	 */
	public boolean unFollowAQuestion(Long followedQuestionId);

	/**
	 * Count all the FollowedQuestions present in the FollowQuestion entity
	 * 
	 * @return
	 */
	public long countAllFollowedQuestions();

	/**
	 * counting all the FollowedQuestions of a particular user or by userId
	 * 
	 * @param userId
	 * @return
	 */
	public long countAllFollowedQuestionsByUserId(long userId);

	/**
	 * counting all the FollowedQuestions of a particular question or by questionId
	 * 
	 * @param questionId
	 * @return
	 */
	public long countAllFollowedQuestionsByQuestionId(long questionId);

	/**
	 * Finding all the FollowedQuestion present in the FollowQuestion Entity
	 * 
	 * @return
	 */
	public Iterable<FollowQuestion> findAllFollowedQuestions();

	/**
	 * Finding FollowedQuestion by a FollowedQuestion Id
	 * 
	 * @param followedQuestionId
	 * @return
	 */
	public Optional<FollowQuestion> findAllFollowedQuestionsById(long followedQuestionId);

	/**
	 * Finding All the FollowedQuestion of a particular user or by userId
	 * 
	 * @param userId
	 * @return
	 */
	public Collection<FollowQuestion> findAllFollowedQuestionsByUserId(long userId);

	/**
	 * Finding All the FollowedQuestion of a particular question or by questionId
	 * 
	 * @param questionId
	 * @return
	 */
	public Collection<FollowQuestion> findAllFollowedQuestionsByQuestionId(long questionId);

	/**
	 * Check whether the user is following a particular question
	 * @param userId
	 * @param questionId
	 * @return
	 */
	public boolean isUserFollowThisQuestion(Long userId, Long questionId);

}
