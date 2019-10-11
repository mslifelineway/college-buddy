package com.codinghub.collegebuddy.repositories;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.codinghub.collegebuddy.domain.QuestionFile;

public interface QuestionFileRepository extends CrudRepository<QuestionFile, Long>{
	
	/**
	 * Finding all the QuestionFile by QuestionId
	 * @return
	 */
	public Collection<QuestionFile> findAllByQuestionId(long questionId);
	
	public Long countByQuestionId(long questionId);
}
