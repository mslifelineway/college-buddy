package com.codinghub.collegebuddy.embeddable;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Embeddable;

import com.codinghub.collegebuddy.domain.FollowQuestion;

@Embeddable
public class QuestionEmbedded {

	private Long countAQuestionFollowed;

	private Long countAQuestionAnswered;

	private Collection<FollowQuestion> followedQuestions = new ArrayList<FollowQuestion>();

	private Integer userFollowThisQuestion; /// if value = 0 then not following , if value = 1 then following

	public Long getCountAQuestionFollowed() {
		return countAQuestionFollowed;
	}

	public void setCountAQuestionFollowed(Long countAQuestionFollowed) {
		this.countAQuestionFollowed = countAQuestionFollowed;
	}

	public Long getCountAQuestionAnswered() {
		return countAQuestionAnswered;
	}

	public void setCountAQuestionAnswered(Long countAQuestionAnswered) {
		this.countAQuestionAnswered = countAQuestionAnswered;
	}

	public Collection<FollowQuestion> getFollowedQuestions() {
		return followedQuestions;
	}

	public void setFollowedQuestions(Collection<FollowQuestion> followedQuestions) {
		this.followedQuestions = followedQuestions;
	}

	public Integer getUserFollowThisQuestion() {
		return userFollowThisQuestion;
	}

	public void setUserFollowThisQuestion(Integer userFollowThisQuestion) {
		this.userFollowThisQuestion = userFollowThisQuestion;
	}

	@Override
	public String toString() {
		return "QuestionEmbedded [countAQuestionFollowed=" + countAQuestionFollowed + ", countAQuestionAnswered="
				+ countAQuestionAnswered + ", followedQuestions=" + followedQuestions + ", UserFollowThisQuestion="
				+ userFollowThisQuestion + "]";
	}

}
