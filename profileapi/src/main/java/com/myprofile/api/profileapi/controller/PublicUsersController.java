package com.myprofile.api.profileapi.controller;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myprofile.api.profileapi.auth.UserAuthenticationService;
import com.myprofile.api.profileapi.entity.User;
import com.myprofile.api.profileapi.service.UserCrudService;

import java.util.UUID;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/public/users")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE)
@CrossOrigin(origins = "http://localhost:4444")
final class PublicUsersController {
  @NonNull
  UserAuthenticationService authentication;
  @NonNull
  UserCrudService users;

  @CrossOrigin(origins = "http://localhost:4444")
  @PostMapping("/register")
  User register(
    @RequestParam("username") final String username,
    @RequestParam("password") final String password,
    @RequestParam("firstName") final String firstName,
    @RequestParam("lastName") final String lastName) {
	  User newUser = new User(new Long(0), username, password, firstName, lastName, null);
    users.register(newUser);
    return login(username, password);
  }

  @CrossOrigin(origins = "http://localhost:4444")
  @PostMapping("/login")
  User login(
    @RequestParam("username") final String username,
    @RequestParam("password") final String password) {
    return authentication
      .login(username, password)
      .orElseThrow(() -> new RuntimeException("invalid login and/or password"));
  }
}
