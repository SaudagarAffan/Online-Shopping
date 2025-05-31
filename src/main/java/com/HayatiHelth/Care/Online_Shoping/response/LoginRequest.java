package com.HayatiHelth.Care.Online_Shoping.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginRequest {
	
//	@JsonProperty("userEmail")
	private String email;
	
//	@JsonProperty("userPassword")
	private String password;

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
}