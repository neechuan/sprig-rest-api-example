package com.example.app2server.controller;

import com.example.app2server.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    // GET all products
    @GetMapping
    public List<Product> getAllProducts() {
        try {
            // Pauses for 500 milliseconds (0.5 second)
            Thread.sleep(500); 
        } catch (InterruptedException e) {
            // Standard practice is to re-interrupt the thread
            Thread.currentThread().interrupt();
        }
        return List.of(
            new Product(1, "Laptop",  1200.00),
            new Product(2, "Monitor",  350.00),
            new Product(3, "Keyboard",  75.00)
        );
    }

    // GET product by ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        try {
            // Pauses for 500 milliseconds (0.5 second)
            Thread.sleep(500); 
        } catch (InterruptedException e) {
            // Standard practice is to re-interrupt the thread
            Thread.currentThread().interrupt();
        }
        return new Product(id, "Sample Product #" + id, 99.99 * id);
    }

    // POST create product
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        // Simulate saving and returning with generated ID
        product.setId(100);
        return product;
    }
}