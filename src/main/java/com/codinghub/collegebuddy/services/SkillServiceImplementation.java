package com.codinghub.collegebuddy.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codinghub.collegebuddy.domain.Skill;
import com.codinghub.collegebuddy.repositories.SkillRepository;

@Service
public class SkillServiceImplementation implements SkillService{

	@Autowired
	private SkillRepository skillRepo;
	
	@Override
	public Collection<Skill> searchSkills(String skillKey) {
		if(skillKey != null)
		{
			return skillRepo.searchSkills(skillKey);
		}
		return null;
	}

	@Override
	public Collection<Skill> addSkills(Collection<Skill> skills) {
		if(skills.size() != 0) {
			return (Collection<Skill>) skillRepo.saveAll(skills);
		}
		return null;
	}
	
	

}
