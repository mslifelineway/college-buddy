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

@Entity(name = "answer_codes")
@Table(name = "answer_codes")
public class AnswerCode {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "answer_code_id")
	private Long Id;

	@Column(name = "code_title")
	private String codeTitle;

	@Lob
	@Column(name = "code_desc")
	private String codeDesc;

	/**
	 * A single Answer may have many answer codes or answer file So cardinality
	 * between Answer And AnswerCode ==> OneToMany and in between AnswerCode And
	 * Answer ==> ManyToOne
	 * 
	 * @return
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "answer_id", nullable = false)
	private Answer answer;

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

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "AnswerCode [Id=" + Id + ", codeTitle=" + codeTitle + ", codeDesc=" + codeDesc + "]";
	}

}
