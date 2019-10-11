package com.codinghub.collegebuddy.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.codinghub.collegebuddy.embeddable.AnswerEmbedded;

@Entity(name = "answers")
@Table(name = "answers")
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "answer_id")
	private Long id;

	@Column(name = "answer", length = 1000000)
	private String answer;

	@Column(name = "answer_shared")
	private Long shared = (long) 0;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "answered_date")
	private Date date;

	@Transient
	@Embedded
	private AnswerEmbedded answerEmbedded;

	/**
	 * A single user may write many answer for a question So cardinality between
	 * User And Answer ==> OneToMany and in between Answer And User ==> ManyToOne
	 * 
	 * @return
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	/**
	 * A single Answer may have many answer codes or answer file So cardinality
	 * between Answer And AnswerCode ==> OneToMany and in between AnswerCode And
	 * Answer ==> ManyToOne
	 * 
	 * @return
	 */
	@OneToMany(mappedBy = "answer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Collection<AnswerCode> answerCodes = new ArrayList<AnswerCode>();

	/**
	 * A single Answer may have many answer codes or answer file So cardinality
	 * between Answer And AnswerFile ==> OneToMany and in between AnswerFile And
	 * Answer ==> ManyToOne
	 * 
	 * @return
	 */
	@OneToMany(mappedBy = "answer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Collection<AnswerFile> answerFiles = new ArrayList<AnswerFile>();

	/**
	 * A single Question may have many answer So cardinality between Question And
	 * Answer ==> OneToMany and in between Answer And Question ==> ManyToOne
	 * 
	 * @return
	 */
	@ManyToOne
	@JoinColumn(name = "question_id", nullable = false)
	private Question question;

	/**
	 * user can like or dislike any answer
	 */
	@OneToMany(mappedBy = "answer")
	private Set<LikeDislikeAnswer> likedDisLikedAnswers;

	public Long getId() {
		return id;
	}

	public void setId(Long Id) {
		id = Id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Long getShared() {
		return shared;
	}

	public void setShared(Long shared) {
		this.shared = shared;
	}

	public AnswerEmbedded getAnswerEmbedded() {
		return answerEmbedded;
	}

	public void setAnswerEmbedded(AnswerEmbedded answerEmbedded) {
		this.answerEmbedded = answerEmbedded;
	}

	public Set<LikeDislikeAnswer> getLikedDisLikedAnswers() {
		return likedDisLikedAnswers;
	}

	public void setLikedDisLikedAnswers(Set<LikeDislikeAnswer> likedDisLikedAnswers) {
		this.likedDisLikedAnswers = likedDisLikedAnswers;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Collection<AnswerCode> getAnswerCodes() {
		return answerCodes;
	}

	public void setAnswerCodes(Collection<AnswerCode> answerCodes) {
		this.answerCodes = answerCodes;
	}

	public Collection<AnswerFile> getAnswerFiles() {
		return answerFiles;
	}

	public void setAnswerFiles(Collection<AnswerFile> answerFiles) {
		this.answerFiles = answerFiles;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", answer=" + answer + ", shared=" + shared + ", date=" + date + "]";
	}

}
