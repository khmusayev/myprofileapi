package com.myprofile.api.profileapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myprofile.api.profileapi.entity.UserEducation;
import com.myprofile.api.profileapi.repo.UserEducationRepository;

@Service
public class UserEducationServiceImpl implements UserEducationService {

	@Autowired
	private UserEducationRepository userEducationRepository;

	@Override
	public List<UserEducation> findAll(Long userId) {
		return userEducationRepository.findByUserId(userId);
	}

	@Override
	public void save(UserEducation theEducation) {
		userEducationRepository.save(theEducation);
	}

	@Override
	public void delete(UserEducation theEducation) {
		userEducationRepository.delete(theEducation);
	}

	@Override
	public Optional<UserEducation> findById(Long id) {
		return userEducationRepository.findById(id);
	}

}
