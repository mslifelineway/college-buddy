package com.codinghub.collegebuddy.commands;

import java.util.Arrays;

public class AddUserSkillsCommand {

	private String[] skills;

	public String[] getSkills() {
		return skills;
	}

	public void setSkills(String[] skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "AddUserSkillsCommand [skills=" + Arrays.toString(skills) + "]";
	}

}
