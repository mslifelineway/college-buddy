package com.codinghub.collegebuddy.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.codinghub.collegebuddy.embeddable.BlogEmbedded;

@Entity(name = "blogs")
@Table(name = "blogs")
public class Blog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "blog_id")
	private Long id;

	@Lob
	@Column(name = "blog_title")
	private String title;

	@Lob
	@Column(name = "blog_desc")
	private String desc;

	@Column(name = "blog_shared")
	private Long shared = (long) 0;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "written_on")
	private Date writtenOn;

	@Transient
	@Embedded
	private BlogEmbedded blogEmbedded;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "college_id")
	private College college;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	/**
	 * a blog may have more like or dislike
	 */
	@OneToMany(mappedBy = "blog")
	private Set<LikeDislikeBlog> likedDisLikedBlogs;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Long getShared() {
		return shared;
	}

	public void setShared(Long shared) {
		this.shared = shared;
	}

	public Date getWrittenOn() {
		return writtenOn;
	}

	public void setWrittenOn(Date writtenOn) {
		this.writtenOn = writtenOn;
	}

	public BlogEmbedded getBlogEmbedded() {
		return blogEmbedded;
	}

	public void setBlogEmbedded(BlogEmbedded blogEmbedded) {
		this.blogEmbedded = blogEmbedded;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<LikeDislikeBlog> getLikedDisLikedBlogs() {
		return likedDisLikedBlogs;
	}

	public void setLikedDisLikedBlogs(Set<LikeDislikeBlog> likedDisLikedBlogs) {
		this.likedDisLikedBlogs = likedDisLikedBlogs;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", desc=" + desc + ", shared=" + shared + ", writtenOn="
				+ writtenOn + "]";
	}

}
