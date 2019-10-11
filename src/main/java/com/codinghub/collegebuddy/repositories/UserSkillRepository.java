package com.codinghub.collegebuddy.repositories;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.codinghub.collegebuddy.domain.UserSkill;

public interface UserSkillRepository extends CrudRepository<UserSkill, Long> {

	Collection<UserSkill> findByUserId(Long userId);

	@Transactional
	void deleteByIdIn(List<Long> ids);
}
