package com.myprofile.api.profileapi.exceptions;

import com.myprofile.api.profileapi.entity.User;

public class WrongPasswordException extends RuntimeException {

	private static final long serialVersionUID = 3152562797081198996L;
	private static String message = "Wrong password for the username - ";

	public WrongPasswordException(User user) {
		super(message + user.getUsername());
	}

}
