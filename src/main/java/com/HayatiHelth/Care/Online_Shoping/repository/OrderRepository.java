package com.HayatiHelth.Care.Online_Shoping.repository;

import com.HayatiHelth.Care.Online_Shoping.model.LoginUser;
import com.HayatiHelth.Care.Online_Shoping.model.Order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository  extends JpaRepository<Order , Integer>
{
	List<Order> findByLoginUser(LoginUser loginUser);
}
