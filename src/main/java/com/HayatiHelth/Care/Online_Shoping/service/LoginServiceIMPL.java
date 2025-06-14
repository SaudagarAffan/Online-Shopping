package com.HayatiHelth.Care.Online_Shoping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HayatiHelth.Care.Online_Shoping.model.LoginUser;
import com.HayatiHelth.Care.Online_Shoping.beans.RegistrationUser;
import com.HayatiHelth.Care.Online_Shoping.repository.LoginUserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoginServiceIMPL 
{
	@Autowired
	private LoginUserRepository loginUserRepo;

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
	public void saveRegistrationUser(RegistrationUser registrationUser)
	{
		LoginUser user = new LoginUser();
		user.setUserEmail(registrationUser.getEmail_Id());
	//	user.setUserId(registrationUser.getUserid());
		user.setUserName(registrationUser.getName());
		user.setUserAddress(registrationUser.getAddress());
		user.setAuthToken("ABC");
		user.setLastLoggedin("da");
		user.setUserPassword(registrationUser.getPassword());
		user.setPhoneNumber(registrationUser.getMobil_no().longValue());
		loginUserRepo.save(user);
	}
	
	public void saveUser(LoginUser user) {
		loginUserRepo.save(user);
	}

	public boolean existsByEmail(String email) 
	{
		return loginUserRepo.getByUserEmail(email) != null;
	}
}