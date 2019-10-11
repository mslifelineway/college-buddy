package com.codinghub.collegebuddy.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.transaction.Transactional;

@Entity(name = "colleges")
@Table(name = "colleges")
public class College {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "college_id")
	private Long id;

	@Column(name = "college_name")
	private String collegeName;

	@Column(name = "profile_image")
	private String profileImage;

	@Column(name = "cover_image")
	private String coverImage;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "reg_date")
	private Date regDate;

	@Column(name = "college_about")
	private String about;

	@Column(name = "college_title")
	private String title;

	@Column(name = "college_status")
	private boolean isOpen; //// OPEN OR CLOSED ( true (1) for open , false (0) for close)

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@OneToMany(mappedBy = "college", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Collection<Blog> blogs = new ArrayList<Blog>();

	@OneToOne(mappedBy = "defaultCollege", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private User defaultUser;

	@OneToMany(mappedBy = "college")
	private Set<JoinCollege> joinCollege;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Collection<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(Collection<Blog> blogs) {
		this.blogs = blogs;
	}

	public User getDefaultUser() {
		return defaultUser;
	}

	public void setDefaultUser(User defaultUser) {
		this.defaultUser = defaultUser;
	}

	public Set<JoinCollege> getJoinCollege() {
		return joinCollege;
	}

	public void setJoinCollege(Set<JoinCollege> joinCollege) {
		this.joinCollege = joinCollege;
	}

	@Override
	public String toString() {
		return "College [id=" + id + ", collegeName=" + collegeName + ", profileImage=" + profileImage + ", coverImage="
				+ coverImage + ", regDate=" + regDate + ", about=" + about + ", title=" + title + ", isOpen=" + isOpen
				+ "]";
	}

}
