package com.codinghub.collegebuddy.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codinghub.collegebuddy.domain.Question;
import com.codinghub.collegebuddy.domain.User;
import com.codinghub.collegebuddy.repositories.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private UserRepository userRepo;

	@Override
	public User saveUser(User user) {
		if (user != null)
			return userRepo.save(user);
		return null;
	}

	@Override
	public Optional<User> findUserById(long userId) {
		if (userId != 0)
			return userRepo.findById(userId);
		return null;
	}

	@Override
	public Iterable<User> saveAllUser(List<User> users) {
		if (users != null)
			return userRepo.saveAll(users);
		return null;
	}

	@Override
	public Iterable<User> findAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public boolean isUserExistsWithId(long userId) {
		return userRepo.existsById(userId);
	}

	@Override
	public Iterable<User> findAllUserByIds(Iterable<Long> userIds) {
		if (userIds != null)
			return userRepo.findAllById(userIds);
		return null;
	}

	@Override
	public Long countAllUser() {
		return userRepo.count();
	}

	@Override
	public User updateUser(User user) {
		return userRepo.save(user); // save method will also used for update but with this object we need set userId
	}

	@Override
	public boolean deleteUserById(Long userId) {

		if (userId == null || userId == 0)
			return false;
		userRepo.deleteById(userId);
		return true;
	}

	@Override
	public User findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public User findByEamil(String email) {
		return userRepo.findByEmail(email);
	}

	@Override
	public Collection<User> findUsersByQuestions(Iterable<Question> questions) {
		if (questions != null) {
			return userRepo.findByQuestions(questions);
		}
		return null;
	}

	@Override
	public User loginUser(String username, String hashedPassword) {
		try {
			return em.createNamedQuery("User.findByUsernameEmailAndPassword", User.class)
					.setParameter("username", username).setParameter("email", username)
					.setParameter("password", hashedPassword).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}

	@Override
	public User findByEamilAndUsername(String email, String username) {
		if (email != null && username != null)
			return userRepo.findByEmailAndUsername(email, username);
		return null;
	}

	@Override
	public User findUserByUsername(String username) {
		if(username != null)
			return userRepo.findByUsername(username);
		return null;
	}

	@Override
	public User findUserByUserEmail(String email) {
		if(email != null)
			return userRepo.findByEmail(email);
		return null;
	}
}
