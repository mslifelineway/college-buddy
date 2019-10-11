package com.codinghub.collegebuddy.repositories;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.codinghub.collegebuddy.domain.JoinCollege;

public interface JoinCollegeRepository extends CrudRepository<JoinCollege, Long>{

	/**
	 * Finding all the approved users who joined  a particular college
	 * @param collegeId
	 * @return
	 */
	public Collection<JoinCollege> findByCollegeIdAndStatus(long collegeId, int status);
	
	/**
	 * counting all the approved users who joined  a particular college
	 * @param collegeId
	 * @return
	 */
	public Long countByCollegeIdAndStatus(long collegeId, int status);
	
	public Collection<JoinCollege> findByUserId(long userId);
	
	public Collection<JoinCollege> findByCollegeId(long collegeId);
	
	public Long countByCollegeId(long collegeId);
}
