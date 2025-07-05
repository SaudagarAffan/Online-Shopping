package com.HayatiHelth.Care.Online_Shoping.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HayatiHelth.Care.Online_Shoping.model.Product;
import com.HayatiHelth.Care.Online_Shoping.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping           
	public ResponseEntity<List<Product>> getAllProducts() 
	{
		return ResponseEntity.ok(productService.getAllProducts());
	}

	@GetMapping("/{productID}")          
	public ResponseEntity<Product> getProductById(@PathVariable Long productID) 
	{
		return ResponseEntity.ok(productService.getProductById(productID));
	}

	@PostMapping        
	public ResponseEntity<Product> addProduct(@RequestBody Product product) 
	{
		Product savedProduct = productService.addProduct(product);
		return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	}

	@PatchMapping              
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) 
	{
		Product updatedProduct = productService.updateProduct(product);
		return ResponseEntity.ok(updatedProduct);
	}

	@DeleteMapping("/{productID}")         
	public ResponseEntity<Void> deleteProduct(@PathVariable Long productID) 
	{
		productService.deleteProduct(productID);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
