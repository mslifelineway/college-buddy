package com.codinghub.collegebuddy.repositories;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.codinghub.collegebuddy.domain.Blog;

public interface BlogRepository extends CrudRepository<Blog, Long> {
	/**
	 * count all the blogs by userId
	 * 
	 * @param userId
	 * @return
	 */
	public long countAllByUserId(long userId);

	/**
	 * count all the blogs by collegeId
	 * 
	 * @param userId
	 * @return
	 */
	public long countAllByCollegeId(long collegeId);

	/**
	 * find all the blogs of a particular user or by userId
	 * 
	 * @param userId
	 * @return
	 */
	public Collection<Blog> findAllByUserId(long userId);
	
	/**
	 * find all the blogs of a particular College or by collegeId
	 * 
	 * @param userId
	 * @return
	 */
	public Collection<Blog> findAllByCollegeId(long collegeId);
}
