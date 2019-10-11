package com.codinghub.collegebuddy.testing.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.codinghub.collegebuddy.domain.Question;
import com.codinghub.collegebuddy.domain.QuestionFile;
import com.codinghub.collegebuddy.domain.User;
import com.codinghub.collegebuddy.repositories.QuestionRepository;
import com.codinghub.collegebuddy.services.QuestionService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional ////add @Transactional annotation if you get error such as: could not initilize proxy - no session
public class QuestionTesting {

	@Autowired
	private QuestionRepository questionRepo;

	@Autowired
	private QuestionService questionService;

	@Test
	public void test() {

		/// saving a question

//		saveQuestion();

		//// update Question
//		updateQuestion();

		/// save all question
		saveAllQuestion();
		
		//// find questionById
//		findQuestionById();
		
		//// findAllQuestions
//		findAllQuestions();
		
		///save all the question files by questionId
//		saveAllQuestionFiles();
	}

	private void saveAllQuestionFiles() {
		Question q = new Question();
		q.setId((long) 1);
		Question q2 = new Question();
		q2.setId((long) 2);
		
		QuestionFile f1 = new QuestionFile();
		f1.setFileName("image11.jpg");
		f1.setFileSize(4000.00);
		f1.setFileType("image/jpg");
		f1.setQuestion(q);
		
		QuestionFile f2 = new QuestionFile();
		f2.setFileName("image12.jpg");
		f2.setFileSize(4000.00);
		f2.setFileType("image/jpg");
		f2.setQuestion(q);
		
		QuestionFile f3 = new QuestionFile();
		f3.setFileName("image13.jpg");
		f3.setFileSize(4000.00);
		f3.setFileType("image/jpg");
		f3.setQuestion(q);
		
		QuestionFile f4 = new QuestionFile();
		f4.setFileName("image21.jpg");
		f4.setFileSize(4000.00);
		f4.setFileType("image/jpg");
		f4.setQuestion(q2);
		
		QuestionFile f5 = new QuestionFile();
		f5.setFileName("image22.jpg");
		f5.setFileSize(4000.00);
		f5.setFileType("image/jpg");
		f5.setQuestion(q2);
		
		QuestionFile f6 = new QuestionFile();
		f6.setFileName("image23.jpg");
		f6.setFileSize(4000.00);
		f6.setFileType("image/jpg");
		f6.setQuestion(q2);
		
		Collection<QuestionFile> questionFiles = new ArrayList<QuestionFile>();
		questionFiles.add(f1);
		questionFiles.add(f2);
		questionFiles.add(f3);
		questionFiles.add(f4);
		questionFiles.add(f5);
		questionFiles.add(f6);
		
		Collection<QuestionFile> qfiles = (Collection<QuestionFile>) questionService.saveAllQuestionFiles(questionFiles);
		if(qfiles != null)
			System.out.println("Files are saved successfully! \n\n " + qfiles);
		else
			System.out.println("I'm Sorry! i didn't saved your files...");
		
	}

	private void findAllQuestions() {
		Iterable<Question> questions = questionService.findAllQuestions();
		for (Question q : questions) {
			System.out.println("user details : " + q.getUser().getId());

		}
		if (questions != null)
			System.out.println("All Questions are : " + questions);

		System.out.println("no question available!");
	}

	private void findQuestionById() {
		Optional<Question> question = questionService.findQuestionById((long) 2);
		if (question.isPresent())
			System.out.println("question found with id=2 : " + question + " \n\n and user is : \n " + question.get().getUser());
		
		System.out.println("question not found with id=2");
		
	}

	private void saveAllQuestion() {
		User u = new User();
		u.setId((long) 5);

		Question q1 = new Question();
		q1.setQuestion("This is My First Question.");
		q1.setDate(new Date());
		q1.setUser(u);

		Question q2 = new Question();
		q2.setQuestion("This is My Second Question.");
		q2.setDate(new Date());
		q2.setUser(u);

		Question q3 = new Question();
		q3.setQuestion("This is My Third Question.");
		q3.setDate(new Date());
		q3.setUser(u);

		Question q4 = new Question();
		q4.setQuestion("This is My Fourth Question.");
		q4.setDate(new Date());
		q4.setUser(u);

		Collection<Question> allQuestions = new ArrayList<Question>();
		allQuestions.add(q1);
		allQuestions.add(q2);
		allQuestions.add(q3);
		allQuestions.add(q4);

		Iterable<Question> saved_questions = questionService.saveAllQuestions(allQuestions);
		if (saved_questions != null)
			System.out.println("all questions are saved!  : " + saved_questions);

		System.out.println("none of any question is saved!");

	}

	private void updateQuestion() {
		User u = new User();
		u.setId((long) 5);

		Question q = new Question();
		q.setId((long) 6); //// updating question id = 6
		q.setQuestion("This is My First Updated Question.");
		q.setDate(new Date());
		q.setUser(u);
		Question question = questionService.updateQuestion(q);
		if (question != null)
			System.out.println("question updated with id=6  and new Question is : " + question);
		
		System.out.println("question not updated");

	}

	private void saveQuestion() {
		User u = new User();
		u.setId((long) 5);

		Question q = new Question();
		q.setQuestion(
				"cloud computing to work with google and microsoft database to manage and modify working with lots of project. cloud computing to work with google and microsoft database to manage and modify working with lots of project. This paragraph will include the pho\r\n"
						+ "\r\n"
						+ "cloud computing to work with google and microsoft database to manage and modify working with lots of project. cloud computing to work with google and microsoft database to manage and modify working with lots of project. This paragraph will include the pho\r\n"
						+ "\r\n"
						+ "cloud computing to work with google and microsoft database to manage and modify working with lots of project. cloud computing to work with google and microsoft database to manage and modify working with lots of project. This paragraph will include the pho\r\n"
						+ "\r\n"
						+ "cloud computing to work with google and microsoft database to manage and modify working with lots of project. cloud computing to work with google and microsoft database to manage and modify working with lots of project. This paragraph will include the pho\r\n"
						+ "\r\n" + "");
		q.setDate(new Date());
		q.setUser(u);
		Question question = questionService.saveQuestion(q);
		if (question != null)
			System.out.println("question saved! and saved Question is : " + question);

		System.out.println("question not saved");

	}

}
