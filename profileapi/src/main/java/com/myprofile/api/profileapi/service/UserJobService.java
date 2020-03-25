package com.myprofile.api.profileapi.service;

import java.util.List;
import java.util.Optional;

import com.myprofile.api.profileapi.entity.UserJob;

public interface UserJobService {

	List<UserJob> findAll(Long userId);

	void save(UserJob theJob);

	void delete(UserJob userJob);

	 Optional<UserJob>  findById(Long id);
	
}
