package com.HayatiHelth.Care.Online_Shoping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HayatiHelth.Care.Online_Shoping.beans.OrderRequest;
import com.HayatiHelth.Care.Online_Shoping.beans.OrderResponse;
import com.HayatiHelth.Care.Online_Shoping.model.Order;
import com.HayatiHelth.Care.Online_Shoping.service.OrderService;


@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/place")
	public OrderResponse placeOrder(@RequestBody OrderRequest orderRequest,
			@RequestHeader("emailId") String email) {
		return orderService.placeOrder(orderRequest, email); 
	}

	@GetMapping("/all")
	public List<Order> getAllOrders(@RequestHeader("emailId") String email ) {
		return orderService.getAllOrders(email);
	}

	@PutMapping("/update/{orderId}")
	public Order updateOrder(@PathVariable Integer orderId, @RequestBody OrderRequest orderRequest) {
		return orderService.updateOrder(orderId, orderRequest);
	}

	@DeleteMapping("/delete/{orderId}")
	public String deleteOrder(@PathVariable Integer orderId) {
		return orderService.deleteOrder(orderId);
	}
}
