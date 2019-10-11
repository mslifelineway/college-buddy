package com.codinghub.collegebuddy.services;

import java.util.Collection;
import java.util.Optional;

import com.codinghub.collegebuddy.domain.College;

public interface CollegeService {

	/**
	 * save a user college
	 * 
	 * @param college
	 * @return
	 */
	public College saveCollege(College college);

	/**
	 * Update a user college
	 * 
	 * @param college
	 * @return
	 */
	public College updateCollege(College college);

	/**
	 * Delete a college by collegeId
	 * 
	 * @param collegeId
	 * @return
	 */
	public boolean deleteCollegeById(Long collegeId);

	/**
	 * Count all the colleges present in the colleges entity
	 * 
	 * @return
	 */
	public long countAllColleges();

	/**
	 * counting all the colleges of a particualr user or by userId
	 * 
	 * @param userId
	 * @return
	 */
	public long countAllCollegesByUserId(long userId);

	/**
	 * Finding all the colleges present in the colleges Entity
	 * 
	 * @return
	 */
	public Iterable<College> findAllColleges();

	/**
	 * Finding college by a College Id
	 * 
	 * @param collegeId
	 * @return
	 */
	public Optional<College> findCollegeById(long collegeId);

	/**
	 * Finding All the colleges of a particular user or by userId
	 * 
	 * @param userId
	 * @return
	 */
	public Collection<College> findAllCollegesByUserId(long userId);

}
