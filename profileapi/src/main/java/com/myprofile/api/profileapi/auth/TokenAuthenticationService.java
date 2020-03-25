package com.myprofile.api.profileapi.auth;

import com.google.common.collect.ImmutableMap;
import com.myprofile.api.profileapi.entity.User;
import com.myprofile.api.profileapi.security.TokenService;
import com.myprofile.api.profileapi.service.UserCrudService;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

//@Service
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE, makeFinal = true)
final class TokenAuthenticationService implements UserAuthenticationService {
  @NonNull
  TokenService tokens;
  @NonNull
  UserCrudService users;

  @Override
  public Optional<User> login(final String username, final String password) {
	Optional<User> newUser = users
		      .findByUsername(username)
		      .filter(user -> Objects.equals(password, user.getPassword()));
	if(!newUser.isPresent())
		return Optional.empty();
	Optional<String> token = newUser.map(user -> tokens.expiring(ImmutableMap.of("username", username))); 
	newUser.get().setToken(token.get());
    return newUser;
  }

  @Override
  public Optional<User> findLoggedInUserByToken(final String token) {
    return Optional
      .of(tokens.verify(token))
      .map(map -> map.get("username"))
      .flatMap(users::findByUsername);
  }

  @Override
  public boolean logout(final User user) {
	return false;
  }
}
