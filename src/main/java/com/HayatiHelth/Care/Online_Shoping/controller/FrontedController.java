package com.HayatiHelth.Care.Online_Shoping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class FrontedController 
{
	@GetMapping("/loginPage")
	public String getLoginPage( String loginPage) 
	{
		return "loginPage";
	}
	
	@GetMapping("/registrationPage")
	public String getRegistrationPage( String registrationPage) 
	{
		return "registrationPage";
	}
	
	@GetMapping("/dashboard")
	public String getdashboardPage( String dashboard) 
	{
		return "dashboard";
	}
	
	@GetMapping("/product")
	public String getproductPage( String product) 
	{
		return "product";
	}
}
