package com.codinghub.collegebuddy.repositories;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.codinghub.collegebuddy.domain.LikeDislikeBlog;

public interface LikeDislikeBlogRepository extends CrudRepository<LikeDislikeBlog, Long> {

	/**
	 * Count all the liked blog , where status = 1
	 * 
	 * @param status
	 * @return
	 */
	@Query("select count(c) from LikeDislikeBlog c where c.status = :status")
	public Long countAllLikedBlog(@Param("status") int status);

	/**
	 * Count all the disliked blog, where status = 2
	 * 
	 * @param status
	 * @return
	 */
	@Query("select count(c) from LikeDislikeBlog c where c.status = :status")
	public Long countAllDislikedBlog(@Param("status") int status);

	/**
	 * count all liked blog by blogId and status = 1
	 * 
	 * @param blogId
	 * @return
	 */
	@Query("select count(c) from LikeDislikeBlog c where c.status = :status and c.blog.id = :id")
	public Long countAllLikedBlogsByBlogId(@Param("status") int i, @Param("id") long blogId);

	/**
	 * Count all disliked blog by blogId and status = 2
	 * 
	 * @param i
	 * @param blogId
	 * @return
	 */
	@Query("select count(c) from LikeDislikeBlog c where c.status = :status and c.blog.id = :id")
	public Long countAllDislikedBlogsByBlogId(@Param("status") int i, @Param("id") long blogId);

	/**
	 * Count all the liked and disliked blog by blogId
	 * 
	 * @param blogId
	 * @return
	 */
	@Query("select count(c) from LikeDislikeBlog c where c.blog.id = :id")
	public Long countLikedDislikedBlogsByBlogId(@Param("id") long blogId);

	/**
	 * count all liked blog by userId and status = 1
	 * 
	 * @param userId
	 * @return
	 */

	@Query("select count(c) from LikeDislikeBlog c where c.status = :status and c.user.id = :id")
	public Long countAllLikedBlogsByUserId(@Param("status") int i, @Param("id") long userId);

	/**
	 * Count all disliked Blog by userId and status = 2
	 * 
	 * @param i
	 * @param userId
	 * @return
	 */
	@Query("select count(c) from LikeDislikeBlog c where c.status = :status and c.user.id = :id")
	public Long countAllDislikedBlogsByUserId(@Param("status") int i, @Param("id") long userId);

	/**
	 * Count all the liked and disliked Blog by userId
	 * 
	 * @param userId
	 * @return
	 */
	@Query("select count(c) from LikeDislikeBlog c where c.user.id = :id")
	public Long countLikedDislikedBlogsByUserId(@Param("id") long userId);

	public LikeDislikeBlog findByUserIdAndBlogIdAndStatus(long userId, long blogId, int i);

	public Collection<LikeDislikeBlog> findByBlogId(long blogId);

	@Transactional
	void deleteByIdIn(List<Long> ids);
}
