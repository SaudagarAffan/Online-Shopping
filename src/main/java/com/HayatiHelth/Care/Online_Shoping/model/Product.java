package com.HayatiHelth.Care.Online_Shoping.model;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productID;

    private String productName;
    private String productDescription;
    private Double productPrice;
    private Integer productStock;
    private String categoryType;
	public Long getProductID() {
		return productID;
	}
	public String getProductName() {
		return productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public Integer getProductStock() {
		return productStock;
	}
	public String getCategoryType() {
		return categoryType;
	}
	public void setProductID(Long productID) {
		this.productID = productID;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public void setProductStock(Integer productStock) {
		this.productStock = productStock;
	}
	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}
}
