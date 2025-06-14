package com.HayatiHelth.Care.Online_Shoping.beans;

public class LoginResponse 
{
	private String status;
	private String token;

	public LoginResponse(String status , String token) 
	{
		this.status = status;
		this.token  = token;
	}

	public String getStatus() 
	{
		return status;
	}

	public String getToken() 
	{
		return token;
	}

	public void setStatus(String status) 
	{
		this.status = status;
	}

	public void setToken(String token) 
	{
		this.token = token;
	}
}
