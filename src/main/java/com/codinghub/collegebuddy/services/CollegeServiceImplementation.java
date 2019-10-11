package com.codinghub.collegebuddy.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codinghub.collegebuddy.domain.College;
import com.codinghub.collegebuddy.repositories.CollegeRepository;

@Service
public class CollegeServiceImplementation implements CollegeService {

	@Autowired
	private CollegeRepository collegeRepo;

	@Override
	public College saveCollege(College college) {
		if (college != null)
			return collegeRepo.save(college);
		return null;
	}

	@Override
	public College updateCollege(College college) {
		if (college != null)
			return collegeRepo.save(college);
		return null;
	}

	@Override
	public boolean deleteCollegeById(Long collegeId) {
		if (collegeId != 0) {
			collegeRepo.deleteById(collegeId);
			return true;
		}
		return false;
	}

	@Override
	public long countAllColleges() {
		return collegeRepo.count();
	}

	@Override
	public long countAllCollegesByUserId(long userId) {
		return collegeRepo.countAllByUserId(userId);
	}

	@Override
	public Iterable<College> findAllColleges() {
		return collegeRepo.findAll();
	}

	@Override
	public Optional<College> findCollegeById(long collegeId) {
		if(collegeId != 0)
			return collegeRepo.findById(collegeId);
		return null;
	}

	@Override
	public Collection<College> findAllCollegesByUserId(long userId) {
		if(userId != 0)
			return collegeRepo.findAllByUserId(userId);
		return null;
	}

}
