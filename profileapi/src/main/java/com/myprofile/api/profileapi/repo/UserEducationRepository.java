package com.myprofile.api.profileapi.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.myprofile.api.profileapi.entity.UserEducation;

public interface UserEducationRepository extends CrudRepository<UserEducation, Long> {
	List<UserEducation> findByUserId(long userId);
}
