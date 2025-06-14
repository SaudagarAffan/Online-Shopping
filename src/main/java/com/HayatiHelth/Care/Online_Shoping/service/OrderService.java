package com.HayatiHelth.Care.Online_Shoping.service;

import com.HayatiHelth.Care.Online_Shoping.beans.OrderRequest;
import com.HayatiHelth.Care.Online_Shoping.beans.OrderResponse;
import com.HayatiHelth.Care.Online_Shoping.model.LoginUser;
import com.HayatiHelth.Care.Online_Shoping.model.Order;
import com.HayatiHelth.Care.Online_Shoping.model.Product;
import com.HayatiHelth.Care.Online_Shoping.repository.LoginUserRepository;
import com.HayatiHelth.Care.Online_Shoping.repository.OrderRepository;
import com.HayatiHelth.Care.Online_Shoping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService 
{	
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductRepository productRepository;

	
	@Autowired
	private LoginUserRepository loginUserRepository;
	
	public OrderResponse placeOrder(Long productId, Integer quantity , String email) 
	{
		Product product = productRepository.findById(productId).orElseThrow(() ->
		new RuntimeException("Product not found with ID: " + productId));
		
		LoginUser loginUser = loginUserRepository.getByUserEmail(email);
		
		if(product.getProductStock()>=quantity)
		{
			Order order = new Order();
			order.setProduct(product);
			order.setProductName(product.getProductName());
			order.setProductAmount((double) (product.getProductPrice() * quantity));
			order.setProductQuantity(quantity);
			order.setLocalDateTime(LocalDateTime.now());
			order.setLoginUser(loginUser);
		
			orderRepository.save(order);
			
			product.setProductStock(product.getProductStock() - quantity);
	        productRepository.save(product);

			Order savedOrder =   orderRepository.save(order);
			productRepository.save(product);
			OrderResponse or = new OrderResponse();
			or.setOrderId(savedOrder.getOrderId());
			or.setProductId(savedOrder.getProduct().getProductID());
			or.setProductName(savedOrder.getProductName());
			or.setProductAmount(savedOrder.getProductAmount());
			or.setProductQuantity(savedOrder.getProductQuantity());
			return or;
		}
		else
		{
			throw new RuntimeException("Product Out of Stock!");
		}
	}

	public Order updateOrder(Integer orderId, OrderRequest orderRequest) 
	{
		Order existingOrder = orderRepository.findById(orderId)
				.orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));

		Product product = productRepository.findById(orderRequest.getProductID())
				.orElseThrow(() -> new RuntimeException("Product not found with ID: " + orderRequest.getProductID()));
		
		existingOrder.setProduct(product);
		existingOrder.setProductName(product.getProductName());
		existingOrder.setProductAmount(product.getProductPrice() * orderRequest.getQuantity());
		existingOrder.setProductQuantity(orderRequest.getQuantity());
		existingOrder.setLocalDateTime(LocalDateTime.now());

		return orderRepository.save(existingOrder);
	}

	public String deleteOrder(Integer orderId)
	{
		Order order = orderRepository.findById(orderId)
				.orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));

		orderRepository.delete(order);
		return "Order with ID " + orderId + " has been deleted successfully.";
	}



	public List<Order> getAllOrders(String email) 
	{
		LoginUser loginUser = loginUserRepository.getByUserEmail(email);
		return orderRepository.findByLoginUser(loginUser);
	}
}
