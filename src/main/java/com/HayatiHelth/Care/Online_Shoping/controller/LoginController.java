package com.HayatiHelth.Care.Online_Shoping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.HayatiHelth.Care.Online_Shoping.model.LoginUser;
import com.HayatiHelth.Care.Online_Shoping.model.RegistrationUser;
import com.HayatiHelth.Care.Online_Shoping.service.LoginServiceIMPL;


@RestController
public class LoginController  {

	@Autowired
	private LoginServiceIMPL loginServiceIMPL;


	@PostMapping("/login")       //endpoint
	public String postMethodName(@RequestBody LoginUser entity) {

		boolean boo = loginServiceIMPL.login(entity);
		if (boo) {
			return "sucess";
		}else {
			return "login failed";
		}
		//TODO: process POST request;
	}

	@PostMapping("/registration")
	public String postMethodName(@RequestBody RegistrationUser entity) {
		//TODO: process POST request


		System.out.println(entity.toString());
		return "sucess";

	}

}
