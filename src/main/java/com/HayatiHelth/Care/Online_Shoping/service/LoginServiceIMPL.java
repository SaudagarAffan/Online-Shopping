package com.HayatiHelth.Care.Online_Shoping.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HayatiHelth.Care.Online_Shoping.model.LoginUser;
import com.HayatiHelth.Care.Online_Shoping.repo.LoginUserRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoginServiceIMPL {

	private static final Logger Logger = LoggerFactory.getLogger(LoginServiceIMPL.class);

	@Autowired
	LoginUserRepo login;

	public boolean login(LoginUser loginUser) {

		Logger.info("LoginServiceIMPL >> login");
		LoginUser loginu  =	login.getUser(loginUser.getEmailId(), loginUser.getPassword());
		if (loginu == null)
		{
			return false;
		}else{
			return true;
		}
	}








	
	
	

}
