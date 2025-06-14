package com.HayatiHelth.Care.Online_Shoping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.HayatiHelth.Care.Online_Shoping.model.LoginUser;

@Repository
public interface LoginUserRepository extends JpaRepository<LoginUser, Integer>
{
	LoginUser getByUserEmail(String email);
	LoginUser getByUserId(Integer userId);
}





