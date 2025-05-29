package com.HayatiHelth.Care.Online_Shoping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HayatiHelth.Care.Online_Shoping.model.LoginUser;
import com.HayatiHelth.Care.Online_Shoping.repository.LoginUserRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoginServiceIMPL 
{
	@Autowired
	private LoginUserRepo loginUserRepo;

	public boolean login(LoginUser loginUser) 
	{
		log.info("LoginServiceIMPL >> login");

		LoginUser storedUser = loginUserRepo.getByUserEmail(loginUser.getUserEmail());

		if (storedUser != null && (loginUser.getUserPassword().equals(storedUser.getUserPassword()) )) 
		{
			return true;
		}
		return false;
	}
	public LoginUser getUserByEmail(String email) 
	{
		return loginUserRepo.getByUserEmail(email);

	}
	public void saveUser(LoginUser user) 
	{
		loginUserRepo.save(user);
	}
	
	
	public boolean existsByEmail(String email) {
	    return loginUserRepo.getByUserEmail(email) != null;
	}

	public boolean existsByUserId(String userId) {
	    return loginUserRepo.findById(userId).isPresent();
	}

}