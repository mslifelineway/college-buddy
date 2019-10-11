package com.codinghub.collegebuddy.repositories;

import java.util.Collection;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.repository.CrudRepository;

import com.codinghub.collegebuddy.domain.Question;
import com.codinghub.collegebuddy.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{

	public User findByUsername(String username);
	
	public User findByEmail(String userEmail);
	
	public Collection<User> findByQuestions(Iterable<Question> questions) throws DataIntegrityViolationException;
	
	public User findByEmailAndUsername(String email, String username);
	
}
