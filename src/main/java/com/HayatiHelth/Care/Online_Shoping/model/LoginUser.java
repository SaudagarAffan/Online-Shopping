package com.HayatiHelth.Care.Online_Shoping.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="LoginUser")           // for creating table
public class LoginUser {

	@Id
	private String userid;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	private String emailId;
	private String password;
	public String getEmailId() {
		return emailId;
	}
	public void setEmaiId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
