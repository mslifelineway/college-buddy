package com.codinghub.collegebuddy.services;

import java.util.Collection;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codinghub.collegebuddy.domain.AnswerCode;
import com.codinghub.collegebuddy.repositories.AnswerCodeRepository;

@Service
public class AnswerCodeServiceImplementation implements AnswerCodeService {
	@PersistenceContext
	private EntityManager em;

	@Autowired
	private AnswerCodeRepository answerCodeRepo;

	@Override
	public Iterable<AnswerCode> saveAllAnswerCodes(Collection<AnswerCode> answerCodes) {
		if (answerCodes != null)
			return answerCodeRepo.saveAll(answerCodes);
		return null;
	}

	@Override
	public Optional<AnswerCode> findAnswerCodeById(long answerCodeId) {
		if (answerCodeId != 0)
			return answerCodeRepo.findById(answerCodeId);
		return null;
	}

	@Override
	public Collection<AnswerCode> findAllAnswerCodesByAnswerId(long answerId) {
		if (answerId != 0)
			return answerCodeRepo.findAllByAnswerId(answerId);
		return null;
	}

	@Override
	public long countAllAnswerCodes() {
		return answerCodeRepo.count();
	}

	@Override
	public long countAllAnswerCodesByAnswerId(long answerId) {
		if (answerId != 0)
			return answerCodeRepo.countAllByAnswerId(answerId);
		return 0;
	}

	@Override
	public AnswerCode updateAnswerCode(AnswerCode answerCode) {
		if (answerCode != null)
			return answerCodeRepo.save(answerCode);
		return null;
	}

	@Override
	public boolean deleteAnswerCodeById(long answerCodeId) {
		if (answerCodeId != 0) {
			answerCodeRepo.deleteById(answerCodeId);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteBulkAnswerCodes(Collection<AnswerCode> answerCodes) {
		if (answerCodes != null) {
			answerCodeRepo.deleteAll(answerCodes);
			return true;
		}
		return false;
	}

}
