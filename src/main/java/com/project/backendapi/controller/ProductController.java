package com.project.backendapi.controller;

import com.project.backendapi.model.Products;
import com.project.backendapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public List<Products> allProducts() {
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public Optional<Products> getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }
    @PostMapping("/")
    public Products addProduct(@RequestBody Products product) {
        return productService.addProduct(product);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }

}
