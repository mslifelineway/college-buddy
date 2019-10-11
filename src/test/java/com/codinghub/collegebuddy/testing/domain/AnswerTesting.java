package com.codinghub.collegebuddy.testing.domain;

import java.util.Collection;
import java.util.Date;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.codinghub.collegebuddy.domain.Answer;
import com.codinghub.collegebuddy.domain.Question;
import com.codinghub.collegebuddy.domain.User;
import com.codinghub.collegebuddy.embeddable.QuestionEmbedded;
import com.codinghub.collegebuddy.repositories.AnswerRepository;
import com.codinghub.collegebuddy.services.AnswerService;
import com.codinghub.collegebuddy.services.QuestionService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class AnswerTesting {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private AnswerService answerService;

	@Autowired
	private AnswerRepository answerRepo;

	@Test
	public void test() {

		/// count the answers of bulk of questions
//		countAnswersByQuestions();

		//// save an answer of a question
		saveAnswer();
	}

	private void saveAnswer() {
		User u = new User();
		Question q = new Question();
		Long questionId = (long) 3;
		Long userId = (long) 6;
		u.setId(userId);
		q.setId(questionId);
		Answer a = new Answer();
		a.setAnswer(" Second Answer for the same question from userid: 6. This paragraph will include the pho cloud computing to work with google and microsoft "
				+ "database to manage and modify working with lots of project. cloud computing to work with"
				+ " google and microsoft database to manage and modify working with lots of project. "
				+ "This paragraph will include the pho cloud computing to work with google and microsoft "
				+ "database to manage and modify working with lots of project. cloud computing to work with"
				+ " google and microsoft database to manage and modify working with lots of project. This paragraph"
				+ " will include the pho cloud computing to work with google and microsoft database to manage"
				+ " and modify working with lots of project. cloud computing to work with google and microsoft "
				+ "database to manage and modify working with lots of project. This paragraph will include the"
				+ " pho cloud computing to work with google and microsoft database to manage and modify working"
				+ " with lots of project. cloud computing to work with google and microsoft database to manage "
				+ "and modify working with lots of project.");
		a.setDate(new Date());
		a.setUser(u);
		a.setQuestion(q);
		Answer answer = answerService.saveAnswer(a);
		if(answer == null)
			System.out.println("answer not saved!");
		else
			System.out.println("answer saved successfully! and the saved answer is : \n\n "+ answer);

	}

	private void countAnswersByQuestions() {
		Collection<Question> questions = (Collection<Question>) questionService.findAllQuestions();
		if (questions.size() == 0)
			System.out.println("No Question Found!");
		else {

			QuestionEmbedded qe = new QuestionEmbedded();

			for (Question q : questions) {
				Long count = answerService.countAllAnswersByQuestionId(q.getId());
				System.out.println("\n\n----- count : " + count);
				qe.setCountAQuestionAnswered(count);

				q.setQuestionEmbedded(qe);
			}

			System.out.println("FINAL OUTPUT : \n\n");
			for (Question q : questions) {
				System.out.println("\n" + q.getQuestionEmbedded().getCountAQuestionAnswered());

			}
		}

	}

}
