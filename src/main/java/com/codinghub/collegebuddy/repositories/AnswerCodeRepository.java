package com.codinghub.collegebuddy.repositories;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.codinghub.collegebuddy.domain.AnswerCode;

public interface AnswerCodeRepository extends CrudRepository<AnswerCode, Long>{

	/**
	 * find all the answer codes by answerId
	 * @param answerId
	 * @return
	 */
	public Collection<AnswerCode> findAllByAnswerId(long answerId);
	
	/**
	 * count the answer code by answerId
	 * @param answerId
	 * @return
	 */
	public long countAllByAnswerId(long answerId);
}
