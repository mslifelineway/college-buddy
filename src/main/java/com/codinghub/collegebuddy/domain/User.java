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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.codinghub.collegebuddy.utils.ConstantRequired;

@NamedQueries({ @NamedQuery(name = "User.findByUsernameEmailAndPassword", query = "SELECT u FROM users u "
		+ "WHERE (u.username=:username OR u.email=:email) AND u.password = :password")

})
@Entity(name = "users")
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;

	@Column(name = "user_name")
	private String name;

	@Column(name = "username", unique = true)
	private String username;

	@Column(name = "user_email", unique = true)
	private String email;

	@Column(name = "user_college")
	private String college;

	@Column(name = "college_url", nullable = true)
	private String collegeLink;

	@Column(name = "user_password")
	private String password;

	@Column(name = "user_profession")
	private String profession;

	@Column(name = "user_about", nullable = true)
	private String about;

	@Column(name = "profile_image")
	private String image = ConstantRequired.DEFAULT_USER_PROFILE_IMAGE;

	@Column(name = "cover_image")
	private String coverImage = ConstantRequired.DEFAULT_USER_COVER_IMAGE;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "reg_date")
	private Date regDate;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(unique = true, name = "default_college_id")
	private College defaultCollege;

	/**
	 * A single user may write many answer for a question So cardinality between
	 * User And Answer ==> OneToMany and in between Answer And User ==> ManyToOne
	 * 
	 * @return
	 */
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Collection<Answer> answers = new ArrayList<Answer>();

	/**
	 * A single User may have many Question So cardinality between User And Question
	 * ==> OneToMany and in between Question And User ==> ManyToOne
	 * 
	 * @return
	 */
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Collection<Question> questions = new ArrayList<Question>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Collection<College> colleges = new ArrayList<College>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Collection<Blog> blogs = new ArrayList<Blog>();

	@OneToMany(mappedBy = "user")
	private Set<LikeDislikeBlog> likedDisLikedBlogs;

	@OneToMany(mappedBy = "user")
	private Set<FollowQuestion> followQuestions;

	@OneToMany(mappedBy = "user")
	private Set<LikeDislikeAnswer> likedDisLikedAnswers;

	@OneToMany(mappedBy = "user")
	private Set<JoinCollege> joinCollege;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Collection<UserSkill> userSkills;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private OtherAccount otherAccount;

	public Set<LikeDislikeBlog> getLikedDisLikedBlogs() {
		return likedDisLikedBlogs;
	}

	public void setLikedDisLikedBlogs(Set<LikeDislikeBlog> likedDisLikedBlogs) {
		this.likedDisLikedBlogs = likedDisLikedBlogs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long Id) {
		id = Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String Name) {
		name = Name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCollegeLink() {
		return collegeLink;
	}

	public void setCollegeLink(String collegeLink) {
		this.collegeLink = collegeLink;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public void setOtherAccount(OtherAccount otherAccount) {
		this.otherAccount = otherAccount;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public Collection<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Collection<Answer> answers) {
		this.answers = answers;
	}

	public Collection<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Collection<Question> questions) {
		this.questions = questions;
	}

	public Collection<College> getColleges() {
		return colleges;
	}

	public void setColleges(Collection<College> colleges) {
		this.colleges = colleges;
	}

	public Collection<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(Collection<Blog> blogs) {
		this.blogs = blogs;
	}

	public Set<FollowQuestion> getFollowQuestions() {
		return followQuestions;
	}

	public void setFollowQuestions(Set<FollowQuestion> followQuestions) {
		this.followQuestions = followQuestions;
	}

	public College getDefaultCollege() {
		return defaultCollege;
	}

	public void setDefaultCollege(College defaultCollege) {
		this.defaultCollege = defaultCollege;
	}

	public Set<LikeDislikeAnswer> getLikedDisLikedAnswers() {
		return likedDisLikedAnswers;
	}

	public void setLikedDisLikedAnswers(Set<LikeDislikeAnswer> likedDisLikedAnswers) {
		this.likedDisLikedAnswers = likedDisLikedAnswers;
	}

	public Set<JoinCollege> getJoinCollege() {
		return joinCollege;
	}

	public void setJoinCollege(Set<JoinCollege> joinCollege) {
		this.joinCollege = joinCollege;
	}

	public Collection<UserSkill> getUserSkills() {
		return userSkills;
	}

	public void setUserSkills(Collection<UserSkill> userSkills) {
		this.userSkills = userSkills;
	}

	public OtherAccount getOtherAccount() {
		return otherAccount;
	}

	public void setOtherAccounts(OtherAccount otherAccount) {
		this.otherAccount = otherAccount;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", email=" + email + ", college="
				+ college + ", collegeLink=" + collegeLink + ", password=" + password + ", profession=" + profession
				+ ", about=" + about + ", image=" + image + ", coverImage=" + coverImage + ", regDate=" + regDate
				+ ", defaultCollege=" + defaultCollege + "]";
	}

}
