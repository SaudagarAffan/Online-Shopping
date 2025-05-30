package com.HayatiHelth.Care.Online_Shoping.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="userdetails")           
public class LoginUser 
{
	@Id
	@Column(name = "UserID" , nullable = false , unique = true) 	
	private String userId;
	
	@Column(name = "UserName" , nullable = false) 	
	private String userName;
	
	@Column(name = "UserEmail" , nullable = false , unique = true) 	
	private String userEmail;
	
	@Column(name = "UserPassword" , nullable = false) 	
	private String userPassword;
	
	@Column(name = "UserAddress" , nullable = false) 	
	private String userAddress;
	
	@Column(name = "PhoneNumber", nullable = false)
	private Long phoneNumber;

	@Column(name = "AuthToken", nullable = false)
	private String authToken;
	
	@Column(name = "LastLoggedin" , nullable = false) 	
	private String lastLoggedin;

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public void setLastLoggedin(String lastLoggedin) {
		this.lastLoggedin = lastLoggedin;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public String getAuthToken() {
		return authToken;
	}

	public String getLastLoggedin() {
		return lastLoggedin;
	}

	public String getUserId() {
		return userId;
	}
}
