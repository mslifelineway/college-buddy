package com.codinghub.collegebuddy.embeddable;

import javax.persistence.Embeddable;

@Embeddable
public class BlogEmbedded {

	private Long totalLikedBlog;

	private Long totalDislikedBlog;

	private int blogStatus; /// liked or disliked for liked value = 1 , and for disliked value = 2

	public Long getTotalLikedBlog() {
		return totalLikedBlog;
	}

	public void setTotalLikedBlog(Long totalLikedBlog) {
		this.totalLikedBlog = totalLikedBlog;
	}

	public Long getTotalDislikedBlog() {
		return totalDislikedBlog;
	}

	public void setTotalDislikedBlog(Long totalDislikedBlog) {
		this.totalDislikedBlog = totalDislikedBlog;
	}

	public int getBlogStatus() {
		return blogStatus;
	}

	public void setBlogStatus(int blogStatus) {
		this.blogStatus = blogStatus;
	}

	@Override
	public String toString() {
		return "BlogEmbedded [totalLikedBlog=" + totalLikedBlog + ", totalDislikedBlog=" + totalDislikedBlog
				+ ", blogStatus=" + blogStatus + "]";
	}

}
