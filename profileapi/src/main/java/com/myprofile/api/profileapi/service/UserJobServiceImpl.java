package com.myprofile.api.profileapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myprofile.api.profileapi.entity.UserJob;
import com.myprofile.api.profileapi.repo.UserJobRepository;

@Service
public class UserJobServiceImpl implements UserJobService {

	@Autowired
	private UserJobRepository userJobRepository;

	@Override
	public List<UserJob> findAll(Long userId) {
		return userJobRepository.findByUserId(userId);
	}

	@Override
	public void save(UserJob theJob) {
		userJobRepository.save(theJob);
	}

	@Override
	public void delete(UserJob userJob) {
		userJobRepository.delete(userJob);
	}

	@Override
	public Optional<UserJob> findById(Long id) {
		return userJobRepository.findById(id);
	}

}
