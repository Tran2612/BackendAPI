package com.project.backendapi.service;

import com.project.backendapi.model.Products;
import com.project.backendapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }
    public Optional<Products> getProductById(long id) {
        return  productRepository.findById(id);
    }
    public Products addProduct(Products product) {
        return productRepository.save(product);
    }
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }
}
