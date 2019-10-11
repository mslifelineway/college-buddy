package com.codinghub.collegebuddy.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codinghub.collegebuddy.domain.Answer;
import com.codinghub.collegebuddy.repositories.AnswerRepository;

@Service
public class AnswerServiceImplementation implements AnswerService {
	@Autowired
	private AnswerRepository answerRepo;

	@Override
	public Answer saveAnswer(Answer answer) {
		if (answer != null)
			return answerRepo.save(answer);
		return null;
	}

	@Override
	public Iterable<Answer> saveAllAnswers(Collection<Answer> allAnswers) {
		if (allAnswers != null)
			return answerRepo.saveAll(allAnswers);
		return null;
	}

	@Override
	public Answer updateAnswer(Answer answer) {
		if (answer != null)
			return answerRepo.save(answer);
		return null;
	}

	@Override
	public Optional<Answer> findAnswerById(long answerId) {
		if (answerId != 0)
			return answerRepo.findById(answerId);
		return null;
	}

	@Override
	public Iterable<Answer> findAllAnswers() {
		return answerRepo.findAll();
	}

	@Override
	public Iterable<Answer> findAllAnswersByUserId(long userId) {
		if (userId != 0)
			return answerRepo.findAllByUserId(userId);
		return null;
	}

	@Override
	public Iterable<Answer> findAllAnswersByQuestionId(long questionId) {
		if (questionId != 0)
			return answerRepo.findAllByQuestionId(questionId);
		return null;
	}

	@Override
	public Long countAllAnswers() {
		return answerRepo.count();
	}

	@Override
	public Long countAllAnswersByUserId(long userId) {
		return answerRepo.countByUserId(userId);
	}

	@Override
	public Long countAllAnswersByQuestionId(long questionId) {
		return answerRepo.countByQuestionId(questionId);
	}

	@Override
	public boolean deleteAnswerById(long answerId) {
		if (answerId != 0) {
			answerRepo.deleteById(answerId);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteAnswer(Answer answer) {
		if (answer != null) {
			answerRepo.delete(answer);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteBulkAnswers(Iterable<Answer> answers) {
		if (answers != null) {
			answerRepo.deleteAll(answers);
			return true;
		}
		return false;
	}
}
