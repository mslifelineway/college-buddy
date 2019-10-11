package com.codinghub.collegebuddy.services;

import java.util.Collection;
import java.util.Optional;

import com.codinghub.collegebuddy.domain.Answer;

public interface AnswerService {
	/**
	 * Save a answer to answer entity
	 * @param answer
	 * @return
	 */
	public Answer saveAnswer(Answer answer);

	/**
	 * Save All Answers
	 * 
	 * @param allAnswers
	 * @return
	 */
	public Iterable<Answer> saveAllAnswers(Collection<Answer> allAnswers);

	/**
	 * updating a single Answer only
	 * 
	 * @param answer
	 * @return
	 */
	public Answer updateAnswer(Answer answer);

	/**
	 * Find Answer ById
	 * 
	 * @param answerId
	 * @return
	 */
	public Optional<Answer> findAnswerById(long answerId);

	/**
	 * Find all Answers (Only Answer entity not it's child entity data)
	 * 
	 * @return
	 */
	public Iterable<Answer> findAllAnswers();

	/**
	 * Find All Answers of a particular user by userId (declared in
	 * 'AnswerRepository' interface)
	 * 
	 * @param userId
	 * @return
	 */
	public Iterable<Answer> findAllAnswersByUserId(long userId);

	/**
	 * Find All Answers of a particular question by questionId (declared in
	 * 'AnswerRepository' interface)
	 * 
	 * @param questionId
	 * @return
	 */
	public Iterable<Answer> findAllAnswersByQuestionId(long questionId);

	/**
	 * Count all the Answers available in Answer entity
	 * 
	 * @return
	 */
	public Long countAllAnswers();

	/**
	 * Count all the Answers Of a Particular User by userId available in Answer
	 * entity (declared in 'AnswerRepository' interface)
	 * 
	 * @return
	 */
	public Long countAllAnswersByUserId(long userId);

	/**
	 * count all the answer by questionId
	 * 
	 * @param questionId
	 * @return
	 */
	public Long countAllAnswersByQuestionId(long questionId);

	/**
	 * Delete answer by answerId
	 * 
	 * @param answerId
	 * @return
	 */
	public boolean deleteAnswerById(long answerId);

	/**
	 * Delete answer by passing answer object
	 * 
	 * @param answer
	 * @return
	 */
	public boolean deleteAnswer(Answer answer);

	/**
	 * Delete bulk of answer
	 * 
	 * @param answer
	 * @return
	 */
	public boolean deleteBulkAnswers(Iterable<Answer> answers);
}
