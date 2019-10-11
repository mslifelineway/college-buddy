package com.codinghub.collegebuddy.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.codinghub.collegebuddy.domain.Question;
import com.codinghub.collegebuddy.domain.User;

public interface UserService {

	/**
	 * saving a single user object and returning the saved user data as user object
	 * 
	 * @param user
	 * @return
	 */
	public User saveUser(User user);

	/**
	 * find user by userId
	 * 
	 * @param userId
	 * @return
	 */
	public Optional<User> findUserById(long userId);

	/**
	 * save all the users or list of user
	 * 
	 * @param users
	 * @return
	 */
	public Iterable<User> saveAllUser(List<User> users);

	/**
	 * find all the users
	 * 
	 * @return
	 */
	public Iterable<User> findAllUsers();

	/**
	 * Finding The Users Who Have Written or asked questions By Questions
	 * 
	 * @param questions
	 * @return
	 */
	public Collection<User> findUsersByQuestions(Iterable<Question> questions);

	/**
	 * find out that user is exists or not by userId
	 * 
	 * @param userId
	 * @return
	 */
	public boolean isUserExistsWithId(long userId);

	/**
	 * finding all the user by passing list ids.
	 * 
	 * @param userIds
	 * @return
	 */
	public Iterable<User> findAllUserByIds(Iterable<Long> userIds);

	/**
	 * counting all the user available in users table/entity
	 * 
	 * @return
	 */
	public Long countAllUser();

	/**
	 * Updating user by passing user object
	 * 
	 * @param user
	 * @return
	 */
	public User updateUser(User user);

	/**
	 * deleting user by userId.
	 * 
	 * @param userId
	 */
	public boolean deleteUserById(Long userId);

	/**
	 * find user by username
	 * 
	 * @param username
	 * @return
	 */
	public User findByUsername(String username);

	/**
	 * find user by email
	 * 
	 * @param username
	 * @return
	 */
	public User findByEamil(String email);

	/**
	 * Find by username and email (EX. email: javaworld@gmail.com, username =
	 * javaworld)
	 * 
	 * @param email
	 * @param username
	 * @return
	 */
	public User findByEamilAndUsername(String email, String username);

	/**
	 * Login user by email and password (hashed by md5())
	 * 
	 * @param username
	 * @param hashedPassword
	 * @return
	 */
	public User loginUser(String username, String hashedPassword);

	/**
	 * Find user by username
	 * 
	 * @param username
	 * @return
	 */
	public User findUserByUsername(String username);

	/**
	 * Find user by userEmail
	 * 
	 * @param username
	 * @return
	 */
	public User findUserByUserEmail(String userEmail);

}
