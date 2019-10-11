package com.codinghub.collegebuddy.services;

import com.codinghub.collegebuddy.domain.LikeDislikeAnswer;

public interface LikeDislikeAnswerService {

	/**
	 * An answer is determined by status if status=1 => liked, if status=2 =>
	 * disliked
	 * 
	 * @param likeDislikeAnswerService
	 * @return
	 */
	public LikeDislikeAnswer likeDislikeAnswer(LikeDislikeAnswer likeDislikeAnswer);

	/**
	 * Counting all the liked answer i.e. where status=1
	 * 
	 * @return
	 */
	public Long countAllLikedAnswer();

	/**
	 * count all the disliked answer i.e. where status=2
	 * 
	 * @return
	 */
	public Long countAllDislikedAnswer();

	/**
	 * Counting all the liked and disliked answer where status = ?
	 * 
	 * @return
	 */
	public Long countLikedDislikedAnswer();

	/**
	 * Counting all the liked answer i.e. where status=1 and answerId =?
	 * 
	 * @return
	 */
	public Long countAllLikedAnswerByAnswerId(long answerId);

	/**
	 * count all the disliked answer i.e. where status=2 and answerId = ?
	 * 
	 * @return
	 */
	public Long countAllDislikedAnswerByAnswerId(long answerId);

	/**
	 * Counting all the liked and disliked answer where status = ? and answerId = ?
	 * 
	 * @return
	 */
	public Long countLikedDislikedAnswerByAnswerId(long answerId);

	/**
	 * Counting all the liked answer i.e. where status=1 , and userId = ?
	 * 
	 * @return
	 */
	public Long countAllLikedAnswerByUserId(long userId);

	/**
	 * count all the disliked answer i.e. where status=2 , and userId = ?
	 * 
	 * @return
	 */
	public Long countAllDislikedAnswerByUserId(long userId);

	/**
	 * Counting all the liked and disliked answer where status = ? , and userId = ?
	 * 
	 * @return
	 */
	public Long countLikedDislikedAnswerByUserId(long userId);

	/**
	 * user already liked an answer
	 * 
	 * @param userId
	 * @param answerId
	 * @return
	 */
	public boolean isUserAlreadyLikedAnswer(long userId, long answerId);

	/**
	 * Is user already already disliked an answer
	 * 
	 * @param userId
	 * @param answerId
	 * @return
	 */
	public boolean isUserAlreadyDisLikedAnswer(long userId, long answerId);

	/**
	 * Find answer liked by userId and answerId
	 * 
	 * @param userId
	 * @param answerId
	 * @return LikeDislikeAnswer
	 */
	public LikeDislikeAnswer findUserAlreadyLikedAnswer(long userId, long answerId);

	/**
	 * Find answer disliked by userId and answerId
	 * 
	 * @param userId
	 * @param answerId
	 * @return LikeDislikeAnswer
	 */
	public LikeDislikeAnswer findUserAlreadyDisLikedAnswer(long userId, long answerId);

}
