package com.HayatiHelth.Care.Online_Shoping.service;

import com.HayatiHelth.Care.Online_Shoping.model.Product;
import java.util.List;

public interface ProductService 
{
	List<Product> getAllProducts();
	Product getProductById(Long id);
	Product addProduct(Product product);
	Product updateProduct(Product product);
	void deleteProduct(Long id);
}
