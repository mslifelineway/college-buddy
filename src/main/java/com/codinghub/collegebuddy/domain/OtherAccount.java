package com.codinghub.collegebuddy.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "other_account")
@Table(name = "other_account")
public class OtherAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "other_account_id")
	private Long id;

	@Lob
	@Column(name = "facebook_url")
	private String facebookUrl;

	@Lob
	@Column(name = "google_url")
	private String googleUrl;

	@Lob
	@Column(name = "twitter_url")
	private String twitterUrl;

	@Lob
	@Column(name = "linkedin_url")
	private String linkedinUrl;

	@Lob
	@Column(name = "quora_url")
	private String quoraUrl;

	@Lob
	@Column(name = "youtube_url")
	private String youtubeUrl;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFacebookUrl() {
		return facebookUrl;
	}

	public void setFacebookUrl(String facebookUrl) {
		this.facebookUrl = facebookUrl;
	}

	public String getGoogleUrl() {
		return googleUrl;
	}

	public void setGoogleUrl(String googleUrl) {
		this.googleUrl = googleUrl;
	}

	public String getTwitterUrl() {
		return twitterUrl;
	}

	public void setTwitterUrl(String twitterUrl) {
		this.twitterUrl = twitterUrl;
	}

	public String getLinkedinUrl() {
		return linkedinUrl;
	}

	public void setLinkedinUrl(String linkedinUrl) {
		this.linkedinUrl = linkedinUrl;
	}

	public String getQuoraUrl() {
		return quoraUrl;
	}

	public void setQuoraUrl(String quoraUrl) {
		this.quoraUrl = quoraUrl;
	}

	public String getYoutubeUrl() {
		return youtubeUrl;
	}

	public void setYoutubeUrl(String youtubeUrl) {
		this.youtubeUrl = youtubeUrl;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "OtherAccount [id=" + id + ", facebookUrl=" + facebookUrl + ", googleUrl=" + googleUrl + ", twitterUrl="
				+ twitterUrl + ", linkedinUrl=" + linkedinUrl + ", quoraUrl=" + quoraUrl + ", youtubeUrl=" + youtubeUrl
				+ "]";
	}

}
