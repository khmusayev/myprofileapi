package com.myprofile.api.profileapi.service;

import java.util.Optional;

import com.myprofile.api.profileapi.entity.User;


/**
 * User security operations like login and logout, and CRUD operations on
 * {@link User}.
 * 
 * @author jerome
 *
 */
public interface UserCrudService {

	Optional<User> findLoggedInUser(String id);

	Optional<User> findByUsername(String username);

	User register(User user);
	
	void deleteUser(User user);

	User exists(String username, String password);

	User findCurrentUser(String token);

	boolean logout(String token);

	void addToLoggedInUsers(String uuid, User user);

	void removeFromLoggedInList(String username);

}
