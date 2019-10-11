package com.codinghub.collegebuddy.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codinghub.collegebuddy.domain.JoinCollege;
import com.codinghub.collegebuddy.repositories.JoinCollegeRepository;
import com.codinghub.collegebuddy.utils.ConstantRequired;

@Service
public class JoinCollegeServiceImplementation implements JoinCollegeService{
	
	@Autowired
	private JoinCollegeRepository joinCollegeRepo;
	
	@Override
	public JoinCollege joinCollege(JoinCollege joinCollege) {
		if(joinCollege != null)
			return joinCollegeRepo.save(joinCollege);
		return null;
	}

	@Override
	public Collection<JoinCollege> findApprovedUsersByCollegeId(long collegeId) {
		if(collegeId != 0)
			return joinCollegeRepo.findByCollegeIdAndStatus(collegeId, ConstantRequired.JOIN_COLLEGE_STATUS_APPROVED);
		return null;
	}

	@Override
	public Long countAllApprovedUsersByCollegeId(long collegeId) {
		return joinCollegeRepo.countByCollegeIdAndStatus(collegeId, ConstantRequired.JOIN_COLLEGE_STATUS_APPROVED);
	}

	@Override
	public Collection<JoinCollege> findPendingUsersByCollegeId(long collegeId) {
		if(collegeId != 0)
			return joinCollegeRepo.findByCollegeIdAndStatus(collegeId, ConstantRequired.JOIN_COLLEGE_STATUS_PENDING);
		return null;
	}

	@Override
	public Long countAllPendingUsersByCollegeId(long collegeId) {
		return joinCollegeRepo.countByCollegeIdAndStatus(collegeId, ConstantRequired.JOIN_COLLEGE_STATUS_PENDING);
	}

	@Override
	public Collection<JoinCollege> findByUserId(long userId) {
		if(userId != 0)
			return joinCollegeRepo.findByUserId(userId);
		return null;
	}

	@Override
	public Collection<JoinCollege> findByCollegeId(long collegeId) {
		if(collegeId != 0)
			return joinCollegeRepo.findByCollegeId(collegeId);
		return null;
	}

	@Override
	public Long countAllUsersByCollegeId(long collegeId) {
		if(collegeId != 0)
			return joinCollegeRepo.countByCollegeId(collegeId);
		return null;
	}

}
