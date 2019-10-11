package com.codinghub.collegebuddy.commands;

import java.util.List;

import com.codinghub.collegebuddy.domain.Answer;
import com.codinghub.collegebuddy.domain.AnswerCode;
import com.codinghub.collegebuddy.domain.Question;
import com.codinghub.collegebuddy.domain.QuestionCode;

public class WriteAnAnswer {

	private FileUploadCommand fileUploadCommand;

	private List<AnswerCode> codeList;

	private Question question;

	private Answer answer;

	public FileUploadCommand getFileUploadCommand() {
		return fileUploadCommand;
	}

	public void setFileUploadCommand(FileUploadCommand fileUploadCommand) {
		this.fileUploadCommand = fileUploadCommand;
	}

	public List<AnswerCode> getCodeList() {
		return codeList;
	}

	public void setCodeList(List<AnswerCode> codeList) {
		this.codeList = codeList;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "WriteAnAnswer [fileUploadCommand=" + fileUploadCommand + ", codeList=" + codeList + ", question="
				+ question + ", answer=" + answer + "]";
	}

}
