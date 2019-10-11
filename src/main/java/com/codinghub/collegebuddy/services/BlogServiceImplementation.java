package com.codinghub.collegebuddy.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codinghub.collegebuddy.domain.Blog;
import com.codinghub.collegebuddy.repositories.BlogRepository;

@Service
public class BlogServiceImplementation implements BlogService {

	@Autowired
	private BlogRepository blogRepo;

	@Override
	public Blog saveBlog(Blog blog) {
		if (blog != null)
			return blogRepo.save(blog);
		return null;
	}

	@Override
	public Blog updateBlog(Blog blog) {
		if (blog != null)
			return blogRepo.save(blog);
		return null;
	}

	@Override
	public boolean deleteBlogById(Long blogId) {
		if (blogId != 0) {
			blogRepo.deleteById(blogId);
			return true;
		}
		return false;
	}

	@Override
	public long countAllBlogs() {
		return blogRepo.count();
	}

	@Override
	public long countAllBlogsByUserId(long userId) {
		return blogRepo.countAllByUserId(userId);
	}

	@Override
	public Iterable<Blog> findAllBlogs() {
		return blogRepo.findAll();
	}

	@Override
	public Optional<Blog> findBlogById(long BlogId) {
		if (BlogId != 0)
			return blogRepo.findById(BlogId);
		return null;
	}

	@Override
	public Collection<Blog> findAllBlogsByUserId(long userId) {
		if (userId != 0)
			return blogRepo.findAllByUserId(userId);
		return null;
	}

	@Override
	public Collection<Blog> findAllBlogsByCollegeId(long collegeId) {
		if (collegeId != 0)
			return blogRepo.findAllByCollegeId(collegeId);
		return null;
	}
}
