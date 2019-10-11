package com.codinghub.collegebuddy.repositories;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.codinghub.collegebuddy.domain.Question;

public interface QuestionRepository extends CrudRepository<Question, Long>{

	/**
	 * Finding all the questions by userId
	 * @return
	 */
	public Collection<Question> findAllByUserId(long userId);
	
	public Long countByUserId(long userId);
}
