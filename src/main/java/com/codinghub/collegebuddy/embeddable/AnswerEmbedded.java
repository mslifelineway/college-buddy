package com.codinghub.collegebuddy.embeddable;

import javax.persistence.Embeddable;

@Embeddable
public class AnswerEmbedded {

	private Long totalLikedAnswer;

	private Long totalDislikedAnswer;

	private int answerStatus; /// liked or disliked for liked value = 1 , and for disliked value = 2

	public Long getTotalLikedAnswer() {
		return totalLikedAnswer;
	}

	public void setTotalLikedAnswer(Long totalLikedAnswer) {
		this.totalLikedAnswer = totalLikedAnswer;
	}

	public Long getTotalDislikedAnswer() {
		return totalDislikedAnswer;
	}

	public void setTotalDislikedAnswer(Long totalDislikedAnswer) {
		this.totalDislikedAnswer = totalDislikedAnswer;
	}

	public int getAnswerStatus() {
		return answerStatus;
	}

	public void setAnswerStatus(int answerStatus) {
		this.answerStatus = answerStatus;
	}

	@Override
	public String toString() {
		return "AnswerEmbedded [totalLikedAnswer=" + totalLikedAnswer + ", totalDislikedAnswer=" + totalDislikedAnswer
				+ ", answerStatus=" + answerStatus + "]";
	}

}
