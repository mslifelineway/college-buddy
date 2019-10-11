package com.codinghub.collegebuddy.services;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codinghub.collegebuddy.domain.LikeDislikeBlog;
import com.codinghub.collegebuddy.repositories.LikeDislikeBlogRepository;
import com.codinghub.collegebuddy.utils.ConstantRequired;

@Service
public class LikeDislikeBlogServiceImplementation implements LikeDislikeBlogService {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private LikeDislikeBlogRepository likeDislikeBlogRepo;

	@Override
	public LikeDislikeBlog likeDislikeBlog(LikeDislikeBlog likeDislikeBlog) {
		if (likeDislikeBlog != null)
			return likeDislikeBlogRepo.save(likeDislikeBlog);
		return null;
	}

	@Override
	public Long countAllLikedBlogs() {
		return likeDislikeBlogRepo.countAllLikedBlog(ConstantRequired.USER_LIKED_BLOG_ALREADY);
	}

	@Override
	public Long countAllDislikedBlogs() {
		return likeDislikeBlogRepo.countAllDislikedBlog(ConstantRequired.USER_DISLIKED_ANSWER_ALREADY);
	}

	@Override
	public Long countLikedDislikedBlog() {
		return likeDislikeBlogRepo.count();
	}

	@Override
	public Long countAllLikedBlogsByBlogId(long blogId) {
		if (blogId != 0)
			return likeDislikeBlogRepo.countAllLikedBlogsByBlogId(ConstantRequired.USER_LIKED_BLOG_ALREADY, blogId);
		return null;
	}

	@Override
	public Long countAllDislikedBlogsByBlogId(long blogId) {
		if (blogId != 0)
			return likeDislikeBlogRepo.countAllDislikedBlogsByBlogId(ConstantRequired.USER_DISLIKED_BLOG_ALREADY,
					blogId);
		return null;
	}

	@Override
	public Long countLikedDislikedBlogsByBlogId(long blogId) {
		if (blogId != 0)
			return likeDislikeBlogRepo.countLikedDislikedBlogsByBlogId(blogId);
		return null;
	}

	@Override
	public Long countAllLikedBlogsByUserId(long userId) {
		if (userId != 0)
			return likeDislikeBlogRepo.countAllLikedBlogsByUserId(ConstantRequired.USER_LIKED_BLOG_ALREADY, userId);
		return null;
	}

	@Override
	public Long countAllDislikedBlogsByUserId(long userId) {
		if (userId != 0)
			return likeDislikeBlogRepo.countAllDislikedBlogsByUserId(ConstantRequired.USER_DISLIKED_BLOG_ALREADY,
					userId);
		return null;
	}

	@Override
	public Long countLikedDislikedBlogsByUserId(long userId) {
		if (userId != 0)
			return likeDislikeBlogRepo.countLikedDislikedBlogsByUserId(userId);
		return null;
	}

	@Override
	public boolean isUserAlreadyLikedThisBlog(long userId, long blogId) {
		LikeDislikeBlog ld = (LikeDislikeBlog) likeDislikeBlogRepo.findByUserIdAndBlogIdAndStatus(userId, blogId,
				ConstantRequired.USER_LIKED_BLOG_ALREADY);
		if (ld == null)
			return false;
		else
			return true;
	}

	@Override
	public boolean isUserAlreadyDisLikedThisBlog(long userId, long blogId) {
		LikeDislikeBlog ld = (LikeDislikeBlog) likeDislikeBlogRepo.findByUserIdAndBlogIdAndStatus(userId, blogId,
				ConstantRequired.USER_DISLIKED_BLOG_ALREADY);
		if (ld == null)
			return false;
		else
			return true;
	}

	@Override
	public LikeDislikeBlog findUserAlreadyLikedThisBlog(long userId, long blogId) {
		return (LikeDislikeBlog) likeDislikeBlogRepo.findByUserIdAndBlogIdAndStatus(userId, blogId,
				ConstantRequired.USER_LIKED_BLOG_ALREADY);
	}

	@Override
	public LikeDislikeBlog findUserAlreadyDisLikedThisBlog(long userId, long blogId) {
		return (LikeDislikeBlog) likeDislikeBlogRepo.findByUserIdAndBlogIdAndStatus(userId, blogId,
				ConstantRequired.USER_DISLIKED_BLOG_ALREADY);
	}

	@Override
	public Collection<LikeDislikeBlog> findLikeDislikeBlogsByBlogId(long blogId) {
		if(blogId == 0)
			return null;
		return likeDislikeBlogRepo.findByBlogId(blogId);
	}

	@Override
	public void deleteAllByIds(Collection<Long> ids) {
		if(ids.size() != 0)
			likeDislikeBlogRepo.deleteByIdIn((List<Long>) ids);
	}

}
