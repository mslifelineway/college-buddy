package com.codinghub.collegebuddy.services;

import java.util.Collection;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codinghub.collegebuddy.domain.Question;
import com.codinghub.collegebuddy.domain.QuestionCode;
import com.codinghub.collegebuddy.domain.QuestionFile;
import com.codinghub.collegebuddy.repositories.QuestionCodeRepository;
import com.codinghub.collegebuddy.repositories.QuestionFileRepository;
import com.codinghub.collegebuddy.repositories.QuestionRepository;

@Service
public class QuestionServiceImplementation implements QuestionService {

	@Autowired
	private QuestionRepository questionRepo;

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private QuestionFileRepository questionFileRepo;

	@Autowired
	private QuestionCodeRepository questionCodeRepo;

///// QUESTION ENTITY RELATED OPERATION
	@Override
	public Question saveQuestion(Question q) {
		return questionRepo.save(q);
	}

	@Override
	public Iterable<Question> saveAllQuestions(Collection<Question> allQuestions) {
		if (allQuestions != null)
			return questionRepo.saveAll(allQuestions);
		return null;
	}

	@Override
	public Question updateQuestion(Question q) {
		return questionRepo.save(q);
	}

	@Override
	public Optional<Question> findQuestionById(long questionId) {
		if (questionId != 0)
			return questionRepo.findById(questionId);
		return null;
	}

	@Override
	public Iterable<Question> findAllQuestions() {
		return questionRepo.findAll();
	}

	@Override
	public Iterable<Question> findAllQuestionsByUserId(long userId) {
		return questionRepo.findAllByUserId(userId);
	}

	@Override
	public Long countAllQuestions() {
		return questionRepo.count();
	}

	@Override
	public Long countAllQuestionsByUserId(long userId) {
		return questionRepo.countByUserId(userId);
	}

	@Override
	public boolean deleteQuestionById(long questionId) {

		if (questionId != 0) {
			questionRepo.deleteById(questionId);
			return true;
		}
		return false;

	}

///// QUESTION FILE ENTITY RELATED OPERATION

	@Override
	public Iterable<QuestionFile> saveAllQuestionFiles(Collection<QuestionFile> questionFiles) {
		if (questionFiles != null)
			return questionFileRepo.saveAll(questionFiles);
		return null;
	}

	@Override
	public Optional<QuestionFile> findQuestionFileById(long questionFileId) {
		if (questionFileId != 0)
			return questionFileRepo.findById(questionFileId);
		return null;
	}

	@Override
	public Collection<QuestionFile> findAllQuestionFilesByQuestionId(long questionId) {
		if (questionId != 0)
			return questionFileRepo.findAllByQuestionId(questionId);
		return null;
	}

	@Override
	public long countQuestionFilesByQuestionId(long questionId) {
		if (questionId != 0)
			return questionFileRepo.countByQuestionId(questionId);
		return 0;
	}

	@Override
	public QuestionFile updateQuestionFile(QuestionFile questionFile) {
		if (questionFile != null)
			return questionFileRepo.save(questionFile);
		return null;
	}

	@Override
	public boolean deleteQuestionFileById(long questionFileId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBulkQuestionFiles(Collection<QuestionFile> questionFiles) {
		// TODO Auto-generated method stub
		return false;
	}

//// Question Code

	@Override
	public Iterable<QuestionCode> saveAllQuestionCodes(Collection<QuestionCode> questionCodes) {
		if (questionCodes != null)
			return questionCodeRepo.saveAll(questionCodes);
		return null;
	}

	@Override
	public Optional<QuestionCode> findQuestionCodeById(long questionCodeId) {
		if (questionCodeId != 0)
			return questionCodeRepo.findById(questionCodeId);
		return null;
	}

	@Override
	public Collection<QuestionCode> findAllQuestionCodesByQuestionId(long questionId) {
		if (questionId != 0)
			return questionCodeRepo.findAllByQuestionId(questionId);
		return null;
	}

	@Override
	public long countQuestionCodesByQuestionId(long questionId) {
		return questionCodeRepo.countByQuestionId(questionId);
	}

	@Override
	public QuestionCode updateQuestionCode(QuestionCode questionCode) {
		if (questionCode != null)
			return questionCodeRepo.save(questionCode);
		return null;
	}

	@Override
	public boolean deleteQuestionCodeById(long questionCodeId) {
		if (questionCodeId != 0) {
			questionCodeRepo.deleteById(questionCodeId);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteBulkQuestionCodes(Collection<QuestionCode> questionCodes) {
		if (questionCodes != null) {
			questionCodeRepo.deleteAll(questionCodes);
			return true;
		}
		return false;
	}

}
