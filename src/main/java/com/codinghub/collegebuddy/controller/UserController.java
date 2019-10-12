package com.codinghub.collegebuddy.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.codinghub.collegebuddy.commands.AddUserSkillsCommand;
import com.codinghub.collegebuddy.commands.AskADoubtCommand;
import com.codinghub.collegebuddy.commands.WriteAnAnswer;
import com.codinghub.collegebuddy.domain.Answer;
import com.codinghub.collegebuddy.domain.AnswerCode;
import com.codinghub.collegebuddy.domain.AnswerFile;
import com.codinghub.collegebuddy.domain.Blog;
import com.codinghub.collegebuddy.domain.College;
import com.codinghub.collegebuddy.domain.FollowQuestion;
import com.codinghub.collegebuddy.domain.JoinCollege;
import com.codinghub.collegebuddy.domain.LikeDislikeAnswer;
import com.codinghub.collegebuddy.domain.LikeDislikeBlog;
import com.codinghub.collegebuddy.domain.OtherAccount;
import com.codinghub.collegebuddy.domain.Question;
import com.codinghub.collegebuddy.domain.QuestionCode;
import com.codinghub.collegebuddy.domain.QuestionFile;
import com.codinghub.collegebuddy.domain.Skill;
import com.codinghub.collegebuddy.domain.User;
import com.codinghub.collegebuddy.domain.UserSkill;
import com.codinghub.collegebuddy.embeddable.AnswerEmbedded;
import com.codinghub.collegebuddy.embeddable.BlogEmbedded;
import com.codinghub.collegebuddy.embeddable.QuestionEmbedded;
import com.codinghub.collegebuddy.helper.HelperClass;
import com.codinghub.collegebuddy.helper.UploadCroppedImage;
import com.codinghub.collegebuddy.services.AnswerCodeService;
import com.codinghub.collegebuddy.services.AnswerFileService;
import com.codinghub.collegebuddy.services.AnswerService;
import com.codinghub.collegebuddy.services.BlogService;
import com.codinghub.collegebuddy.services.CollegeService;
import com.codinghub.collegebuddy.services.FollowQuestionService;
import com.codinghub.collegebuddy.services.JoinCollegeService;
import com.codinghub.collegebuddy.services.LikeDislikeAnswerService;
import com.codinghub.collegebuddy.services.LikeDislikeBlogService;
import com.codinghub.collegebuddy.services.OtherAccountService;
import com.codinghub.collegebuddy.services.QuestionService;
import com.codinghub.collegebuddy.services.SkillService;
import com.codinghub.collegebuddy.services.UserService;
import com.codinghub.collegebuddy.services.UserSkillService;
import com.codinghub.collegebuddy.utils.ConstantRequired;
import com.mysql.cj.exceptions.DataTruncationException;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private FollowQuestionService followQuestionService;

	@Autowired
	private AnswerService answerService;

	@Autowired
	private LikeDislikeAnswerService likeDislikeAnswerService;

	@Autowired
	private LikeDislikeBlogService likeDislikeBlogService;

	@Autowired
	private CollegeService collegeService;

	@Autowired
	private JoinCollegeService joinCollegeService;

	@Autowired
	private UserSkillService userSkillService;

	@Autowired
	private SkillService skillService;

	@Autowired
	private OtherAccountService otherAccountService;

	@Autowired
	private AnswerFileService answerFileService;

	@Autowired
	private AnswerCodeService answerCodeService;

	@Autowired
	private BlogService blogService;

	@PersistenceContext
	private EntityManager em;

	@RequestMapping(value = "/testing")
	private String testing(){
		return "college_photos";
	}
	
	@RequestMapping(value = { "/", "/index" })
	public String homePage(Model m, HttpSession session) {

		//// left side data
		// TODO: finding questions in limit of 20 and order by most QuestionFollowed
		Collection<Question> lQuestions = (Collection<Question>) questionService.findAllQuestions();
		if (lQuestions.size() != 0) {
			generateHomePageData(lQuestions, session, ConstantRequired.DATA_FOR_LEFTSIDE);
			m.addAttribute("LQuestions", lQuestions);
		} else {
			m.addAttribute("LQuestions", null);
		}

		//// Middle part data
		// TODO: finding questions in limit of 20 and order by most Answered
		Collection<Question> mQuestions = (Collection<Question>) questionService.findAllQuestions();
		if (mQuestions.size() != 0) {
			generateHomePageData(mQuestions, session, ConstantRequired.DATA_FOR_MIDDLESIDE);
			m.addAttribute("MQuestions", mQuestions);
		} else {
			m.addAttribute("MQuestions", null);
		}
		return "home-page";
	}

	/// Generating HomePageData by simply passing questions and session Nothing more
	/// to do
	/// KEY will use to bind data for left side part and middle part and right part
	/// for home page if required extra data
	private void generateHomePageData(Collection<Question> questions, HttpSession session, int KEY) {
		Collection<Long> userIds = new ArrayList<Long>();

		//// finding loggedIn User
		User loggedInUser = (User) session.getAttribute("USER");
		Long loggedInUserId = (long) 0;
		if (loggedInUser != null)
			loggedInUserId = loggedInUser.getId();

		if (questions != null) {
			//// store all the user id's present in the questions list object into a new
			//// list to fetch all the users by passing these list of id's at once. Benefit
			//// : save from firing multiple
			//// queries to get all the users.
			for (Question q : questions) {

				userIds.add(q.getUser().getId());

				///// finding out all the followed questions by questionId
				QuestionEmbedded qe = new QuestionEmbedded();

				Long countQuestionFollowed = followQuestionService.countAllFollowedQuestionsByQuestionId(q.getId());
				qe.setCountAQuestionFollowed(countQuestionFollowed);

				///// count all the answers by answer
				Long countAllAnswers = answerService.countAllAnswersByQuestionId(q.getId());
				qe.setCountAQuestionAnswered(countAllAnswers);

				///// Finding out if user is logged in the is user already followed the question
				//// It must be before by default set false if user is loggedIn or not and user
				///// is following or not , set value as '0'
				qe.setUserFollowThisQuestion(0);
				//// It must be after previous
				if (loggedInUserId != 0)
					if (followQuestionService.isUserFollowThisQuestion(loggedInUserId, q.getId()))
						qe.setUserFollowThisQuestion(1);

				//// Now setting up QuestionEmbedded object to the question object
				q.setQuestionEmbedded(qe);

				/// BINDING MORE DATA REQUIRED FOR MIDDLE PART AS COMPARE TO LEFT SIDE DATA
				if (KEY == ConstantRequired.DATA_FOR_MIDDLESIDE) {
					/// TODO: find all the question files and question codes associated with each
					/// question
					Collection<QuestionFile> questionFiles = questionService
							.findAllQuestionFilesByQuestionId(q.getId());
					if (questionFiles.size() != 0)
						q.setQuestionFiles(questionFiles);
					else
						q.setQuestionFiles(null);

					Collection<QuestionCode> questionCodes = questionService
							.findAllQuestionCodesByQuestionId(q.getId());
					if (questionFiles.size() != 0)
						q.setQuestionCodes(questionCodes);
					else
						q.setQuestionCodes(null);

					//// finding all the answers
					Collection<Answer> answers = (Collection<Answer>) answerService
							.findAllAnswersByQuestionId(q.getId());

					if (answers.size() != 0) {
						q.setAnswers(answers);
						/// TODO: finding all the answer files associated with each answers
						for (Answer a : answers) {
							AnswerEmbedded ae = new AnswerEmbedded();

							Long allLikedAnswer = likeDislikeAnswerService.countAllLikedAnswerByAnswerId(a.getId());
							Long allDisLikedAnswer = likeDislikeAnswerService
									.countAllDislikedAnswerByAnswerId(a.getId());
							ae.setTotalLikedAnswer(allLikedAnswer);
							ae.setTotalDislikedAnswer(allDisLikedAnswer);

							if (likeDislikeAnswerService.isUserAlreadyLikedAnswer(loggedInUserId, a.getId())) {
								ae.setAnswerStatus(ConstantRequired.USER_LIKED_ANSWER_ALREADY);
							} else {
								ae.setAnswerStatus(ConstantRequired.USER_NOT_LIKED_ANSWER_ALREADY);
								if (likeDislikeAnswerService.isUserAlreadyDisLikedAnswer(loggedInUserId, a.getId())) {
									ae.setAnswerStatus(ConstantRequired.USER_DISLIKED_ANSWER_ALREADY);
								} else {
									ae.setAnswerStatus(ConstantRequired.USER_NOT_DISLIKED_ANSWER_ALREADY);
								}
							}

							a.setAnswerEmbedded(ae);
						}

						/// TODO: finding all the answer codes associated with each answers

					} else {
						q.setAnswers(null);
					}

				}

			}
			//// Now find all the users with list of id's
			//// THIS 'users' OBJECT WILL NOT BE USED BUT IT MUST INITIALIZE DON'T REMOVE IT
			Collection<User> users = (Collection<User>) userService.findAllUserByIds(userIds);
			/**
			 * Bind Only questions Object to the attribute and user details will
			 * automatically fetched by this object
			 */
		}
	}

	////// college profile page
	@RequestMapping(value = "/user/user-college-profile")
	public String userCollegeProfile(Model m, @RequestParam("collegeId") Long collegeId) {

		if (collegeId == 0) {
			return "redirect:/index";
		} else {

			// find the user college by collegeId
			Optional<College> userCollege = collegeService.findCollegeById(collegeId);

			if (userCollege.isPresent()) {
				College college = userCollege.get();
				m.addAttribute("COLLEGE", college);

				Collection<User> approvedUsers = new ArrayList<User>();
				m.addAttribute("APPROVED_USERS", null);
				//// finding all the approved members who have joined this college
				Collection<JoinCollege> joinColleges = joinCollegeService.findApprovedUsersByCollegeId(collegeId);
				if (joinColleges.size() != 0) {
					Collection<Long> userIds = new ArrayList<Long>();
					for (JoinCollege jc : joinColleges) {
						userIds.add(jc.getUser().getId());
					}
					if (userIds.size() != 0) {
						approvedUsers = (Collection<User>) userService.findAllUserByIds(userIds);
						if (approvedUsers.size() != 0)
							m.addAttribute("APPROVED_USERS", approvedUsers);
					}
				}
				return "college-profile";
			} else
				return "redirect:/index?msg=college not found!";
		}
	}

	///// college announcement
	@RequestMapping(value = "/college/programs/announcement")
	public String collegeAnnouncement() {
		return "college-announcement";
	}

	@RequestMapping(value = "/college/blogs")
	public String collegeBlogs(Model m, @RequestParam("collegeId") Long collegeId, HttpSession session) {
		User user = (User) session.getAttribute("USER");
		if (collegeId == 0)
			return "redirect:/index? err = something went wrong, please try again...";
		/// getting blog data
		Collection<Blog> blogs = blogService.findAllBlogsByCollegeId(collegeId);
		m.addAttribute("BLOGS", null);
		if (blogs.size() != 0)
			m.addAttribute("BLOGS", blogs);

		for (Blog b : blogs) {
			BlogEmbedded be = new BlogEmbedded();

			Long allLikedBlogs = likeDislikeBlogService.countAllLikedBlogsByBlogId(b.getId());
			Long allDisLikedBlogs = likeDislikeBlogService.countAllDislikedBlogsByBlogId(b.getId());
			be.setTotalLikedBlog(allLikedBlogs);
			be.setTotalDislikedBlog(allDisLikedBlogs);
			if (user == null) {
				be.setBlogStatus(ConstantRequired.USER_NOT_LIKED_BLOG_ALREADY);
				be.setBlogStatus(ConstantRequired.USER_NOT_DISLIKED_BLOG_ALREADY);
			} else {
				if (likeDislikeBlogService.isUserAlreadyLikedThisBlog(user.getId(), b.getId())) {
					be.setBlogStatus(ConstantRequired.USER_LIKED_BLOG_ALREADY);
				} else {
					be.setBlogStatus(ConstantRequired.USER_NOT_LIKED_BLOG_ALREADY);
					if (likeDislikeBlogService.isUserAlreadyDisLikedThisBlog(user.getId(), b.getId())) {
						be.setBlogStatus(ConstantRequired.USER_DISLIKED_BLOG_ALREADY);
					} else {
						be.setBlogStatus(ConstantRequired.USER_NOT_DISLIKED_BLOG_ALREADY);
					}
				}
			}

			b.setBlogEmbedded(be);
		}
		return "college-blogs";
	}

///// college quiz ////
	@RequestMapping(value = "/college/programs/quiz")
	public String collegeQuiz() {

		return "college-quiz";
	}

///// quiz details (Only quiz problems)////
	@RequestMapping(value = "/quiz/quiz-details")
	public String quizDetails() {
		return "includes/quiz-modules/quiz-details";
	}

	///// view quiz problem (Single problem with all the available answers) ////
	@RequestMapping(value = "/quiz/view-problem")
	public String viewQuizProblem() {
		return "includes/quiz-modules/view-quiz-problem";
	}

	///// College Records ////
	@RequestMapping(value = "/college/records")
	public String collegeRecords() {
		return "college_records";
	}

	///// College Exams ////
	@RequestMapping(value = "/college/exams")
	public String collegeExams() {
		return "college_exams";
	}

	///// College Magazines, Novels and Books etc ////
	@RequestMapping(value = "/college/magazines")
	public String collegeMagazines() {
		return "college_magazines";
	}

	///// College Photos ////
	@RequestMapping(value = "/college/photos")
	public String collegePhotos() {
		return "college_photos";
	}

	///// college workshops
	@RequestMapping(value = "/college/programs/workshops")
	public String collegeWorkshops() {
		return "college-workshop";
	}

	///// Discussion Room
	@RequestMapping(value = "/discussion/discussion-room")
	public String discussionRoomPage() {
		return "discussion-room";
	}

	@RequestMapping(value = "/new-user/registration")
	@ResponseBody
	public String registerNewAccount(@RequestParam(required = false, value = "userData[]") String[] userData)
			throws NoSuchAlgorithmException {
		if (userData != null) {
			String firstName = userData[0];
			String lastName = userData[1];
			String fullName = firstName + " " + lastName;
			String college = userData[2];
			String email = userData[3];
			System.out.println("------- email  : " + email);
			String password = userData[4];
			String profession = userData[5];
			String username = HelperClass.generateUsername(email);

			User u = new User();
			u.setName(fullName);
			u.setCollege(college);
			u.setEmail(email);
			u.setPassword(HelperClass.encyptPassword(password));
			u.setProfession(profession);
			u.setUsername(username);
			u.setRegDate(new Date());

			User existing_user = userService.findByEamilAndUsername(email, username);
			if (existing_user != null) {
				return "ae";
			}
			User savedUser = userService.saveUser(u);

			if (savedUser != null) {

				//// after saving the user, let's create a default college page
				College c = new College();
				c.setUser(savedUser);
				c.setRegDate(new Date());
				c.setProfileImage(ConstantRequired.DEFAULT_COLLEGE_PROFILE_IMAGE);
				c.setCoverImage(ConstantRequired.DEFAULT_COLLEGE_COVER_IMAGE);
				c.setCollegeName(savedUser.getCollege());
				c.setAbout(ConstantRequired.COLLEGE_ABOUT);
				c.setTitle(ConstantRequired.COLLEGE_TITLE);
				c.setOpen(ConstantRequired.COLLEGE_STATUS); // college status = true

				College savedCollege = collegeService.saveCollege(c);
				/// now after saving new college of the user set it default college for the user
				if (savedCollege.getId() != 0) {
					savedUser.setDefaultCollege(savedCollege);
					userService.saveUser(savedUser);
				}
				return "t";
			}
			return "e";

		}
		return "e";
	}

	/// LOGIN TO ACCOUNT ///
	@RequestMapping(value = "/user/login_account")
	@ResponseBody
	public String loginAccount(@RequestParam("username") String username, @RequestParam("password") String password,
			Model m, HttpSession session) throws NoSuchAlgorithmException {
		String hashedPassword = HelperClass.encyptPassword(password);
		if (username.trim() != null && hashedPassword != null) {
			User user = userService.loginUser(username, hashedPassword);
			if (user == null) {
				return "ne"; /// ne ==> User not exists or bad credentials
			}
			/// finding user default college by default college id
			if (user.getDefaultCollege().getId() != 0) {
				Optional<College> userDefaultCollege = collegeService.findCollegeById(user.getDefaultCollege().getId());
				if (userDefaultCollege.isPresent())
					user.setDefaultCollege(userDefaultCollege.get());
				else
					user.setDefaultCollege(null);
			}
			addUserInSession(user, session);
			return "user"; /// user ==> login done.
		}
		return "fm"; //// fields are missing
	}

	private void addUserInSession(User user, HttpSession session) {
		session.setAttribute("USER", user);
	}

	//// Follow A Question
	@RequestMapping(value = "/question/follow-question")
	@ResponseBody
	private String FollowQuestion(@RequestParam(required = false, value = "questionId") Long questionId,
			HttpSession session) {
		User u = (User) session.getAttribute("USER");
		if (u != null) {
			Optional<Question> q = questionService.findQuestionById(questionId);
			if (q.isPresent()) {

				if (u.getId() == q.get().getUser().getId()) {
					return "err";
				}
				//// do following
				FollowQuestion followQuestion = new FollowQuestion();
				followQuestion.setQuestion(q.get());
				followQuestion.setUser(u);
				FollowQuestion fq = followQuestionService.followAQuestion(followQuestion);
				if (fq != null)
					return "qfs";/// question following successful
			}
		}
		return "err";
	}

	//// USER PROFILE
	@RequestMapping(value = "/user/user_profile")
	private String userProfile(Model m, HttpSession session, @RequestParam("userId") Long userId) {
		if (userId == 0 || userId == null)
			return "redirect:/index? act = user not found!";

		User sessionUser = (User) session.getAttribute("USER");

		if (sessionUser != null) {
			if (sessionUser.getId() == userId)
				m.addAttribute("NEW_USER", sessionUser);
		} else {
			User newUser = userService.findUserById(userId).orElse(new User());
			if (newUser.getId() == null)
				return "redirect:/index? act = user not found!";
			else
				m.addAttribute("NEW_USER", newUser);
		}

		/// fetch all Other accounts like facebook, twitter, linkedin etc urls
		OtherAccount otherAccounts = new OtherAccount();
		OtherAccount accounts = otherAccountService.findOtherAccountsByUserId(userId);
		if (accounts == null)
			m.addAttribute("OTHER_ACCOUNTS", otherAccounts);
		else
			m.addAttribute("OTHER_ACCOUNTS", accounts);

		/// finding all the blogs by user id
		Collection<Blog> userBlogs = blogService.findAllBlogsByUserId(userId);
		if (userBlogs.size() == 0)
			m.addAttribute("USER_BLOGS", null);
		else
			m.addAttribute("USER_BLOGS", userBlogs);

		/// finding necessary associations with each blog
		for (Blog b : userBlogs) {
			BlogEmbedded be = new BlogEmbedded();

			Long allLikedBlogs = likeDislikeBlogService.countAllLikedBlogsByBlogId(b.getId());
			Long allDisLikedBlogs = likeDislikeBlogService.countAllDislikedBlogsByBlogId(b.getId());
			be.setTotalLikedBlog(allLikedBlogs);
			be.setTotalDislikedBlog(allDisLikedBlogs);

			if (likeDislikeBlogService.isUserAlreadyLikedThisBlog(userId, b.getId())) {
				be.setBlogStatus(ConstantRequired.USER_LIKED_BLOG_ALREADY);
			} else {
				be.setBlogStatus(ConstantRequired.USER_NOT_LIKED_BLOG_ALREADY);
				if (likeDislikeBlogService.isUserAlreadyDisLikedThisBlog(userId, b.getId())) {
					be.setBlogStatus(ConstantRequired.USER_DISLIKED_BLOG_ALREADY);
				} else {
					be.setBlogStatus(ConstantRequired.USER_NOT_DISLIKED_BLOG_ALREADY);
				}
			}

			b.setBlogEmbedded(be);
		}

		/// asked questions list by user
		Collection<Question> questions = (Collection<Question>) questionService.findAllQuestionsByUserId(userId);
		if (questions.size() == 0)
			m.addAttribute("ASKED_QUESTIONS", null);
		else {
			for (Question q : questions) {
				///// finding out all the followed questions by questionId
				QuestionEmbedded qe = new QuestionEmbedded();

				Long countQuestionFollowed = followQuestionService.countAllFollowedQuestionsByQuestionId(q.getId());
				qe.setCountAQuestionFollowed(countQuestionFollowed);

				///// count all the answers by answer
				Long countAllAnswers = answerService.countAllAnswersByQuestionId(q.getId());
				qe.setCountAQuestionAnswered(countAllAnswers);

				///// Finding out if user is logged in the is user already followed the question
				//// It must be before by default set false if user is loggedIn or not and user
				///// is following or not , set value as '0'
				qe.setUserFollowThisQuestion(0);
				//// It must be after previous
				if (sessionUser != null)
					if (sessionUser.getId() != 0)
						if (followQuestionService.isUserFollowThisQuestion(sessionUser.getId(), q.getId()))
							qe.setUserFollowThisQuestion(1);

				//// Now setting up QuestionEmbedded object to the question object
				q.setQuestionEmbedded(qe);
			}
			m.addAttribute("ASKED_QUESTIONS", questions);
		}

		/// answer list by user
		Collection<Answer> answers = (Collection<Answer>) answerService.findAllAnswersByUserId(userId);
		if (answers.size() == 0)
			m.addAttribute("ANSWERED", null);
		else {
			for (Answer a : answers) {
				///// finding out all the followed questions by questionId
				AnswerEmbedded ae = new AnswerEmbedded();

				Long allLikedAnswer = likeDislikeAnswerService.countAllLikedAnswerByAnswerId(a.getId());
				Long allDisLikedAnswer = likeDislikeAnswerService.countAllDislikedAnswerByAnswerId(a.getId());
				ae.setTotalLikedAnswer(allLikedAnswer);
				ae.setTotalDislikedAnswer(allDisLikedAnswer);
				if (sessionUser != null)
					if (likeDislikeAnswerService.isUserAlreadyLikedAnswer(sessionUser.getId(), a.getId())) {
						ae.setAnswerStatus(ConstantRequired.USER_LIKED_ANSWER_ALREADY);
					} else {
						ae.setAnswerStatus(ConstantRequired.USER_NOT_LIKED_ANSWER_ALREADY);
						if (likeDislikeAnswerService.isUserAlreadyDisLikedAnswer(sessionUser.getId(), a.getId())) {
							ae.setAnswerStatus(ConstantRequired.USER_DISLIKED_ANSWER_ALREADY);
						} else {
							ae.setAnswerStatus(ConstantRequired.USER_NOT_DISLIKED_ANSWER_ALREADY);
						}
					}

				a.setAnswerEmbedded(ae);

			}
			m.addAttribute("ANSWERED", answers);
		}

		return "user-modules/user-profile";
	}

	//// Like An answer
	@RequestMapping(value = "/answer/like-answer")
	@ResponseBody
	private ModelAndView likeAnAnswer(@RequestParam(required = false, value = "answerId") Long answerId,
			@RequestParam(required = false, value = "total_shared_answer") Long totalSharedAnswer,
			HttpSession session) {
		//// like an answer by answerId
		ModelAndView mv = new ModelAndView();

		User loggedInUser = (User) session.getAttribute("USER");
		if (loggedInUser != null) {
			Long userId = loggedInUser.getId();
			Answer a = new Answer();
			a.setId(answerId);

			LikeDislikeAnswer ld = new LikeDislikeAnswer();

			//// first check whether the user has already disliked this answer or not if Yes
			//// then UPDATE this as like
			LikeDislikeAnswer alreadyDislikedAnswerByUser = likeDislikeAnswerService
					.findUserAlreadyDisLikedAnswer(userId, a.getId());

			if (alreadyDislikedAnswerByUser != null) {
				///// user has already disliked this so update this so get it's Id and set to
				///// the new LikeDislikeAnswer Object
				ld.setId(alreadyDislikedAnswerByUser.getId()); //// id is necessary to set here for
			}

			ld.setActionDate(new Date());
			ld.setAnswer(a);
			ld.setStatus(ConstantRequired.LIKE_ANSWER);
			ld.setUser(loggedInUser);

			//// saving like or updating disliked answer
			LikeDislikeAnswer ld1 = likeDislikeAnswerService.likeDislikeAnswer(ld); /// no use of this new object

			//// now get all liked and disliked answer
			Long allLikedAnswer = likeDislikeAnswerService.countAllLikedAnswerByAnswerId(a.getId());
			Long allDisLikedAnswer = likeDislikeAnswerService.countAllDislikedAnswerByAnswerId(a.getId());

			mv.setViewName("includes/action-icons-list-with-like-dislike");
			mv.addObject("total_shared", totalSharedAnswer); //// this is directly retrieving when like button is
																//// clicking
			mv.addObject("total_disliked", allDisLikedAnswer);
			mv.addObject("total_liked", allLikedAnswer);
			mv.addObject("answer_status", ConstantRequired.LIKE_ANSWER);
			mv.addObject("answer_id", answerId);

		}
		return mv;
	}

////Dislike An answer
	@RequestMapping(value = "/answer/dislike-answer")
	@ResponseBody
	private ModelAndView DislikeAnAnswer(@RequestParam(required = false, value = "answerId") Long answerId,
			@RequestParam(required = false, value = "total_shared_answer") Long totalSharedAnswer,
			HttpSession session) {
		//// dislike an answer by answerId
		ModelAndView mv = new ModelAndView();

		User loggedInUser = (User) session.getAttribute("USER");
		if (loggedInUser != null) {
			Long userId = loggedInUser.getId();
			Answer a = new Answer();
			a.setId(answerId);

			LikeDislikeAnswer ld = new LikeDislikeAnswer();

			//// first check whether the user has already liked this answer or not if Yes
			//// then UPDATE this as dislike
			LikeDislikeAnswer alreadyLikedAnswerByUser = likeDislikeAnswerService.findUserAlreadyLikedAnswer(userId,
					a.getId());

			if (alreadyLikedAnswerByUser != null) {
				///// user has already liked this so update this so get it's Id and set to
				///// the new LikeDislikeAnswer Object
				ld.setId(alreadyLikedAnswerByUser.getId()); //// id is necessary to set here for
			}

			ld.setActionDate(new Date());
			ld.setAnswer(a);
			ld.setStatus(ConstantRequired.DISLIKE_ANSWER);
			ld.setUser(loggedInUser);

			//// saving dislike or updating liked answer
			LikeDislikeAnswer ld1 = likeDislikeAnswerService.likeDislikeAnswer(ld);

			//// now get all liked and disliked answer
			Long allLikedAnswer = likeDislikeAnswerService.countAllLikedAnswerByAnswerId(a.getId());
			Long allDisLikedAnswer = likeDislikeAnswerService.countAllDislikedAnswerByAnswerId(a.getId());

			mv.setViewName("includes/action-icons-list-with-like-dislike");
			mv.addObject("total_shared", totalSharedAnswer); //// this is directly retrieving when like button is
																//// clicking
			mv.addObject("total_disliked", allDisLikedAnswer);
			mv.addObject("total_liked", allLikedAnswer);
			mv.addObject("answer_status", ConstantRequired.DISLIKE_ANSWER);
			mv.addObject("answer_id", answerId);

		}
		return mv;
	}

////Like A Blog
	@RequestMapping(value = "/blog/like-blog")
	@ResponseBody
	private ModelAndView likeABlog(@RequestParam(required = false, value = "blogId") Long blogId,
			@RequestParam(required = false, value = "total_shared_blog") Long totalSharedBlog, HttpSession session) {
		//// like an blog by blogId
		ModelAndView mv = new ModelAndView();

		User loggedInUser = (User) session.getAttribute("USER");
		if (loggedInUser != null) {
			Long userId = loggedInUser.getId();
			Blog b = new Blog();
			b.setId(blogId);

			LikeDislikeBlog ld = new LikeDislikeBlog();

			//// first check whether the user has already disliked this blog or not if Yes
			//// then UPDATE this as like
			LikeDislikeBlog alreadyDislikedBlogByUser = likeDislikeBlogService.findUserAlreadyDisLikedThisBlog(userId,
					blogId);

			if (alreadyDislikedBlogByUser != null) {
				///// user has already disliked this so update this so get it's Id and set to
				///// the new LikeDislikeBlog Object
				ld.setId(alreadyDislikedBlogByUser.getId()); //// id is necessary to set here for
			}

			ld.setActionDate(new Date());
			ld.setBlog(b);
			ld.setStatus(ConstantRequired.LIKE_BLOG);
			ld.setUser(loggedInUser);

			//// saving like or updating disliked answer
			LikeDislikeBlog ld1 = likeDislikeBlogService.likeDislikeBlog(ld); /// no use of this new object

			//// now get all liked and disliked blogs
			Long allLikedBlog = likeDislikeBlogService.countAllLikedBlogsByBlogId(blogId);
			Long allDisLikedBlog = likeDislikeBlogService.countAllDislikedBlogsByBlogId(blogId);

			mv.setViewName("includes/action-icons-list-with-like-dislike-for-blog");
			mv.addObject("total_shared", totalSharedBlog); //// this is directly retrieving when like button is
															//// clicking
			mv.addObject("total_disliked", allDisLikedBlog);
			mv.addObject("total_liked", allLikedBlog);
			mv.addObject("blog_status", ConstantRequired.LIKE_BLOG);
			mv.addObject("blog_id", blogId);

		}
		return mv;
	}

////DisLike A Blog
	@RequestMapping(value = "/blog/dislike-blog")
	@ResponseBody
	private ModelAndView DislikeABlog(@RequestParam(required = false, value = "blogId") Long blogId,
			@RequestParam(required = false, value = "total_shared_blog") Long totalSharedBlog, HttpSession session) {
		//// like an blog by blogId
		ModelAndView mv = new ModelAndView();

		User loggedInUser = (User) session.getAttribute("USER");
		if (loggedInUser != null) {
			Long userId = loggedInUser.getId();
			Blog b = new Blog();
			b.setId(blogId);

			LikeDislikeBlog ld = new LikeDislikeBlog();

			//// first check whether the user has already liked this blog or not if Yes
			//// then UPDATE this as dislike
			LikeDislikeBlog alreadyLikedBlogByUser = likeDislikeBlogService.findUserAlreadyLikedThisBlog(userId,
					blogId);

			if (alreadyLikedBlogByUser != null) {
				///// user has already liked this so update this so get it's Id and set to
				///// the new LikeDislikeBlog Object
				ld.setId(alreadyLikedBlogByUser.getId()); //// id is necessary to set here for
			}

			ld.setActionDate(new Date());
			ld.setBlog(b);
			ld.setStatus(ConstantRequired.DISLIKE_BLOG);
			ld.setUser(loggedInUser);

			//// saving dislike or updating liked blog
			LikeDislikeBlog ld1 = likeDislikeBlogService.likeDislikeBlog(ld); /// no use of this new object

			//// now get all liked and disliked blogs
			Long allLikedBlog = likeDislikeBlogService.countAllLikedBlogsByBlogId(blogId);
			Long allDisLikedBlog = likeDislikeBlogService.countAllDislikedBlogsByBlogId(blogId);

			mv.setViewName("includes/action-icons-list-with-like-dislike-for-blog");
			mv.addObject("total_shared", totalSharedBlog); //// this is directly retrieving when like button is
															//// clicking
			mv.addObject("total_disliked", allDisLikedBlog);
			mv.addObject("total_liked", allLikedBlog);
			mv.addObject("blog_status", ConstantRequired.LIKE_BLOG);
			mv.addObject("blog_id", blogId);

		}
		return mv;
	}

	/// manage page for user skills
	@RequestMapping(value = "/user-skills/manage")
	private String manageUserSkills(Model m, HttpSession session) {
		/// find all the skills of the current user or loggedIn user
		User user = (User) session.getAttribute("USER");
		if (user == null)
			return "redirect:/index? act=please login back!";
		Long userId = user.getId();

		/// fetch all Other accounts like facebook, twitter, linkedin etc urls
		OtherAccount otherAccounts = otherAccountService.findOtherAccountsByUserId(userId);
		m.addAttribute("OTHER_ACCOUNTS", otherAccounts);

		/// fetching all the user skills and display onto the user profile
		Collection<UserSkill> userSkills = userSkillService.findAllSkillsByUserId(userId);
		m.addAttribute("USER_SKILL_LIST", null);
		if (userSkills.size() != 0) {
			m.addAttribute("USER_SKILL_LIST", userSkills);
		}

		//// for adding new skills to the user profile
		m.addAttribute("ADD_USER_SKILL", new AddUserSkillsCommand());
		return "user-modules/manage-user-skills";
	}

	/// search skills to add in user profile
	@RequestMapping(value = "/skills/search_skills")
	@ResponseBody
	private ModelAndView searchSkills(@RequestParam(required = false, value = "skillKey") String skillKey) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user-modules/searched-skills-list");

		/// lets find all the matched skills by skill key from database
		Collection<Skill> searchedSkills = skillService.searchSkills(skillKey);
		if (searchedSkills.size() == 0) {
			mv.addObject("SKILL_LIST", null);
		} else {
			mv.addObject("SKILL_LIST", searchedSkills);
		}
		return mv;
	}

	/// save user skills
	@RequestMapping(value = "/skills/add_more_skills")
	private String saveUserSkills(@ModelAttribute("ADD_USER_SKILL") AddUserSkillsCommand cmd) {

		String[] skills = cmd.getSkills();
		Collection<UserSkill> userSkills = new ArrayList<UserSkill>();
		if (skills != null) {
			for (String skill : skills) {
				if (skill != null) {
					System.out.println("skill is : " + skill);
					UserSkill userSkill = new UserSkill();
					User user = new User();
					user.setId((long) 5);

					userSkill.setSkillName(skill);
					userSkill.setUser(user);

					userSkills.add(userSkill);
				}
			}
		} else {
			return "redirect:/user-skills/manage? err = something went wrong! please try again";
		}
		if (userSkills.size() != 0) {
			Collection<UserSkill> savedSkills = userSkillService.addUserSkills(userSkills);
			if (savedSkills.size() != 0) {
				return "redirect:/user-skills/manage?msg = skills have been added successfully!";
			} else {
				return "redirect:/user-skills/manage? err = failed to add skills!";
			}
		} else {
			return "redirect:/user-skills/manage? err = something went wrong! please try again";
		}
	}

	/// remove skills (Bulk or single skills)
	@RequestMapping(value = "/skills/remove-skills")
	private String removeSkills(@RequestParam(required = false, value = "userSkillIds") Long[] userSkillIds) {

		if (userSkillIds == null) {
			return "redirect:/user-skills/manage?please select the skills to delete!";
		}

		if (userSkillService.deleteBulkSkillsBySkillsIds(userSkillIds)) {
			return "redirect:/user-skills/manage?msg=The selected skills have been removed successfully!";
		}
		return "redirect:/user-skills/manage?err=Oops! something went wrong!";
	}

	//// link other accounts
	@RequestMapping(value = "/user-account/link-other-accounts")
	private String linkOtherAccounts(@ModelAttribute("OTHER_ACCOUNTS") OtherAccount oa, HttpSession session) {
		User user = (User) session.getAttribute("USER");
		if (user == null)
			return "redirect:/index? act=please login back!";
		Long userId = user.getId();

		oa.setUser(user);
		System.out.println("all the urls are : " + oa);
		if (oa.getFacebookUrl() != null || oa.getGoogleUrl() != null || oa.getTwitterUrl() != null
				|| oa.getLinkedinUrl() != null || oa.getQuoraUrl() != null || oa.getYoutubeUrl() != null) {
			/// first find account urls which are already linked to the current user
			//// if it is already found then retrieve the other_account_id and set it the
			/// new OtherAccount object else insert.
			OtherAccount existingAccount = otherAccountService.findOtherAccountsByUserId(userId);
			if (existingAccount != null) {
				/// means account_urls already exists
				oa.setId(existingAccount.getId());
				OtherAccount otherAccount = otherAccountService.saveOtherAccount(oa);
				if (otherAccount != null)
					return "redirect:/user/user_profile?msg=changes applied";
			} else {
				/// user skills are not added so simply insert
				OtherAccount otherAccount = otherAccountService.saveOtherAccount(oa);
				if (otherAccount != null)
					return "redirect:/user/user_profile?msg=changes applied";
			}

		}
		return "redirect:/user/user_profile";
	}

	//// edit personal information page
	@RequestMapping(value = "/account/edit-personal-info")
	private String editPersonalInfoPage(Model m, HttpSession session) {
		User currentUser = (User) session.getAttribute("USER");
		if (currentUser == null)
			return "redirect:/index? act=please login back!";
		Long userId = currentUser.getId();

		/// fetch all Other accounts like facebook, twitter, linkedin etc urls
		OtherAccount otherAccounts = new OtherAccount();
		OtherAccount accounts = otherAccountService.findOtherAccountsByUserId(userId);
		if (accounts == null)
			m.addAttribute("OTHER_ACCOUNTS", otherAccounts);
		else
			m.addAttribute("OTHER_ACCOUNTS", accounts);

		/// TODO: later on this code will be removed to find user bcz user already
		/// exists in session
		// so we will get user by session
		User user = userService.findUserById(userId).get();
		// TODO: later on this code will be here
//		User user = (User) session.getAttribute("USER");
		if (user == null)
			return "redirect:/index";

		//// finding all the colleges of the current user to set default college
		Collection<College> allColleges = collegeService.findAllCollegesByUserId(userId);
		if (allColleges.size() == 0)
			m.addAttribute("USER_COLLEGES", null);
		else
			m.addAttribute("USER_COLLEGES", allColleges);

		m.addAttribute("USER_COMMAND", user);

		return "user-modules/edit-personal-info";
	}

	//// update personal information of an user
	@RequestMapping(value = "/user-account/update-personal-info")
	private String updateUserPersonalInfo(@ModelAttribute("USER_COMMAND") User u, HttpSession session) {

		User sessionUser = (User) session.getAttribute("USER");
		if (sessionUser == null)
			return "redirect:/index? act=please login back!";
		Long userId = sessionUser.getId();

		User currentUser = userService.findUserById(userId).get();
		try {
			if (u != null && currentUser != null) {

				currentUser.setName(u.getName());
				currentUser.setCollege(u.getCollege());
				currentUser.setCollegeLink(u.getCollegeLink());
				currentUser.setDefaultCollege(u.getDefaultCollege());
				currentUser.setAbout(u.getAbout());

				User newUser = userService.updateUser(currentUser);
				if (newUser != null) {
					/// add new user to the session
					addUserInSession(newUser, session);
					return "redirect:/account/edit-personal-info?msg=account updated";
				}
			}
		} catch (DataTruncationException e) {
			return "redirect:/index?err = Data too long passing to the fields";
		}
		return "redirect:/index?msg=something went wrong! please login back";
	}

////update account login information of an user
	@RequestMapping(value = "/user-account/update-account-login-details")
	private String updateUserAccountLoginDetails(@ModelAttribute("USER_COMMAND") User u, HttpSession session) {
		User sessionUser = (User) session.getAttribute("USER");
		if (sessionUser == null)
			return "redirect:/index? act=please login back!";
		Long userId = sessionUser.getId();
		User currentUser = userService.findUserById(userId).get();

		if (currentUser != null && u != null) {
			if (u.getEmail().equals(currentUser.getEmail()) && u.getUsername().equals(currentUser.getUsername()))
				return "redirect:/account/edit-personal-info? msg = Nothing to update";

			if (u.getUsername() != null) {
				currentUser.setUsername(u.getUsername());
				User userByUsername = userService.findByUsername(u.getUsername());
				if (userByUsername != null)
					return "redirect:/account/edit-personal-info?err=username already exist! please use different username";
			}
			if (u.getEmail() != null) {
				currentUser.setEmail(u.getEmail());
				if (!HelperClass.isValidEmail(u.getEmail())) {
					return "redirect:/account/edit-personal-info?err=email is not valid";
				}
				User userByEmail = userService.findByEamil(u.getEmail());
				if (userByEmail != null)
					return "redirect:/account/edit-personal-info?err=email already exist! please use different email Id";
			}

			/// all set ok, let's update the current user
			User newUser = userService.updateUser(currentUser);
			if (newUser != null) {
				/// add user in session
				addUserInSession(newUser, session);
				return "redirect:/account/edit-personal-info? msg = login details updated";
			} else
				return "redirect:/account/edit-personal-info? msg = Oops! something went wrong, login details updation failed";
		}

		return "redirect:/index?msg=something went wrong! please login back";
	}

	//// Ask a question or create post or ask your doubts
	@RequestMapping(value = "/post/ask-your-doubts")
	private String askYourDoubt(Model m) {
		m.addAttribute("ASK_DOUBT_COMMAND", new AskADoubtCommand());
		return "ask-your-doubt";
	}

////confirm asking or upload user doubts
	@RequestMapping(value = "/question/ask_question")
	private String askQuestion(@ModelAttribute("ASK_DOUBT_COMMAND") AskADoubtCommand cmd, HttpSession session) {

		System.out.println("codes list are : " + cmd.getCodeList());
		//// if question is null then nothing should have to store
		if (cmd.getQuestion().getQuestion() == null)
			return "redirect:/post/ask-your-doubts";

		User sessionUser = (User) session.getAttribute("USER");
		if (sessionUser == null)
			return "redirect:/index? act=please login back!";
		Long userId = sessionUser.getId();

		Question q = cmd.getQuestion();
		q.setUser(sessionUser);
		q.setDate(new Date());

		/// uploading question
		Question savedQuestion = questionService.saveQuestion(q);
		if (savedQuestion == null)
			return "redirect:/post/ask-your-doubts?err = Oops! something went wrong, your doubt couldn't proceed.";

		/// uploading files
		if (cmd.getFileUploadCommand().getFiles().length > 1) {
			Collection<QuestionFile> uploadedFilesInDirectory = HelperClass.uploadQuestionFiles(savedQuestion,
					cmd.getFileUploadCommand().getFiles(), ConstantRequired.uploadQuestionFileDirectory);
			if (uploadedFilesInDirectory.size() != 0) {
				questionService.saveAllQuestionFiles(uploadedFilesInDirectory);
			}
		}
		/// uploading codes with titles and descs
		if (cmd.getCodeList().size() != 0) {
			Collection<QuestionCode> codes = cmd.getCodeList();
			/// checking if a list of code is having title and desc null value, just remove
			/// it
			Collection<QuestionCode> extructedCodes = new ArrayList<QuestionCode>();
			for (QuestionCode code : codes) {
				if (!(code.getCodeTitle().isEmpty() && code.getCodeDesc().isEmpty())) {
					QuestionCode qc = new QuestionCode();
					qc.setQuestion(savedQuestion);

					if (code.getCodeTitle() != null) {
						qc.setCodeTitle(code.getCodeTitle());
					}
					if (code.getCodeDesc() != null) {
						qc.setCodeDesc(code.getCodeDesc());
					}
					extructedCodes.add(qc);
				}

			}
			Collection<QuestionCode> savedCodes = new ArrayList<QuestionCode>();
			if (extructedCodes.size() != 0)
				savedCodes = (Collection<QuestionCode>) questionService.saveAllQuestionCodes(extructedCodes);
			else
				return "redirect:/post/ask-your-doubts? msg = Your question has uploaded successfully!";

			if (savedCodes.size() != 0)
				return "redirect:/post/ask-your-doubts? msg = Your question has uploaded successfully!";
			else
				return "redirect:/post/ask-your-doubts? msg = Your question has uploaded but something went wrong in uploading attached codes";
		}

		return "redirect:/post/ask-your-doubts? msg = Your question has uploaded successfully!";
	}

	/// update cropped profile image
	@RequestMapping(value = "/user-profile/update-profile-image")
	@ResponseBody
	private String updateCroppedProfileImage(
			@RequestParam(required = false, value = "profileImage") String profileImage, Model m, HttpSession session)
			throws IOException, Exception {
		String response = "FAILED";
		User sessionUser = (User) session.getAttribute("USER");
		if (sessionUser == null)
			return "redirect:/index? act=please login back!";
		System.out.println("sessionUser : " + sessionUser);
		Long userId = sessionUser.getId();

		System.out.println("profile image : " + profileImage);
		/// cropped image : data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAJY.......
		String fileName = userId + "_" + HelperClass.getRandomIntegerBetweenRange(99999, 999999) + ".png";

		if (UploadCroppedImage.uploadImage(profileImage, fileName, ConstantRequired.uploadProfileImageDirectory)) {

			/// add current image file name to the sessionUser and then add this user in
			/// session again
			sessionUser.setImage(fileName);
			System.out.println(" before updation : " + sessionUser);
			User newUser = userService.updateUser(sessionUser);
			if (newUser != null) {
				System.out.println(" after updation : " + newUser);
				addUserInSession(newUser, session);
				response = "SUCCESS";
			}

		}

		return response;
	}

	/// update cropped cover image
	@RequestMapping(value = "/user-profile/update-cover-image")
	@ResponseBody
	private String updateCroppedCoverImage(@RequestParam(required = false, value = "coverImage") String coverImage,
			Model m, HttpSession session) throws IOException, Exception {
		String response = "FAILED";
		User sessionUser = (User) session.getAttribute("USER");
		if (sessionUser == null)
			return "redirect:/index? act=please login back!";
		Long userId = sessionUser.getId();

		/// cropped image : data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAJY.......
		String fileName = userId + "_" + HelperClass.getRandomIntegerBetweenRange(99999, 999999) + ".png";

		if (UploadCroppedImage.uploadImage(coverImage, fileName, ConstantRequired.uploadCoverImageDirectory)) {

			/// add current image file name to the sessionUser and then add this user in
			/// session again
			sessionUser.setCoverImage(fileName);
			User newUser = userService.updateUser(sessionUser);
			if (newUser != null) {
				addUserInSession(newUser, session);
				response = "SUCCESS";
			}
		}

		return response;
	}

	/// write an answer to a question
	@RequestMapping(value = "/question/write-answer")
	private String writeAnAnswerToAQuestionPage(@RequestParam("questionId") Long questionId, Model m) {

		if (questionId == 0)
			return "redirect:/index?err = Question Not Found!";

		Question question = questionService.findQuestionById(questionId).orElse(new Question());

		if (question.getId() == null)
			return "redirect:/index?err = Question Not Found!";

		WriteAnAnswer writeAnAnswer = new WriteAnAnswer();

		writeAnAnswer.setQuestion(question);
		m.addAttribute("WRITE_AN_ANSWER", writeAnAnswer);
		return "write-an-answer";
	}

	/// write an answer to a question
	@RequestMapping(value = "/question/add-answer")
	private String addAnAnswerToAQuestionPage(@RequestParam("questionId") Long questionId,
			@ModelAttribute("WRITE_AN_ANSWER") WriteAnAnswer cmd, Model m, HttpSession session) {

		try {
			System.out.println("codes list are : " + cmd.getCodeList());
			//// if question is null then nothing should have to store
			if (cmd.getQuestion().getQuestion() == null)
				return "redirect:/index?err=something went wrong.";

			User sessionUser = (User) session.getAttribute("USER");
			if (sessionUser == null)
				return "redirect:/index? act=please login back!";
			Long userId = sessionUser.getId();

			Question q = cmd.getQuestion();
			q.setId(questionId);
			Answer a = cmd.getAnswer();
			a.setQuestion(q);
			a.setUser(sessionUser);
			a.setDate(new Date());

			/// uploading answer
			Answer savedAnswer = answerService.saveAnswer(a);
			if (savedAnswer == null)
				return "redirect:/index?err = Oops! something went wrong, answer couldn't proceed.";

			if (cmd.getFileUploadCommand().getFiles().length > 1) {
				Collection<AnswerFile> uploadedFilesInDirectory = HelperClass.uploadAnswerFiles(savedAnswer,
						cmd.getFileUploadCommand().getFiles(), ConstantRequired.uploadAnswerFileDirectory);
				if (uploadedFilesInDirectory.size() != 0) {
					answerFileService.saveAllAnswerFiles(uploadedFilesInDirectory);
				}
			}
			/// uploading codes with titles and descs
			if (cmd.getCodeList().size() != 0) {
				Collection<AnswerCode> codes = cmd.getCodeList();
				System.out.println(" code is : " + codes);
				/// checking if a list of code is having title and desc null value, just remove
				/// it
				Collection<AnswerCode> extructedCodes = new ArrayList<AnswerCode>();
				for (AnswerCode code : codes) {
					if (!(code.getCodeTitle().isEmpty() && code.getCodeDesc().isEmpty())) {
						AnswerCode ac = new AnswerCode();
						ac.setAnswer(savedAnswer);

						if (code.getCodeTitle() != null) {
							ac.setCodeTitle(code.getCodeTitle());
						}
						if (code.getCodeDesc() != null) {
							ac.setCodeDesc(code.getCodeDesc());
						}
						extructedCodes.add(ac);
					}
				}
				Collection<AnswerCode> savedCodes = new ArrayList<AnswerCode>();
				if (extructedCodes.size() != 0)
					savedCodes = (Collection<AnswerCode>) answerCodeService.saveAllAnswerCodes(extructedCodes);
				else
					return "redirect:/index? msg = Your answer has added successfully!";

				if (savedCodes.size() != 0)
					return "redirect:/index? msg = Your answer has added successfully!";
				else
					return "redirect:/index? msg = Your answer has added but something went wrong in uploading attached codes";
			}

			return "redirect:/index? msg = Your answer has added successfully!";
		} catch (ConstraintViolationException e) {
			return "redirect:/index? msg = Oops! something went wrong...";
		}
	}

	/// wring blog page
	@RequestMapping(value = "/blog/write-a-blog")
	private String createABlogPage(Model m, @RequestParam("collegeId") Long collegeId) {
		College college = new College();
		if (collegeId != 0)
			college = collegeService.findCollegeById(collegeId).orElse(new College());
		if (college.getId() == null)
			return "redirect:/index?err=college does not exists!";
		Blog blog = new Blog();
		blog.setCollege(college);

		m.addAttribute("CREATE_BLOG", blog);
		return "create-blog";
	}

	/// upload the blog
	@RequestMapping(value = "/blog/post-blog")
	private String uploadBlog(@ModelAttribute("CREATE_BLOG") Blog blog, HttpSession session,
			@RequestParam("collegeId") Long collegeId) {
		User user = (User) session.getAttribute("USER");
		if (user == null)
			return "redirect:/index?msg=please login back!";

		College college = new College();
		if (collegeId != 0)
			college = collegeService.findCollegeById(collegeId).orElse(new College());
		if (college.getId() == null)
			return "redirect:/index?err=college does not exists!";

		if (!(blog.getTitle().isEmpty() || blog.getDesc().isEmpty())) {
			return "redirect:/blog/write-a-blog?msg = Empty blog can not be uploaded!";
		}

		blog.setCollege(college);
		blog.setUser(user);
		blog.setWrittenOn(new Date());

		Blog uploadedBlog = blogService.saveBlog(blog);
		if (uploadedBlog == null)
			return "redirect:/blog/write-a-blog?msg=something went wrong, blog has not uploaded!";
		else
			return "redirect:/blog/write-a-blog?msg=blog has uploaded successfully!";
	}

	//// publishing the blog
	@RequestMapping(value = "/blog/publish-blog")
	@ResponseBody
	private String publishBlog(@RequestParam("collegeId") Long collegeId, HttpSession session,
			@RequestParam(required = false, value = "blogTitle") String blogTitle,
			@RequestParam(required = false, value = "blogDesc") String blogDesc) {
		System.out.println("college Id : " + collegeId);
		String response = "FAILED";

		User u = (User) session.getAttribute("USER");
		if (u == null || collegeId == 0)
			return "FAILED";

		College c = new College();
		c.setId(collegeId);

		Blog b = new Blog();
		b.setUser(u);
		b.setCollege(c);
		b.setTitle(blogTitle);
		b.setDesc(blogDesc);
		b.setWrittenOn(new Date());

		Blog blog = blogService.saveBlog(b);
		if (blog != null)
			response = "PUBLISHED";
		return response;
	}

	/// show/view single blog
	@RequestMapping(value = "/blog/show-blog")
	private String showSingleBlog(@RequestParam("blogId") Long blogId, Model m) {
		Optional<Blog> b = null;
		Blog blog = new Blog();
		if (blogId != 0)
			b = blogService.findBlogById(blogId);
		if (b.isPresent())
			blog = b.get();

		if (blog.getId() == null)
			m.addAttribute("BLOG", null);
		else {
			BlogEmbedded be = new BlogEmbedded();
			Long allLikedBlog = likeDislikeBlogService.countAllLikedBlogsByBlogId(blog.getId());
			Long totalDislikedBlog = likeDislikeBlogService.countAllDislikedBlogsByBlogId(blog.getId());
			be.setTotalLikedBlog(allLikedBlog);
			be.setTotalDislikedBlog(totalDislikedBlog);
			blog.setBlogEmbedded(be);
			m.addAttribute("BLOG", blog);
		}

		//// finding all the blog of the associated user with the selected the blog
		m.addAttribute("BLOGS", null);
		if (blog.getId() != null) {
			Long userId = blog.getUser().getId();
			Collection<Blog> blogs = blogService.findAllBlogsByUserId(userId);

			if (blogs.size() == 0)
				m.addAttribute("BLOGS", null);
			else {
				/// fetch all the likes, dislikes and shared to the each blog
				for (Blog b1 : blogs) {
					BlogEmbedded be = new BlogEmbedded();
					Long allLikedBlog = likeDislikeBlogService.countAllLikedBlogsByBlogId(b1.getId());
					Long totalDislikedBlog = likeDislikeBlogService.countAllDislikedBlogsByBlogId(b1.getId());
					be.setTotalLikedBlog(allLikedBlog);
					be.setTotalDislikedBlog(totalDislikedBlog);
					b1.setBlogEmbedded(be);
				}
				m.addAttribute("BLOGS", blogs);
			}
		}
		return "show-single-blog";
	}

	//// edit blog page
	@RequestMapping(value = "/blog/edit-blog")
	private String editBlogPage(@RequestParam("blogId") Long blogId, Model m, HttpSession session) {
		User user = (User) session.getAttribute("USER");
		if (user == null)
			return "redirect:/index?please login back";
		Blog b = blogService.findBlogById(blogId).orElse(new Blog());
		if (user.getId() != b.getUser().getId())
			return "redirect:/index?Access Denied";

		m.addAttribute("BLOG", b);
		return "edit-blog";
	}

	//// update published blog
	@RequestMapping(value = "/blog/update-published-blog")
	@ResponseBody
	private String updatePublishedBlog(@RequestParam("blogId") Long blogId, @RequestParam("collegeId") Long collegeId,
			@RequestParam(required = false, value = "blogTitle") String title,
			@RequestParam(required = false, value = "blogDesc") String desc, HttpSession session) {
		User user = (User) session.getAttribute("USER");
		if (user == null)
			return "FAILED";

		Blog b = blogService.findBlogById(blogId).orElse(new Blog());
		if (b.getId() == null)
			return "FAILED";

		if (user.getId() != b.getUser().getId())
			return "FAILED";

		if (title != null)
			b.setTitle(title);

		if (desc != null)
			b.setDesc(desc);

		College c = new College();
		c.setId(collegeId);
		b.setCollege(c);

		b.setUser(user);

		Blog blg = blogService.saveBlog(b);
		if (blg != null)
			return "UPDATED";
		return "FAILED";

	}

////delete blog
	@RequestMapping(value = "/blog/delete-blog")
	private String deleteABlog(@RequestParam("blogId") Long blogId, Model m, HttpSession session) {
		User user = (User) session.getAttribute("USER");
		if (user == null)
			return "redirect:/index?act = please login back!";

		Blog b = blogService.findBlogById(blogId).orElse(new Blog());
		if (b.getId() == null)
			return "redirect:/index?act = blog does not exists!";
		if (b.getUser().getId() != user.getId())
			return "redirect:/index?act = you don't have permission to perform this operation";

		//// now deleting logic start...
		/// first find all the associations such as like, dislike etc. and delete it.
		Collection<LikeDislikeBlog> ldb = likeDislikeBlogService.findLikeDislikeBlogsByBlogId(blogId);

		if (ldb.size() != 0) {
			Collection<Long> ids = new ArrayList<Long>();
			for (LikeDislikeBlog bb : ldb) {
				/// collecting all the ids in an array or set or list or collection
				ids.add(bb.getId());
			}
			if (ids.size() != 0) {
				likeDislikeBlogService.deleteAllByIds(ids);
			}
		}

		/// now after deletion of all the associations let's delete the blog
		if (blogService.deleteBlogById(blogId))
			return "redirect:/index? msg = Blog deleted successfully!";

		return "redirect:/index? err = Oops! something went wrong, blog deletion failed!";
	}
	
	///edit asked questions
	@RequestMapping(value="/question/edit-asked-question")
	private String editAskedQuestion(@RequestParam("questionId") Long questionId) {
		
		if(questionId == 0)
		{
			
		}
		else {
			
			
			
		}
		return "";
	}
	
	
}
