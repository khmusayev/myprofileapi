package com.myprofile.api.profileapi.exceptions;

import com.myprofile.api.profileapi.entity.User;

public class UserExistsException extends RuntimeException {

	private static final long serialVersionUID = -3222078211878542993L;
	private static String message = "Username already exists ";

	public UserExistsException(User user) {
		super(message + user.getUsername());
	}

}
