package com.codinghub.collegebuddy.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codinghub.collegebuddy.domain.LikeDislikeAnswer;
import com.codinghub.collegebuddy.repositories.LikeDislikeAnswerRepository;
import com.codinghub.collegebuddy.utils.ConstantRequired;

@Service
public class LikeDislikeAnswerServiceImplementation implements LikeDislikeAnswerService {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private LikeDislikeAnswerRepository likeDislikeAnswerRepo;

	@Override
	public LikeDislikeAnswer likeDislikeAnswer(LikeDislikeAnswer likeDislikeAnswer) {
		if (likeDislikeAnswer != null)
			return likeDislikeAnswerRepo.save(likeDislikeAnswer);
		return null;
	}

	@Override
	public Long countAllLikedAnswer() {
		return likeDislikeAnswerRepo.countAllLikedAnswer(ConstantRequired.USER_LIKED_ANSWER_ALREADY);
	}

	@Override
	public Long countAllDislikedAnswer() {
		return likeDislikeAnswerRepo.countAllDislikedAnswer(ConstantRequired.USER_DISLIKED_ANSWER_ALREADY);
	}

	@Override
	public Long countLikedDislikedAnswer() {
		return likeDislikeAnswerRepo.count();
	}

	@Override
	public Long countAllLikedAnswerByAnswerId(long answerId) {
		return likeDislikeAnswerRepo.countAllLikedAnswerByAnswerId(ConstantRequired.USER_LIKED_ANSWER_ALREADY, answerId); // status = 1 for like
	}

	@Override
	public Long countAllDislikedAnswerByAnswerId(long answerId) {
		return likeDislikeAnswerRepo.countAllDislikedAnswerByAnswerId(ConstantRequired.USER_DISLIKED_ANSWER_ALREADY, answerId); /// status = 2 for dislike
	}

	@Override
	public Long countLikedDislikedAnswerByAnswerId(long answerId) {
		return likeDislikeAnswerRepo.countLikedDislikedAnswerByAnswerId(answerId);
	}

	@Override
	public Long countAllLikedAnswerByUserId(long userId) {
		return likeDislikeAnswerRepo.countAllLikedAnswerByUserId(ConstantRequired.USER_LIKED_ANSWER_ALREADY, userId);
	}

	@Override
	public Long countAllDislikedAnswerByUserId(long userId) {
		return likeDislikeAnswerRepo.countAllDislikedAnswerByUserId(ConstantRequired.USER_DISLIKED_ANSWER_ALREADY, userId);
	}

	@Override
	public Long countLikedDislikedAnswerByUserId(long userId) {
		return likeDislikeAnswerRepo.countLikedDislikedAnswerByUserId(userId);
	}

	@Override
	public boolean isUserAlreadyLikedAnswer(long userId, long answerId) {

		LikeDislikeAnswer ld = (LikeDislikeAnswer) likeDislikeAnswerRepo.findByUserIdAndAnswerIdAndStatus(userId,
				answerId, ConstantRequired.USER_LIKED_ANSWER_ALREADY);
		if (ld == null)
			return false;
		else
			return true;
	}

	@Override
	public boolean isUserAlreadyDisLikedAnswer(long userId, long answerId) {
		LikeDislikeAnswer ld = (LikeDislikeAnswer) likeDislikeAnswerRepo.findByUserIdAndAnswerIdAndStatus(userId,
				answerId, ConstantRequired.USER_DISLIKED_ANSWER_ALREADY);
		if (ld == null)
			return false;
		else
			return true;
	}

	@Override
	public LikeDislikeAnswer findUserAlreadyLikedAnswer(long userId, long answerId) {
		LikeDislikeAnswer ld = (LikeDislikeAnswer) likeDislikeAnswerRepo.findByUserIdAndAnswerIdAndStatus(userId,
				answerId, ConstantRequired.USER_LIKED_ANSWER_ALREADY);
		if(ld != null)
			return ld;
		return null;
	}

	@Override
	public LikeDislikeAnswer findUserAlreadyDisLikedAnswer(long userId, long answerId) {
		LikeDislikeAnswer ld = (LikeDislikeAnswer) likeDislikeAnswerRepo.findByUserIdAndAnswerIdAndStatus(userId,
				answerId, ConstantRequired.USER_DISLIKED_ANSWER_ALREADY);
		if(ld != null)
			return ld;
		return null;
	}

}
