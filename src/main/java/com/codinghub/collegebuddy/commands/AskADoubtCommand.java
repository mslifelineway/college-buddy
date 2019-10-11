package com.codinghub.collegebuddy.commands;

import java.util.List;

import com.codinghub.collegebuddy.domain.Question;
import com.codinghub.collegebuddy.domain.QuestionCode;

public class AskADoubtCommand {

	private FileUploadCommand fileUploadCommand;

	private List<QuestionCode> codeList;

	private Question question;

	public FileUploadCommand getFileUploadCommand() {
		return fileUploadCommand;
	}

	public void setFileUploadCommand(FileUploadCommand fileUploadCommand) {
		this.fileUploadCommand = fileUploadCommand;
	}

	public List<QuestionCode> getCodeList() {
		return codeList;
	}

	public void setCodeList(List<QuestionCode> codeList) {
		this.codeList = codeList;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "AskADoubtCommand [fileUploadCommand=" + fileUploadCommand + ", codeList=" + codeList + ", question="
				+ question + "]";
	}

}
