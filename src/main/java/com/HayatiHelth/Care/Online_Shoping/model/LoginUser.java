package com.HayatiHelth.Care.Online_Shoping.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="userdetails")           
public class LoginUser 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UserID" , nullable = false , unique = true) 	
	private Integer userId;
	
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
	private LocalDateTime localDateTime;
	
	@Column(name = "UserType" , nullable =  false)
	private String userType;


	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}


	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}


	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}


	public void setUserName(String userName) {
		this.userName = userName;
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

	

	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	

}
