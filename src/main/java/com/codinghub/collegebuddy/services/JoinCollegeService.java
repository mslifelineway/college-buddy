package com.codinghub.collegebuddy.services;

import java.util.Collection;

import com.codinghub.collegebuddy.domain.JoinCollege;

public interface JoinCollegeService {

	public JoinCollege joinCollege(JoinCollege joinCollege);
	
	/**
	 * Finding all the approved users of a particular college
	 * @param collegeId
	 * @return
	 */
	public Collection<JoinCollege> findApprovedUsersByCollegeId(long collegeId); /// status = 2
	
	/**
	 * counting all the approved users who joined a particular college
	 * @param collegeId
	 * @return
	 */
	public Long countAllApprovedUsersByCollegeId(long collegeId);
	
	/**
	 * Finding all the pending users of a particular college
	 * @param collegeId
	 * @return
	 */
	public Collection<JoinCollege> findPendingUsersByCollegeId(long collegeId); /// status = 1
	
	/**
	 * counting all the pending users who joined a particular user
	 * @param collegeId
	 * @return
	 */
	public Long countAllPendingUsersByCollegeId(long collegeId);
	
	/**
	 * Finding all the joined colleges of a particular user
	 * @param userId
	 * @return
	 */
	public Collection<JoinCollege> findByUserId(long userId);
	
	/**
	 * Finding all the joined colleges of a particular college INCLUDING ( APPROVED AND PENDING USERS )
	 * @param collegeId
	 * @return
	 */
	public Collection<JoinCollege> findByCollegeId(long collegeId);
	
	/**
	 * Counting all the users or TOTAL MEMBERS (including approved and pending) who joined a particular college
	 * @param collegeId
	 * @return
	 */
	public Long countAllUsersByCollegeId(long collegeId);
	
}
