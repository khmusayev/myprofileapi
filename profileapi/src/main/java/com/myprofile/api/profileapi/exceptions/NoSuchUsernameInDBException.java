package com.myprofile.api.profileapi.exceptions;

import com.myprofile.api.profileapi.entity.User;

public class NoSuchUsernameInDBException extends RuntimeException {

	private static final long serialVersionUID = 6380455752420674098L;
	private static String message = "No such username - ";

	public NoSuchUsernameInDBException(User user) {
		super(message + user.getUsername());
	}

}
