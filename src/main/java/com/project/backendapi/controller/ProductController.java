package com.project.backendapi.controller;

import com.project.backendapi.model.Products;
import com.project.backendapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ResponseEntity<?> allProducts() {
        List<Products> products = productService.getAllProducts();
        if(products.isEmpty()){
            return new ResponseEntity<>("No products found", HttpStatus.OK);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
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
