package com.codinghub.collegebuddy.services;

import java.util.Collection;
import java.util.Optional;

import com.codinghub.collegebuddy.domain.AnswerFile;

public interface AnswerFileService {
	/**
	 * save All the AnswerFiles
	 * 
	 * @param answerFiles
	 * @return
	 */
	public Iterable<AnswerFile> saveAllAnswerFiles(Collection<AnswerFile> answerFiles);

	/**
	 * find AnswerFile by answerFileById
	 * 
	 * @param answerFileId
	 * @return
	 */
	public Optional<AnswerFile> findAnswerFileById(long answerFileId);

	/**
	 * find all the AnswerFiles by answerId (declared in 'AnswerFileRepository'
	 * interface)
	 * 
	 * @param answerId
	 * @return
	 */
	public Collection<AnswerFile> findAllAnswerFilesByAnswerId(long answerId);

	/**
	 * count all the answer files
	 * 
	 * @return
	 */
	public long countAllAnswerFiles();

	/**
	 * count all the answer files by answerId
	 * 
	 * @param answerId
	 * @return
	 */
	public long countAllAnswerFilesByAnswerId(long answerId);

	/**
	 * updating a single AnswerFile (must set answerFileId to this object)
	 * 
	 * @param answerFile
	 * @return
	 */

	public AnswerFile updateAnswerFile(AnswerFile answerFile);

	/**
	 * deleting AnswerFile by answerFileId
	 * 
	 * @param answerFileId
	 * @return
	 */
	public boolean deleteAnswerFileById(long answerFileId);

	/**
	 * Deleting bulk of AnswerFiles
	 * 
	 * @param answerFiles
	 * @return
	 */
	public boolean deleteBulkAnswerFiles(Collection<AnswerFile> answerFiles);

}
