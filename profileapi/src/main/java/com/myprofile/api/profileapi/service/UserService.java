package com.myprofile.api.profileapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myprofile.api.profileapi.entity.User;
import com.myprofile.api.profileapi.exceptions.NoSuchUsernameInDBException;
import com.myprofile.api.profileapi.exceptions.UserExistsException;
import com.myprofile.api.profileapi.exceptions.WrongPasswordException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
public class UserService implements UserCrudService {

	public static Map<String, User> loggedInUsers = new HashMap<>();

	@Autowired
	private UserRepository userRepository;

	@Override
	public void addToLoggedInUsers(final String token, final User user) {
		loggedInUsers.put(token, user);
	}

	@Override
	public Optional<User> findLoggedInUser(final String id) {
		return ofNullable(loggedInUsers.get(id));
	}

	@Override
	public Optional<User> findByUsername(final String username) {
		return loggedInUsers.values().stream().filter(u -> Objects.equals(username, u.getUsername())).findFirst();
	}

	@Override
	public User register(User user) {
		User userInDB = userRepository.findByUsername(user.getUsername());
		if(userInDB != null)
			throw new UserExistsException(user);
		user.setId(new Long(0));
		return userRepository.save(user);
	}

	@Override
	public User exists(String username, String password) {
		User user = new User((long) 0, username, password, "", "", null);
		User userInDB = userRepository.findByUsername(username);
		if(userInDB == null)
			throw new NoSuchUsernameInDBException(user);
		if(!userInDB.getPassword().equals(password))
			throw new WrongPasswordException(user);
		return userInDB;
	}

	@Override
	public User findCurrentUser(String token) {
		return null;
	}

	@Override
	public boolean logout(String token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeFromLoggedInList(String username) {
		loggedInUsers.entrySet().removeIf(entry -> entry.getValue().getUsername().equals(username));
	}

	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public void deleteUser(User user) {
		User userInDB = userRepository.findByUsername(user.getUsername());
		if(userInDB == null)
			throw new NoSuchUsernameInDBException(user);
		if(!userInDB.getPassword().equals(user.getPassword()))
			throw new WrongPasswordException(user);
		userRepository.delete(userInDB);
	}
	
}
