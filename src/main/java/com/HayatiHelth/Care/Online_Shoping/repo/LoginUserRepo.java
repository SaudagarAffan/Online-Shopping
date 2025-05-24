package com.HayatiHelth.Care.Online_Shoping.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.HayatiHelth.Care.Online_Shoping.model.LoginUser;

public interface LoginUserRepo extends JpaRepository<LoginUser, String>{
	@Query(value = "select * from login_user where email_id = ?1 and password = ?2",
			nativeQuery =true)
	LoginUser getUser(String emailId , String password);

}
