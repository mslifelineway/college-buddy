package com.codinghub.collegebuddy.services;

import com.codinghub.collegebuddy.domain.OtherAccount;

public interface OtherAccountService {

	public OtherAccount saveOtherAccount(OtherAccount otherAccount);

	public OtherAccount updateOtherAccount(OtherAccount otherAccount);

	public OtherAccount findOtherAccountsByUserId(Long userId);
}
