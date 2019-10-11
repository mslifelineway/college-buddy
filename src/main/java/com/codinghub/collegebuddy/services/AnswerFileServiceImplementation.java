package com.codinghub.collegebuddy.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codinghub.collegebuddy.domain.AnswerFile;
import com.codinghub.collegebuddy.repositories.AnswerFileRepository;

@Service
public class AnswerFileServiceImplementation implements AnswerFileService {
	@Autowired
	private AnswerFileRepository answerFileRepo;

	@Override
	public Iterable<AnswerFile> saveAllAnswerFiles(Collection<AnswerFile> answerFiles) {
		if (answerFiles != null)
			return answerFileRepo.saveAll(answerFiles);
		return null;
	}

	@Override
	public Optional<AnswerFile> findAnswerFileById(long answerFileId) {
		if (answerFileId != 0)
			return answerFileRepo.findById(answerFileId);
		return null;
	}

	@Override
	public Collection<AnswerFile> findAllAnswerFilesByAnswerId(long answerId) {
		if (answerId != 0)
			return answerFileRepo.findAllByAnswerId(answerId);
		return null;
	}

	@Override
	public long countAllAnswerFiles() {
		return answerFileRepo.count();
	}

	@Override
	public long countAllAnswerFilesByAnswerId(long answerId) {
		if (answerId != 0)
			return answerFileRepo.countAllByAnswerId(answerId);
		return 0;
	}

	@Override
	public AnswerFile updateAnswerFile(AnswerFile answerFile) {
		if (answerFile != null)
			return answerFileRepo.save(answerFile);
		return null;
	}

	@Override
	public boolean deleteAnswerFileById(long answerFileId) {
		if (answerFileId != 0) {
			answerFileRepo.deleteById(answerFileId);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteBulkAnswerFiles(Collection<AnswerFile> answerFiles) {
		if (answerFiles != null) {
			answerFileRepo.deleteAll(answerFiles);
			return true;
		}
		return false;
	}

}
