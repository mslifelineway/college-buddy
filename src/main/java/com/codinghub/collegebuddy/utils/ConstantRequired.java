package com.codinghub.collegebuddy.utils;

public class ConstantRequired {

	public static String uploadProfileImageDirectory = System.getProperty("user.dir")
			+ "/src/main/webapp/static/user_profile_images/";
	
	public static String uploadCoverImageDirectory = System.getProperty("user.dir")
			+ "/src/main/webapp/static/user_profile_images/";
	
	public static String uploadQuestionFileDirectory = System.getProperty("user.dir")
			+ "/src/main/webapp/static/question_files/";
	
	public static String uploadAnswerFileDirectory = System.getProperty("user.dir")
			+ "/src/main/webapp/static/answer_files/";
	
	public static final int DATA_FOR_LEFTSIDE = 1;
	public static final int DATA_FOR_MIDDLESIDE = 2;

	////Answer
	public static final int USER_LIKED_ANSWER_ALREADY = 1;
	public static final int USER_DISLIKED_ANSWER_ALREADY = 2;
	public static final int USER_NOT_LIKED_ANSWER_ALREADY = 0;
	public static final int USER_NOT_DISLIKED_ANSWER_ALREADY = 0;
	public static final int LIKE_ANSWER = 1;
	public static final int DISLIKE_ANSWER = 2;
	public static final int NOT_LIKE_ANSWER = 0;
	public static final int NOT_DISLIKE_ANSWER = 0;
	
	//Blog
	public static final int USER_LIKED_BLOG_ALREADY = 1;
	public static final int USER_DISLIKED_BLOG_ALREADY = 2;
	public static final int USER_NOT_LIKED_BLOG_ALREADY = 0;
	public static final int USER_NOT_DISLIKED_BLOG_ALREADY = 0;
	public static final int LIKE_BLOG = 1;
	public static final int DISLIKE_BLOG = 2;
	public static final int NOT_LIKE_BLOG = 0;
	public static final int NOT_DISLIKE_BLOG = 0;
	
	public static final String DEFAULT_USER_PROFILE_IMAGE = "default_profile_image.png";
	public static final String DEFAULT_USER_COVER_IMAGE = "default_cover_image.png";
	///// constants for college profile
	public static final String DEFAULT_COLLEGE_PROFILE_IMAGE = "default_college_profile_image.jpg";
	public static final String DEFAULT_COLLEGE_COVER_IMAGE = "default_college_cover_image.jpg";
	public static final String COLLEGE_ABOUT = "This college is created by College-Buddy Team and this will manage only by the admin.";
	public static final String COLLEGE_TITLE = "This college is creating only for discussion purose.";
	public static final boolean COLLEGE_STATUS = true; /// That is by default college is Open, not closed

	public static final int JOIN_COLLEGE_STATUS_APPROVED = 2;
	public static final int JOIN_COLLEGE_STATUS_PENDING = 1;

	public static final String FACEBOOK_WEBSITE = "facebook";
	public static final String GOOGLE_WEBSITE = "google";
	public static final String LINKEDIN_WEBSITE = "linkedin";
	public static final String YOUTUBE_WEBSITE = "youtube";
	public static final String QUORA_WEBSITE = "quora";
	public static final String TWITTER_WEBSITE = "twitter";

}
