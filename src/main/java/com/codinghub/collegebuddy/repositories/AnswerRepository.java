package com.codinghub.collegebuddy.repositories;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.codinghub.collegebuddy.domain.Answer;

public interface AnswerRepository extends CrudRepository<Answer, Long> {

	/**
	 * find all the answers written by a particular user by userId
	 * @param userId
	 * @return
	 */
	public Collection<Answer> findAllByUserId(long userId);

	/**
	 * find all the answers codes by questionId
	 * @param questionId
	 * @return
	 */
	public Collection<Answer> findAllByQuestionId(long questionId);
	
	/**
	 * count the answers by userId
	 * @param userId
	 * @return
	 */
	public Long countByUserId(long userId);
	
	/**
	 * count the answers by questionId
	 * @param questionId
	 * @return
	 */
	public Long countByQuestionId(long questionId);
}
