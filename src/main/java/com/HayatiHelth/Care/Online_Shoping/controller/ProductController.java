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

    // 1. Get all products
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    // 2. Get product by ID
    @GetMapping("/{productID}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productID) {
        return ResponseEntity.ok(productService.getProductById(productID));
    }

    // 3. Add new product (admin only)
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product savedProduct = productService.addProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    // 4. Update product (admin only)
    @PatchMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(product);
        return ResponseEntity.ok(updatedProduct);
    }

    // 5. Delete product by ID
    @DeleteMapping("/{productID}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productID) {
        productService.deleteProduct(productID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
