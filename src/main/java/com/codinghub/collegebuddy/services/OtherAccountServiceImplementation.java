package com.codinghub.collegebuddy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codinghub.collegebuddy.domain.OtherAccount;
import com.codinghub.collegebuddy.repositories.OtherAccountRepository;

@Service
public class OtherAccountServiceImplementation implements OtherAccountService {

	@Autowired
	private OtherAccountRepository otherAccountRepo;

	@Override
	public OtherAccount saveOtherAccount(OtherAccount oa) {
		if (oa != null)
		{
			if(oa.getFacebookUrl().equals(""))
				oa.setFacebookUrl(null);
			if(oa.getGoogleUrl().equals(""))
				oa.setGoogleUrl(null);
			if(oa.getTwitterUrl().equals(""))
				oa.setTwitterUrl(null);
			if(oa.getLinkedinUrl().equals(""))
				oa.setLinkedinUrl(null);
			if(oa.getQuoraUrl().equals(""))
				oa.setQuoraUrl(null);
			if(oa.getYoutubeUrl().equals(""))
				oa.setYoutubeUrl(null);
			
			return otherAccountRepo.save(oa);
			
		}
		return null;
	}

	@Override
	public OtherAccount updateOtherAccount(OtherAccount otherAccount) {
		if (otherAccount != null)
			if (otherAccount.getId() != 0)
				return otherAccountRepo.save(otherAccount);
		return null;
	}

	@Override
	public OtherAccount findOtherAccountsByUserId(Long userId) {
		if (userId != 0)
			return otherAccountRepo.findByUserId(userId);
		return null;
	}

}
