package com.HayatiHelth.Care.Online_Shoping.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.HayatiHelth.Care.Online_Shoping.model.LoginUser;
import com.HayatiHelth.Care.Online_Shoping.model.RegistrationUser;
import com.HayatiHelth.Care.Online_Shoping.service.LoginServiceIMPL;

@RestController
public class LoginController 
{
	@Autowired
	private LoginServiceIMPL loginServiceIMPL;

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginUser loginUser) 
	{
		boolean isValid = loginServiceIMPL.login(loginUser);
		if (isValid) 
		{
			return ResponseEntity.ok("Logged in Successful"); // HTTP 200
		} 
		else 
		{
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid EmailID or Password"); // HTTP 401
		}
	}

	@PostMapping("/registration")
	public ResponseEntity<?> register(@RequestBody RegistrationUser registrationUser) 
	{
		// Check if email exists
		boolean emailExists = loginServiceIMPL.existsByEmail(registrationUser.getEmail_Id());
		if (emailExists) 
		{
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body(Collections.singletonMap("message", "EmailID is already registered"));
		}

		// Check if user ID exists
		boolean userIdExists = loginServiceIMPL.existsByUserId(registrationUser.getUserid());
		if (userIdExists)
		{
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body(Collections.singletonMap("message", "UserID is already registered"));
		}
		// Proceed with saving the user
		LoginUser user = new LoginUser();
		user.setUserEmail(registrationUser.getEmail_Id());
		user.setUserId(registrationUser.getUserid());
		user.setUserName(registrationUser.getName());
		user.setUserAddress(registrationUser.getAddress());
		user.setAuthToken("ABC");
		user.setLastLoggedin("da");
		user.setUserPassword(registrationUser.getPassword());
		user.setPhoneNumber(registrationUser.getMobil_no().longValue());

		loginServiceIMPL.saveUser(user);

		return ResponseEntity.ok(Collections.singletonMap("message", "Registration Successful"));
	}
}
