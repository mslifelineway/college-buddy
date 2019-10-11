package com.codinghub.collegebuddy.services;

import java.util.Collection;
import java.util.Optional;

import com.codinghub.collegebuddy.domain.Blog;

public interface BlogService {

	/**
	 * save a blog
	 * 
	 * @param blog
	 * @return
	 */
	public Blog saveBlog(Blog blog);

	/**
	 * Update a Blog
	 * 
	 * @param Blog
	 * @return
	 */
	public Blog updateBlog(Blog blog);

	/**
	 * Delete a Blog by blogId
	 * 
	 * @param blogId
	 * @return
	 */
	public boolean deleteBlogById(Long blogId);

	/**
	 * Count all the Blogs present in the Blogs entity
	 * 
	 * @return
	 */
	public long countAllBlogs();

	/**
	 * counting all the Blogs of a particualr user or by userId
	 * 
	 * @param userId
	 * @return
	 */
	public long countAllBlogsByUserId(long userId);

	/**
	 * Finding all the Blogs present in the Blogs Entity
	 * 
	 * @return
	 */
	public Iterable<Blog> findAllBlogs();

	/**
	 * Finding Blog by a Blog Id
	 * 
	 * @param BlogId
	 * @return
	 */
	public Optional<Blog> findBlogById(long BlogId);

	/**
	 * Finding All the Blogs of a particular user or by userId
	 * 
	 * @param userId
	 * @return
	 */
	public Collection<Blog> findAllBlogsByUserId(long userId);
	
	/**
	 * Finding All the Blogs of a particular college or by collegeId
	 * 
	 * @param collegeId
	 * @return
	 */
	public Collection<Blog> findAllBlogsByCollegeId(long collegeId);

	
}
