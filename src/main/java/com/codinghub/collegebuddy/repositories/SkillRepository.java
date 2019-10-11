package com.codinghub.collegebuddy.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.codinghub.collegebuddy.domain.Skill;

public interface SkillRepository extends CrudRepository<Skill, Long>{

	@Query("select s from Skill s where s.name like %:skill% order by s.type")
	Collection<Skill> searchSkills(@Param("skill") String skillKey);
}
