package com.codinghub.collegebuddy.services;

import java.util.Collection;

import com.codinghub.collegebuddy.domain.LikeDislikeBlog;

public interface LikeDislikeBlogService {

	public LikeDislikeBlog likeDislikeBlog(LikeDislikeBlog likeDislikeBlog);

	public Long countAllLikedBlogs();

	public Long countAllDislikedBlogs();

	public Long countLikedDislikedBlog();

	public Long countAllLikedBlogsByBlogId(long blogId);

	public Long countAllDislikedBlogsByBlogId(long blogId);

	public Long countLikedDislikedBlogsByBlogId(long blogId);

	public Long countAllLikedBlogsByUserId(long userId);

	public Long countAllDislikedBlogsByUserId(long userId);

	public Long countLikedDislikedBlogsByUserId(long userId);

	public boolean isUserAlreadyLikedThisBlog(long userId, long blogId);

	public boolean isUserAlreadyDisLikedThisBlog(long userId, long blogId);

	public LikeDislikeBlog findUserAlreadyLikedThisBlog(long userId, long blogId);

	public LikeDislikeBlog findUserAlreadyDisLikedThisBlog(long userId, long blogId);
	
	public Collection<LikeDislikeBlog> findLikeDislikeBlogsByBlogId(long blogId);

	public void deleteAllByIds(Collection<Long> ids);

}
