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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.codinghub.collegebuddy.embeddable.QuestionEmbedded;

@Entity(name = "questions")
@Table(name = "questions")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "question_id")
	private Long id;

	@Lob
	@Column(name = "question", length = 1000000)
	private String question;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "asked_on")
	private Date date;

	@Column(name = "question_shared")
	private Long shared = (long) 0;

	@Transient
	@Embedded
	private QuestionEmbedded questionEmbedded;

	/**
	 * A single Question may have many answer So cardinality between Question And
	 * Answer ==> OneToMany and in between Answer And Question ==> ManyToOne
	 * 
	 * @return
	 */
	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Collection<Answer> answers = new ArrayList<Answer>();

	/**
	 * A single User may have many Question So cardinality between User And Question
	 * ==> OneToMany and in between Question And User ==> ManyToOne
	 * 
	 * @return
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	/**
	 * A single Question may have many question codes or question file So
	 * cardinality between Question And QuestionCode ==> OneToMany and in between
	 * QuestionCode And Question ==> ManyToOne
	 * 
	 * @return
	 */
	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Collection<QuestionCode> questionCodes = new ArrayList<QuestionCode>();

	/**
	 * A single Question may have many question codes or question file So
	 * cardinality between Question And QuestionFile ==> OneToMany and in between
	 * QuestionFile And Question ==> ManyToOne
	 * 
	 * @return
	 */
	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Collection<QuestionFile> questionFiles = new ArrayList<QuestionFile>();

	@OneToMany(mappedBy = "question")
	private Set<FollowQuestion> followQuestions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getShared() {
		return shared;
	}

	public void setShared(Long shared) {
		this.shared = shared;
	}

	public QuestionEmbedded getQuestionEmbedded() {
		return questionEmbedded;
	}

	public void setQuestionEmbedded(QuestionEmbedded questionEmbedded) {
		this.questionEmbedded = questionEmbedded;
	}

	public Collection<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Collection<Answer> answers) {
		this.answers = answers;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Collection<QuestionCode> getQuestionCodes() {
		return questionCodes;
	}

	public void setQuestionCodes(Collection<QuestionCode> questionCodes) {
		this.questionCodes = questionCodes;
	}

	public Collection<QuestionFile> getQuestionFiles() {
		return questionFiles;
	}

	public void setQuestionFiles(Collection<QuestionFile> questionFiles) {
		this.questionFiles = questionFiles;
	}

	public Set<FollowQuestion> getFollowQuestions() {
		return followQuestions;
	}

	public void setFollowQuestions(Set<FollowQuestion> followQuestions) {
		this.followQuestions = followQuestions;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", date=" + date + ", shared=" + shared + "]";
	}

}
