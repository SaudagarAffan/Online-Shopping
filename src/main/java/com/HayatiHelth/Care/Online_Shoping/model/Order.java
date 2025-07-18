package com.HayatiHelth.Care.Online_Shoping.model;


import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name="orders")
public class Order
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OrderID" , nullable = false , unique = true)
	private Integer orderId;

	@Column(name = "ProductName" , nullable = false)
	private String productName;

	@Column(name = "ProductAmount" , nullable = false)
	private Double productAmount;

	@Column(name = "ProductQuantity" , nullable = false)
	private Integer productQuantity;

	@ManyToOne
	@JoinColumn(name = "productID", referencedColumnName = "productID", nullable = false)
	private Product product;

	@ManyToOne
	@JoinColumn(name = "UserID", referencedColumnName = "UserID", nullable = false)
	private LoginUser loginUser;


	@Column(name = "OrderDate" , nullable = false)
	private LocalDateTime localDateTime;

	@Column(name = "Address", nullable = false)
	private String address;

	@Column(name = "City", nullable = false)
	private String city;

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getPincode() {
		return pincode;
	}

	public String getMobile() {
		return mobile;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "Pincode", nullable = false)
	private String pincode;

	@Column(name = "Mobile", nullable = false)
	private String mobile;

	public String getProductName() {
		return productName;
	}

	public LoginUser getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(LoginUser loginUser) {
		this.loginUser = loginUser;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(Double productAmount) {
		this.productAmount = productAmount;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
}
