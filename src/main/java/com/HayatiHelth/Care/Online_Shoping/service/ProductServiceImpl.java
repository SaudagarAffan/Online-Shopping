package com.HayatiHelth.Care.Online_Shoping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HayatiHelth.Care.Online_Shoping.model.Product;
import com.HayatiHelth.Care.Online_Shoping.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepo;

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Product existing = getProductById(product.getProductID());
        existing.setProductName(product.getProductName());
        existing.setProductDescription(product.getProductDescription());
        existing.setProductPrice(product.getProductPrice());
        existing.setProductStock(product.getProductStock());
        existing.setCategoryType(product.getCategoryType());
        return productRepo.save(existing);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }
}
