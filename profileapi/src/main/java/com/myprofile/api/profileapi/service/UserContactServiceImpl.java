package com.myprofile.api.profileapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myprofile.api.profileapi.entity.UserContact;
import com.myprofile.api.profileapi.repo.UserContactRepository;

@Service
public class UserContactServiceImpl implements UserContactService {

	@Autowired
	private UserContactRepository userContactRepository;

	@Override
	public UserContact findByUserId(Long userId) {
		return userContactRepository.findByUserId(userId);
	}

	@Override
	public void save(UserContact theContact) {
		userContactRepository.save(theContact);
	}

	@Override
	public void delete(UserContact theContact) {
		userContactRepository.delete(theContact);
	}

}
