package com.codinghub.collegebuddy.controller;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codinghub.collegebuddy.domain.Answer;
import com.codinghub.collegebuddy.domain.AnswerCode;
import com.codinghub.collegebuddy.domain.AnswerFile;
import com.codinghub.collegebuddy.domain.FollowQuestion;
import com.codinghub.collegebuddy.domain.Question;
import com.codinghub.collegebuddy.domain.QuestionCode;
import com.codinghub.collegebuddy.domain.QuestionFile;
import com.codinghub.collegebuddy.domain.User;
import com.codinghub.collegebuddy.embeddable.QuestionEmbedded;
import com.codinghub.collegebuddy.helper.HelperClass;
import com.codinghub.collegebuddy.services.AnswerCodeService;
import com.codinghub.collegebuddy.services.AnswerFileService;
import com.codinghub.collegebuddy.services.AnswerService;
import com.codinghub.collegebuddy.services.FollowQuestionService;
import com.codinghub.collegebuddy.services.QuestionService;
import com.codinghub.collegebuddy.services.UserService;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

@Controller
public class TestController {

	@Autowired
	private UserService userService;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private FollowQuestionService followQuestionService;

	@Autowired
	private AnswerService answerService;
	
	@Autowired
	private AnswerFileService answerFileService;
	
	@Autowired
	private AnswerCodeService answerCodeService;
	
	@PersistenceContext
	private EntityManager em;

	//// check a user is already following a question by userId

	@RequestMapping(value = "/isUserFollowTheQuestion")
	@ResponseBody
	private String isUserFollowTheQuestion() {
		Long userId = (long) 5;
		Long questionId = (long) 1;
		boolean result = followQuestionService.isUserFollowThisQuestion(userId, questionId);
		if (result)
			return "Yes! user is already following this question, So he is not able to follow this question.";
		return "No! user is not following this question, So he is able to follow this question.";
	}

	///// finding Bulk of QuestionFollowedByQuestions
	@RequestMapping(value = "/find-all-questions-with-followed-and-count")
	@ResponseBody
	private String findAllQuestionsWithFollowedAndCounts() {

		/// find all the Questions first
		Collection<Question> questions = (Collection<Question>) questionService.findAllQuestions();

		if (questions != null) {
			for (Question q : questions) {

				//// counting followed each question
				QuestionEmbedded qe = new QuestionEmbedded();
				System.out.println("Question Id " + q.getId());
				Long countQuestionFollowed = followQuestionService.countAllFollowedQuestionsByQuestionId(q.getId());
				System.out.println("--- count is : " + countQuestionFollowed);
				qe.setCountAQuestionFollowed(countQuestionFollowed);
				q.setQuestionEmbedded(qe);

			}
			return "Details : " + questions;
		}
		return "detials: ";
	}

	///// finding users by questions

	@RequestMapping(value = "/follow-a-question")
	@ResponseBody
	private String followAQuestion() {

//		// find user by id 
		Optional<User> u = userService.findUserById((long) 5);
		Optional<Question> q = questionService.findQuestionById((long) 1);

		if (u.isPresent() && q.isPresent()) {
			if (q.get().getUser().getId() != u.get().getId()) {
				FollowQuestion followQuestion = new FollowQuestion();

				followQuestion.setQuestion(q.get());
				followQuestion.setUser(u.get());
				System.out.println("user : " + u.get() + " <br> and question : " + q.get());
				FollowQuestion fq = followQuestionService.followAQuestion(followQuestion);
				if (fq != null)
					return u.get().getName() + " has just started following this '" + q.get().getQuestion() + "'";

				return "Something went wrong while following the question...";
			}
			return "You can not follow your own question";
		}
//			
		return "User OR Quesion can not be null to follow the question by a user...";

	}

	@RequestMapping(value = "/find-users-by-questions")
	@ResponseBody
	private String findUsersByQuestions() {

		Collection<Long> userIds = new ArrayList<Long>();
		Collection<User> users = new ArrayList<User>();

		/// find all the Questions first
		Collection<Question> questions = (Collection<Question>) questionService.findAllQuestions();

		if (questions != null) {

			System.out.println("questions are : " + questions);

			System.out.println("All users : ");
			for (Question q : questions) {
				System.out.println("\n " + q.getUser().getId());
//				System.out.println("\n " + q.getUser().getName());
				userIds.add(q.getUser().getId());
			}

			if (userIds != null)
				users = (Collection<User>) userService.findAllUserByIds(userIds);

			System.out.println("all users are : " + users.toString());

			Iterable<Object> combinedIterables = Iterables.unmodifiableIterable(Iterables.concat(questions, users));
			Collection<Object> collectionCombined = Lists.newArrayList(combinedIterables);

			///// method -3
			List<Object> combined = new ArrayList<Object>();
			combined.addAll(questions);
			combined.addAll(users);

			System.out.println(" \n\nBy Method -3 : \n\n " + combined);

			for (Object ob : combined) {
				System.out.println("by method -3 : object : " + ob);
			}

			System.out.println("by using Guava : output is : \n " + collectionCombined);

			System.out.println("outputs : ");
			for (Object obj : collectionCombined) {
				Object o1 = obj.getClass();
				Object o2 = obj.getClass();

				System.out.println(o1);
				System.out.println(o2);
			}
			int x = 0;
			for (Question q : questions) {
				x = 1;
				for (User u : users) {
					if (x == 1) {
						q.setUser(u);
						x = 0;
					}

					break;
				}

				System.out.println("Question id : " + q.getId() + "and user is: " + q.getUser().getName());
			}

			System.out.println("final Output: ");
			for (Question qs : questions) {

				System.out.println(qs);
				System.out.println(" \n and user is \n\n name: " + qs.getUser().getName() + " \n email: "
						+ qs.getUser().getEmail());

			}

//			int i = 0;
//			
//			Stream<Object> combinedStream = Stream.concat(questions.stream(), .stream());
//			System.out.println("final output: " + combinedStream);
			return questions.toString() + users.toString() + "by using Guava : output is : <br><br> "
					+ collectionCombined;

		}
		return "No Question Found";
	}

	/**
	 * save an user
	 * 
	 * @throws NoSuchAlgorithmException
	 */
	@RequestMapping(value = "/find-by-username-email")
	@ResponseBody
	public String login_new_user() throws NoSuchAlgorithmException {
		String email = "abc";
		String pass = "123";

		try {
			return em.createNamedQuery("User.findByUsernameEmailAndPassword", User.class)
					.setParameter("username", email).setParameter("email", email)
					.setParameter("password", HelperClass.encyptPassword(pass)).getSingleResult().toString();
		} catch (NoResultException e) {
			return "No data found! ";
		}

//		
//		return userService.loginUser(email, pass).toString();
	}

	/**
	 * save an user
	 */
	@RequestMapping(value = "/save-user")
	@ResponseBody
	public String saveUser() {
		User u = new User();
		u.setUsername("hemanthnayak");
		u.setName("hemanth Nayak");
		u.setCollege("Cits");
		u.setEmail("hemanthnayak@gmail.com");
		u.setPassword("hemanth");
		u.setRegDate(new Date());
		u.setProfession("loverboy");

		User user = userService.saveUser(u);
		if (user != null)
			return "user saved! and saved user is : " + user;
		return "user not saved! ";

	}

	/**
	 * Update an user by using save method (Note: must set userId with this object)
	 * 
	 * @return
	 */
	@RequestMapping(value = "/update-user")
	@ResponseBody
	public String updateUser() {
		User u = new User();
		u.setId((long) 1);
		u.setUsername("hemanth@lemon");
		u.setName("Banoth hemanth Nayak");
		u.setCollege("Chaitanya Institute Of Technology");
		u.setEmail("b.hemanthnayak@gmail.com");
		u.setPassword("bhemanth01");
		u.setRegDate(new Date());
		u.setProfession("rockstar");

		User new_user = userService.updateUser(u);
		if (new_user != null)
			return "user details updated! and new user : " + new_user;
		return "user details not updated!";

	}

	@RequestMapping(value = "/find-by-username")
	@ResponseBody
	public String findByUsername() {
		User u = new User();
		u.setUsername("hemanth@lemon");

		User new_user = userService.findByUsername(u.getUsername());
		if (new_user != null)
			return "given username : " + u.getUsername() + " , user found and new User is :" + new_user;
		return "user not found with given username : " + u.getUsername();

	}

	@RequestMapping(value = "/find-by-user-email")
	@ResponseBody
	public String findByEmail() {
		User u = new User();
		u.setEmail("b.hemanthnayak@gmail.com");

		User new_user = userService.findByEamil(u.getEmail());
		if (new_user != null)
			return "given user email : " + u.getEmail() + " , user found and new User is :" + new_user;
		return "user not found with given username : " + u.getUsername();

	}

	/**
	 * deleting an user
	 * 
	 * @return
	 */
	@RequestMapping(value = "/delete-user")
	@ResponseBody
	public String deleteUser() {
		User u = new User();
		u.setId((long) 1);
		if (userService.deleteUserById(u.getId()))
			return "user has been deleted!";
		return "user has not been deleted!";
	}

	/// QUESTION RELATED SERVICES OR OPERATIONS

	/**
	 * find all questions by userId
	 * 
	 * @return
	 */
	@RequestMapping(value = "/find-all-questions-by-userId")
	@ResponseBody
	public String findAllQuestionsByUserId() {
		Iterable<Question> questions = questionService.findAllQuestionsByUserId((long) 1);
		if (questions != null)
			return "All Questions are : " + questions;
		return "no question available!";
	}

	/**
	 * count all the questions of the question entity
	 * 
	 * @return
	 */
	@RequestMapping(value = "/count-all-questions")
	@ResponseBody
	public String countAllQuestions() {
		Long totalQuestions = questionService.countAllQuestions();
		if (totalQuestions != 0)
			return "Total questions are : " + totalQuestions;
		return "No any question asked by any user...";
	}

	/**
	 * count all the questions of a Particular user by userId
	 * 
	 * @return
	 */
	@RequestMapping(value = "/count-all-questions-by-userId")
	@ResponseBody
	public String countAllQuestionsByUserId() {
		Long totalQuestions = questionService.countAllQuestionsByUserId((long) 1);
		if (totalQuestions != 0)
			return "Total questions are : " + totalQuestions;
		return "No any question asked by any user...";
	}

	/// QUESTION FILE EINTITY RELATED SERVICES OR OPERATIONS

	/**
	 * save all question files since single question may have multiple question
	 * files so no need to create method for save a single question file
	 * 
	 * @return
	 */
	@RequestMapping(value = "/save-all-question-files")
	@ResponseBody
	public String saveAllQuestionFiles() {

		Question question = new Question();
		question.setId((long) 1);
		Collection<QuestionFile> questionFiles = new ArrayList<QuestionFile>();

		QuestionFile qf1 = new QuestionFile();
		qf1.setFileName("image1.jpg");
		qf1.setFileType("jpg");
		qf1.setFileSize(2048.30);
		qf1.setQuestion(question);

		QuestionFile qf2 = new QuestionFile();
		qf2.setFileName("image2.jpeg");
		qf2.setFileType("jpeg");
		qf2.setFileSize(3048.30);
		qf2.setQuestion(question);

		QuestionFile qf3 = new QuestionFile();
		qf3.setFileName("image3.png");
		qf3.setFileType("png");
		qf3.setFileSize(4048.40);
		qf3.setQuestion(question);

		questionFiles.add(qf1);
		questionFiles.add(qf2);
		questionFiles.add(qf3);

		Iterable<QuestionFile> saved_question_files = questionService.saveAllQuestionFiles(questionFiles);
		if (saved_question_files != null)
			return "all question files are saved!  : " + saved_question_files;
		return "none of any question file is saved!";
	}

	/**
	 * Finding question file by questionFileId
	 * 
	 * @return
	 */
	@RequestMapping(value = "/find-question-files-byId")
	@ResponseBody
	public String findQustionFileById() {

		Optional<QuestionFile> qf = questionService.findQuestionFileById((long) 2);
		if (qf.isPresent())
			return "QustionFile found with id=2 : " + qf;
		return "question file not found with id = 2";
	}

	/**
	 * find-all-question-files-by-questionId
	 * 
	 * @return
	 */
	@RequestMapping(value = "/find-all-question-files-by-questionId")
	@ResponseBody
	public String findAllQuestionFilesByQuestionId() {

		Collection<QuestionFile> questionFiles = questionService.findAllQuestionFilesByQuestionId((long) 1);
		if (questionFiles != null)
			return "All QustionFile related to userId=1 : " + questionFiles;
		return "No question Files found related to userId=1";
	}

	/**
	 * update question file
	 * 
	 * @return
	 */
	@RequestMapping(value = "/update-question-file")
	@ResponseBody
	public String updateQuestionFile() {

		Question question = new Question();
		question.setId((long) 1);

		QuestionFile qf1 = new QuestionFile();
		qf1.setFileName("updated_image1.jpg");
		qf1.setFileType("updated -> jpg");
		qf1.setFileSize(1048.30);
		qf1.setQuestion(question);
		qf1.setId((long) 1);

		QuestionFile questionFile = questionService.updateQuestionFile(qf1);
		if (questionFile != null)
			return "updated question file of id=1 : " + questionFile;
		return "question file of id=1 not updated";
	}

	/**
	 * count the question files by questionId
	 * 
	 * @return
	 */
	@RequestMapping(value = "/count-question-files-by-questionId")
	@ResponseBody
	public String countQuestionFilesByQuestionId() {

		Long count = questionService.countQuestionFilesByQuestionId((long) 1);
		return "total question files associated with questionId = 1 is : " + count;
	}

	/**
	 * delete-question-file
	 * 
	 * @return
	 */
	@RequestMapping(value = "/delete-question-file")
	@ResponseBody
	public String deleteQuestionFileById() {

		// TODO: later
		return null;

	}

	/**
	 * delete bulk of question-files
	 * 
	 * @return
	 */
	@RequestMapping(value = "/delete-bulk-question-files")
	@ResponseBody
	public String deleteBulkQuestionFiles() {

		// TODO: later
		return null;

	}

	////// QUESTION CODE

	/**
	 * save all the question codes
	 * 
	 * @return
	 */
	@RequestMapping(value = "/save-all-question-codes")
	@ResponseBody
	public String saveAllQuestionCodes() {

		Question question = new Question();
		question.setId((long) 1);
		Collection<QuestionCode> questionCodes = new ArrayList<QuestionCode>();

		QuestionCode qc1 = new QuestionCode();
		qc1.setCodeTitle("This is first code title");
		qc1.setCodeDesc("this is first code desc");
		qc1.setQuestion(question);

		QuestionCode qc2 = new QuestionCode();
		qc2.setCodeTitle("This is second code title");
		qc2.setCodeDesc("this is second code desc");
		qc2.setQuestion(question);

		QuestionCode qc3 = new QuestionCode();
		qc3.setCodeTitle("This is third code title");
		qc3.setCodeDesc("this is third code desc");
		qc3.setQuestion(question);

		questionCodes.add(qc1);
		questionCodes.add(qc2);
		questionCodes.add(qc3);

		Iterable<QuestionCode> saved_question_codes = questionService.saveAllQuestionCodes(questionCodes);
		if (saved_question_codes != null)
			return "all question codes are saved!  : " + saved_question_codes;
		return "none of any question code is saved!";
	}

	/**
	 * find-question-code-byId
	 * 
	 * @return
	 */
	@RequestMapping(value = "/find-question-code-byId")
	@ResponseBody
	public String findQustionCodeById() {

		Optional<QuestionCode> qc = questionService.findQuestionCodeById((long) 2);
		if (qc.isPresent())
			return "QuestionCode found with id=2 : " + qc;
		return "question code not found with id = 2";
	}

	/**
	 * find-all-question-code-by-quesionId
	 * 
	 * @return
	 */
	@RequestMapping(value = "/find-all-question-code-by-quesionId")
	@ResponseBody
	public String findAllQustionCodesByQuestionId() {

		Collection<QuestionCode> codes = questionService.findAllQuestionCodesByQuestionId((long) 1);
		if (codes != null)
			return "All QuestionCodes with question id=1 : " + codes;
		return "question codes not found with question id=1";
	}

	/**
	 * count-question-codes-by-quesionId
	 * 
	 * @return
	 */
	@RequestMapping(value = "/count-question-codes-by-quesionId")
	@ResponseBody
	public String countQustionCodesByQuestionId() {

		long count = questionService.countQuestionCodesByQuestionId((long) 1);
		return "Total Question codes associated with question id=1 : " + count;
	}

	/**
	 * update-question-code
	 * 
	 * @return
	 */
	@RequestMapping(value = "/update-question-code")
	@ResponseBody
	public String updateQuestionCode() {

		Question question = new Question();
		question.setId((long) 1);

		QuestionCode qc1 = new QuestionCode();
		qc1.setCodeTitle("This is first updated code title");
		qc1.setCodeDesc("this is first updated code desc");
		qc1.setQuestion(question);
		qc1.setId((long) 1);

		QuestionCode updated_code = questionService.updateQuestionCode(qc1);
		if (updated_code != null)
			return "question code has been updated !  : " + updated_code;
		return "question code has not been updated !";
	}

	/**
	 * delete-question-code
	 * 
	 * @return
	 */
	@RequestMapping(value = "/delete-question-code")
	@ResponseBody
	public String deleteQuestionCode() {
		if (questionService.deleteQuestionCodeById((long) 3))
			return "QuestionCode having id=3 has been deleted!";
		return "QuestionCode having id=3 has not been deleted!";
	}

	/**
	 * delete-bulk-question-codes
	 * 
	 * @return
	 */
	@RequestMapping(value = "/delete-bulk-question-codes")
	@ResponseBody
	public String deleteBulkQuestionCodes() {

		Question question = new Question();
		question.setId((long) 1);
		Collection<QuestionCode> questionCodes = new ArrayList<QuestionCode>();

		QuestionCode qc1 = new QuestionCode();
		qc1.setId((long) 1);

		QuestionCode qc2 = new QuestionCode();
		qc2.setId((long) 2);

		questionCodes.add(qc1);
		questionCodes.add(qc2);

		if (questionService.deleteBulkQuestionCodes(questionCodes))
			return "QuestionCode having id=1,2 has been deleted!";
		return "QuestionCode having id=1,2 has not been deleted!";
	}

	/**
	 * Deleting a single question
	 * 
	 * @return
	 */
	@RequestMapping(value = "/delete-question")
	@ResponseBody
	public String deleteQuestion() {

		Question q = new Question();
		q.setId((long) 1);
		/**
		 * Since question have relationship with (Answer, QuestionFile, QuestionCode) so
		 * first break all these link one by one by deleting them then delete Question
		 */

		///// find and delete Answer which are related to this question or questionid
		Iterable<Answer> answers = answerService.findAllAnswersByQuestionId(q.getId());
		if (answers != null)

			for (Answer a : answers) {
				//// now find all the answer files and codes and delete them associate with each
				//// answer
				Collection<AnswerFile> aFiles = answerFileService.findAllAnswerFilesByAnswerId(a.getId());
				Collection<AnswerCode> aCodes = answerCodeService.findAllAnswerCodesByAnswerId(a.getId());

				if (aFiles != null)
					answerFileService.deleteBulkAnswerFiles(aFiles);
				if (aCodes != null)
					answerCodeService.deleteBulkAnswerCodes(aCodes);
			}
		/// after deleting all the answer files and codes related to this answer whitch
		/// is related to this question
		/// delete all the answers
		answerService.deleteBulkAnswers(answers);

		//// now find all the question files and codes and delete them associate with
		//// each answer
		Collection<QuestionFile> qFiles = questionService.findAllQuestionFilesByQuestionId(q.getId());
		Collection<QuestionCode> qCodes = questionService.findAllQuestionCodesByQuestionId(q.getId());

		if (qFiles != null)
			questionService.deleteBulkQuestionFiles(qFiles);
		if (qCodes != null)
			questionService.deleteBulkQuestionCodes(qCodes);

		//// after removing all the relations with this question delete it
		if (questionService.deleteQuestionById(q.getId()))
			return "Question has been deleted successfully!";
		return "Question has not been deleted!";
	}
}
