package com.HayatiHelth.Care.Online_Shoping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.HayatiHelth.Care.Online_Shoping.model.LoginUser;

@Repository
public interface LoginUserRepo extends JpaRepository<LoginUser, String>
{
	@Query(value = "SELECT * FROM userdetails WHERE user_email = ?1", nativeQuery = true)
	LoginUser getByUserEmail(String email);
	LoginUser getByUserId(String userId);
}


	


