package com.codinghub.collegebuddy.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.codinghub.collegebuddy.domain.LikeDislikeAnswer;

public interface LikeDislikeAnswerRepository extends CrudRepository<LikeDislikeAnswer, Long> {

	/**
	 * Count all the liked answer , where status = 1
	 * 
	 * @param status
	 * @return
	 */
	@Query("select count(c) from LikeDislikeAnswer c where c.status = :status")
	public Long countAllLikedAnswer(@Param("status") int status);

	/**
	 * Count all the disliked answer, where status = 2
	 * 
	 * @param status
	 * @return
	 */
	@Query("select count(c) from LikeDislikeAnswer c where c.status = :status")
	public Long countAllDislikedAnswer(@Param("status") int status);

	/**
	 * count all liked answer by answerId and status = 1
	 * 
	 * @param answerId
	 * @return
	 */
	@Query("select count(c) from LikeDislikeAnswer c where c.status = :status and c.answer.id = :id")
	public Long countAllLikedAnswerByAnswerId(@Param("status") int i, @Param("id") long answerId);

	/**
	 * Count all disliked answer by answerId and status = 2
	 * 
	 * @param i
	 * @param answerId
	 * @return
	 */
	@Query("select count(c) from LikeDislikeAnswer c where c.status = :status and c.answer.id = :id")
	public Long countAllDislikedAnswerByAnswerId(@Param("status") int i, @Param("id") long answerId);

	/**
	 * Count all the liked and disliked answer by answerId
	 * 
	 * @param answerId
	 * @return
	 */
	@Query("select count(c) from LikeDislikeAnswer c where c.answer.id = :id")
	public Long countLikedDislikedAnswerByAnswerId(@Param("id") long answerId);

	/**
	 * count all liked answer by userId and status = 1
	 * 
	 * @param userId
	 * @return
	 */

	@Query("select count(c) from LikeDislikeAnswer c where c.status = :status and c.user.id = :id")
	public Long countAllLikedAnswerByUserId(@Param("status") int i, @Param("id") long userId);

	/**
	 * Count all disliked answer by userId and status = 2
	 * 
	 * @param i
	 * @param userId
	 * @return
	 */
	@Query("select count(c) from LikeDislikeAnswer c where c.status = :status and c.user.id = :id")
	public Long countAllDislikedAnswerByUserId(@Param("status") int i, @Param("id") long userId);

	/**
	 * Count all the liked and disliked answer by userId
	 * 
	 * @param userId
	 * @return
	 */
	@Query("select count(c) from LikeDislikeAnswer c where c.user.id = :id")
	public Long countLikedDislikedAnswerByUserId(@Param("id") long userId);

	public LikeDislikeAnswer findByUserIdAndAnswerIdAndStatus(long userId, long answerId, int i);

}
