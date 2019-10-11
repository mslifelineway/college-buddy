package com.codinghub.collegebuddy.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "question_codes")
@Table(name = "question_codes")
public class QuestionCode {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "question_code_id")
	private Long Id;

	@Column(name = "code_title")
	private String codeTitle;

	@Lob
	@Column(name = "code_desc")
	private String codeDesc;

	/**
	 * A single Question may have many Question codes or question file So
	 * cardinality between Question And QuestionCode ==> OneToMany and in between
	 * QuestionCode And Question ==> ManyToOne
	 * 
	 * @return
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "question_id", nullable = false)
	private Question question;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getCodeTitle() {
		return codeTitle;
	}

	public void setCodeTitle(String codeTitle) {
		this.codeTitle = codeTitle;
	}

	public String getCodeDesc() {
		return codeDesc;
	}

	public void setCodeDesc(String codeDesc) {
		this.codeDesc = codeDesc;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "QuestionCode [Id=" + Id + ", codeTitle=" + codeTitle + ", codeDesc=" + codeDesc + "]";
	}

}
