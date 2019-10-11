package com.codinghub.collegebuddy.services;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codinghub.collegebuddy.domain.UserSkill;
import com.codinghub.collegebuddy.repositories.UserSkillRepository;

@Service
public class UserSkillServiceImplementation implements UserSkillService {

	@Autowired
	private UserSkillRepository userSkillRepo;

	@Override
	public UserSkill addUserSkill(UserSkill userSkill) {
		if (userSkill != null)
			return userSkillRepo.save(userSkill);
		return null;
	}

	@Override
	public Collection<UserSkill> addUserSkills(Collection<UserSkill> userSkills) {
		if (userSkills.size() != 0)
			return (Collection<UserSkill>) userSkillRepo.saveAll(userSkills);
		return null;
	}

	@Override
	public Collection<UserSkill> findAllSkillsByUserId(Long userId) {
		if (userId != 0) {
			return (Collection<UserSkill>) userSkillRepo.findByUserId(userId);
		}
		return null;
	}

	@Override
	public boolean deleteBulkSkillsBySkillsIds(Long[] userSkillIds) {
		if (userSkillIds != null) {
			userSkillRepo.deleteByIdIn(Arrays.asList(userSkillIds));
			return true;
		}
		return false;
	}

}
