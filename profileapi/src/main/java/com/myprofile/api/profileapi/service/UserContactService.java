package com.myprofile.api.profileapi.service;

import com.myprofile.api.profileapi.entity.UserContact;

public interface UserContactService {

	UserContact findByUserId(Long userId);

	void save(UserContact theContact);

	void delete(UserContact theContact);
	
}
