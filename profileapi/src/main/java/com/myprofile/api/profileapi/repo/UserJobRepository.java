package com.myprofile.api.profileapi.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.myprofile.api.profileapi.entity.UserJob;

public interface UserJobRepository extends CrudRepository<UserJob, Long> {
	List<UserJob> findByUserId(long userId);
}
