package com.myprofile.api.profileapi;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.myprofile.api.profileapi.auth.UserAuthenticationService;
import com.myprofile.api.profileapi.entity.User;
import com.myprofile.api.profileapi.exceptions.NoSuchUsernameInDBException;
import com.myprofile.api.profileapi.exceptions.UserExistsException;
import com.myprofile.api.profileapi.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyApiApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RepoTest {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserAuthenticationService userAuthenticationService;
	
	  @Test
	  public void testA_registerNewUser() {
		User user = new User((long) 0, "mukh", "password", "Khayal", "Musayev", null);
		User registeredUser = userService.register(user);
		assertEquals(user, registeredUser);
	  }
	  
	  @Test(expected=UserExistsException.class)
	  public void testB_registerExistingUser() {
		User user = new User((long) 0, "mukh", "password", "Khayal", "Musayev", null);
		User registeredUser = userService.register(user);
	  }

	  @Test
	  public void testC_deleteExistingUser() {
		User user = new User((long) 0, "mukh", "password", "Khayal", "Musayev", null);
		userService.deleteUser(user);
	  }
	  
	  @Test(expected=NoSuchUsernameInDBException.class)
	  public void testD_searchForDeletedUser() {
		User user = new User((long) 0, "mukh", "password", "Khayal", "Musayev", null);
		userService.exists(user.getUsername(), user.getPassword());
	  }
	  
}
