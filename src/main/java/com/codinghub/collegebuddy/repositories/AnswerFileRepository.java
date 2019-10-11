package com.codinghub.collegebuddy.repositories;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.codinghub.collegebuddy.domain.AnswerFile;

public interface AnswerFileRepository extends CrudRepository<AnswerFile, Long>{

	/**
	 * find all the answer Files by answerId
	 * @param answerId
	 * @return
	 */
	public Collection<AnswerFile> findAllByAnswerId(long answerId);
	
	/**
	 * count the answer files by answerId
	 * @param answerId
	 * @return
	 */
	public long countAllByAnswerId(long answerId);
}
