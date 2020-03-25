package com.myprofile.api.profileapi.repo;

import org.springframework.data.repository.CrudRepository;

import com.myprofile.api.profileapi.entity.UserContact;

public interface UserContactRepository extends CrudRepository<UserContact, Long> {
	UserContact findByUserId(long userId);
}
