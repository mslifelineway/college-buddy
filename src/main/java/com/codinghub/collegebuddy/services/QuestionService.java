package com.codinghub.collegebuddy.services;

import java.util.Collection;
import java.util.Optional;

import com.codinghub.collegebuddy.domain.Question;
import com.codinghub.collegebuddy.domain.QuestionCode;
import com.codinghub.collegebuddy.domain.QuestionFile;

public interface QuestionService {
	
	/**
	 * Save a question to question entity
	 * 
	 * @param q
	 * @return
	 */
	public Question saveQuestion(Question q);

	/**
	 * Save All Questions
	 * 
	 * @param allQuestions
	 * @return
	 */
	public Iterable<Question> saveAllQuestions(Collection<Question> allQuestions);

	/**
	 * updating a single question only
	 * 
	 * @param q
	 * @return
	 */
	public Question updateQuestion(Question q);

	/**
	 * Find question ById
	 * 
	 * @param l
	 * @return
	 */
	public Optional<Question> findQuestionById(long l);

	/**
	 * Find all Questions (Only Question entity not it's child entity data)
	 * 
	 * @return
	 */
	public Iterable<Question> findAllQuestions();

	/**
	 * Find All Questions of a particular user by userId
	 * 
	 * @param l
	 * @return
	 */
	public Iterable<Question> findAllQuestionsByUserId(long userId);

	/**
	 * Count all the questions available in question entity
	 * 
	 * @return
	 */
	public Long countAllQuestions();

	/**
	 * Count all the questions Of a Particular User by userId available in question
	 * entity
	 * 
	 * @return
	 */
	public Long countAllQuestionsByUserId(long userId);
	
	/**
	 * delete question by questionId
	 * @param questionId
	 * @return
	 */
	public boolean deleteQuestionById(long questionId);

	//// QUESTION FILE ENTITY OPERATIONS

	/**
	 * save All the question files
	 * 
	 * @param questionFiles
	 * @return
	 */
	public Iterable<QuestionFile> saveAllQuestionFiles(Collection<QuestionFile> questionFiles);

	/**
	 * find question file by questionFileById
	 * 
	 * @param questionFileId
	 * @return
	 */
	public Optional<QuestionFile> findQuestionFileById(long questionFileId);

	/**
	 * find all the question files by questionId (declared in
	 * 'QuestionFileRepository' interface)
	 * 
	 * @param questionId
	 * @return
	 */
	public Collection<QuestionFile> findAllQuestionFilesByQuestionId(long questionId);

	/**
	 * count question files by question id (declared in 'QuestionFileRepository')
	 * 
	 * @param questionId
	 * @return
	 */
	public long countQuestionFilesByQuestionId(long questionId);

	/**
	 * updating a single question file (must set questionFileId to this object)
	 * 
	 * @param questionFile
	 * @return
	 */
	public QuestionFile updateQuestionFile(QuestionFile questionFile);

	/**
	 * deleting question file by questionFileId
	 * 
	 * @param questionFileId
	 * @return
	 */
	public boolean deleteQuestionFileById(long questionFileId);

	/**
	 * Deleting bulk of question files
	 * 
	 * @param questionFiles
	 * @return
	 */
	public boolean deleteBulkQuestionFiles(Collection<QuestionFile> questionFiles);

	///////////////////////////////////////////////////////////////////////////////////

////QUESTION CODE ENTITY OPERATIONS

	/**
	 * save All the question codes
	 * 
	 * @param questionCodes
	 * @return
	 */
	public Iterable<QuestionCode> saveAllQuestionCodes(Collection<QuestionCode> questionCodes);

	/**
	 * find QuestionCodes by questionCodeById
	 * 
	 * @param questionCodeId
	 * @return
	 */
	public Optional<QuestionCode> findQuestionCodeById(long questionCodeId);

	/**
	 * find all the QuestionCodes by questionId (declared in
	 * 'QuestionCodeRepository' interface)
	 * 
	 * @param questionId
	 * @return
	 */
	public Collection<QuestionCode> findAllQuestionCodesByQuestionId(long questionId);

	/**
	 * count question codes by questionId (declared in 'QuestionCodeRepository'
	 * interface)
	 * 
	 * @param questionId
	 * @return
	 */
	public long countQuestionCodesByQuestionId(long questionId);

	/**
	 * updating a single QuestionCode (must set questionCodeId to this object)
	 * 
	 * @param questionCode
	 * @return
	 */
	public QuestionCode updateQuestionCode(QuestionCode questionCode);

	/**
	 * deleting QuestionCode by questionCodeId
	 * 
	 * @param questionCodeId
	 * @return
	 */
	public boolean deleteQuestionCodeById(long questionCodeId);

	/**
	 * Deleting bulk of QuestionCodes
	 * 
	 * @param questionCode
	 * @return
	 */
	public boolean deleteBulkQuestionCodes(Collection<QuestionCode> questionCodes);

	
	
}
