package com.codinghub.collegebuddy.services;

import java.util.Collection;

import com.codinghub.collegebuddy.domain.UserSkill;

public interface UserSkillService {

	public UserSkill addUserSkill(UserSkill userSkill);
	
	public Collection<UserSkill> addUserSkills(Collection<UserSkill> userSkills);

	public Collection<UserSkill> findAllSkillsByUserId(Long userId);

	public boolean deleteBulkSkillsBySkillsIds(Long[] userSkillIds);
	
}
