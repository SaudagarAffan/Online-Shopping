package com.HayatiHelth.Care.Online_Shoping.beans;

public class OrderRequest
{
	private Long productID;
	private  Double  amount;
	private  Integer quantity;
	private String address;
	private String city;
	private String pincode;
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

	private String mobile;


	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}
}
