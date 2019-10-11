package com.codinghub.collegebuddy.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codinghub.collegebuddy.domain.OtherAccount;

public interface OtherAccountRepository extends CrudRepository<OtherAccount, Long> {

	OtherAccount findByUserId(Long userId);

}
