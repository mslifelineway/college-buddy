package com.codinghub.collegebuddy.services;

import java.util.Collection;
import java.util.Optional;

import com.codinghub.collegebuddy.domain.AnswerCode;

public interface AnswerCodeService {
	/**
	 * save All the AnswerCodes
	 * 
	 * @param answerCodes
	 * @return
	 */
	public Iterable<AnswerCode> saveAllAnswerCodes(Collection<AnswerCode> answerCodes);

	/**
	 * find AnswerCode by answerCodeById
	 * 
	 * @param answerCodeId
	 * @return
	 */
	public Optional<AnswerCode> findAnswerCodeById(long answerCodeId);

	/**
	 * find all the AnswerCodes by answerId (declared in 'AnswerCodeRepository'
	 * interface)
	 * 
	 * @param answerId
	 * @return
	 */
	public Collection<AnswerCode> findAllAnswerCodesByAnswerId(long answerId);

	public long countAllAnswerCodes();

	public long countAllAnswerCodesByAnswerId(long answerId);

	/**
	 * updating a single AnswerCode (must set answerCodeId to this object)
	 * 
	 * @param answerCode
	 * @return
	 */
	public AnswerCode updateAnswerCode(AnswerCode answerCode);

	/**
	 * deleting AnswerCode by answerCode
	 * 
	 * @param answerCodeId
	 * @return
	 */
	public boolean deleteAnswerCodeById(long answerCodeId);

	/**
	 * Deleting bulk of AnswerCodes
	 * 
	 * @param answerCodes
	 * @return
	 */
	public boolean deleteBulkAnswerCodes(Collection<AnswerCode> answerCode);

}
