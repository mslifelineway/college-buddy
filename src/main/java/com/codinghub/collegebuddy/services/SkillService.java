package com.codinghub.collegebuddy.services;

import java.util.Collection;

import com.codinghub.collegebuddy.domain.Skill;

public interface SkillService {

	public Collection<Skill> searchSkills(String skillKey);

	/**
	 * Adding more skills to the skills list
	 * @param skills
	 * @return
	 */
	public Collection<Skill> addSkills(Collection<Skill> skills);
	
}
