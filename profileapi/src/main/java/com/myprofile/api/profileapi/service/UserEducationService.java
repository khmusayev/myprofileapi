package com.myprofile.api.profileapi.service;

import java.util.List;
import java.util.Optional;

import com.myprofile.api.profileapi.entity.UserEducation;

public interface UserEducationService {

	List<UserEducation> findAll(Long userId);

	void save(UserEducation theEdu);

	void delete(UserEducation userEdu);
	
	Optional<UserEducation>  findById(Long id);
	
}
