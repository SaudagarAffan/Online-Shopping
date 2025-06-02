package com.HayatiHelth.Care.Online_Shoping.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.HayatiHelth.Care.Online_Shoping.model.LoginUser;
import com.HayatiHelth.Care.Online_Shoping.model.RegistrationUser;
import com.HayatiHelth.Care.Online_Shoping.response.LoginRequest;
import com.HayatiHelth.Care.Online_Shoping.response.LoginResponse;
import com.HayatiHelth.Care.Online_Shoping.service.LoginServiceIMPL;
import com.HayatiHelth.Care.Online_Shoping.service.TokenService;

@RestController
public class LoginController 
{
	@Autowired
	private LoginServiceIMPL loginServiceIMPL;

	@Autowired
	private TokenService tokenService;

	@GetMapping("/user-info")
	public ResponseEntity<?> getUserInfo(@RequestHeader("Authorization") String token,
			@RequestHeader("emailId") String email) 
	{
		if (token == null || email == null) 
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(Collections.singletonMap("error", "Missing token or email header"));
		}
		LoginUser user = loginServiceIMPL.getUserByEmail(email);
		if (user == null) 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(Collections.singletonMap("error", "User not found"));
		}
		return ResponseEntity.ok(Collections.singletonMap("name", user.getUserName()));
	}

	@GetMapping("/some-protected-endpoint")
	public ResponseEntity<String> protectedEndpoint(@RequestHeader("Authorization") String token,
			@RequestHeader("emailId") String email) 
	{
		LoginUser user = loginServiceIMPL.getUserByEmail(email);
		if (user != null && tokenService.isValidToken(token)) 
		{
			return ResponseEntity.ok("Token Validated. Access granted.");
		} 
		else
		{
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Token or Email.");
		}
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) 
	{
		System.out.println("Login attempt for email: " + request.getEmail());

		LoginUser user = loginServiceIMPL.getUserByEmail(request.getEmail());
		if (user != null) 
		{
			System.out.println("User found: " + user.getUserEmail());
			if (user.getUserPassword().equals(request.getPassword()))
			{
				String token = tokenService.generateToken(user.getUserId());
				System.out.println("Login successful, token generated.");
				user.setAuthToken(token);
				loginServiceIMPL.saveUser(user);
				return ResponseEntity.ok(new LoginResponse("successful", token));
			}
			else
			{
				System.out.println("Password mismatch.");
			}
		} 
		else
		{
			System.out.println("User not found with email: " + request.getEmail());
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
				.body(new LoginResponse("failed", null));
	}

	@PostMapping("/registration")
	public ResponseEntity<?> register(@RequestBody RegistrationUser registrationUser) 
	{
		boolean emailExists = loginServiceIMPL.existsByEmail(registrationUser.getEmail_Id());
		if (emailExists) 
		{
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body(Collections.singletonMap("message", "EmailID is already registered"));
		}

		boolean userIdExists = loginServiceIMPL.existsByUserId(registrationUser.getUserid());
		if (userIdExists)
		{
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body(Collections.singletonMap("message", "UserID is already registered"));
		}

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
