package com.myprofile.api.profileapi.service;

import org.springframework.data.repository.CrudRepository;

import com.myprofile.api.profileapi.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
	long deleteByUsername(String username);
}
