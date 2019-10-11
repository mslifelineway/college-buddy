package com.codinghub.collegebuddy.repositories;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.codinghub.collegebuddy.domain.QuestionCode;

public interface QuestionCodeRepository extends CrudRepository<QuestionCode, Long>{
	
	/**
	 * find all the question codes by questionId
	 * @param questionId
	 * @return
	 */
	public Collection<QuestionCode> findAllByQuestionId(long questionId);
	
	/**
	 * count the question codes by questionId
	 * @param questionId
	 * @return
	 */
	public long countByQuestionId(long questionId);

}
