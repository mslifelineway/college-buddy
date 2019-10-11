package com.codinghub.collegebuddy.repositories;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.codinghub.collegebuddy.domain.College;

public interface CollegeRepository extends CrudRepository<College, Long> {

	/**
	 * count all the colleges by userId
	 * 
	 * @param userId
	 * @return
	 */
	public long countAllByUserId(long userId);

	/**
	 * find all the colleges of a particular user or by userId
	 * 
	 * @param userId
	 * @return
	 */
	public Collection<College> findAllByUserId(long userId);

}
