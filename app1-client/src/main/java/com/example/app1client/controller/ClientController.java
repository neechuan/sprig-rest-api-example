package com.example.app1client.controller;

import com.example.app1client.model.Product;
import com.example.app1client.service.ProductClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client/products")
public class ClientController {

    private final ProductClientService service;

    public ClientController(ProductClientService service) {
        this.service = service;
    }

    // Triggers GET call to App2
    @GetMapping
    public List<Product> getAllProducts() {
        return service.fetchAllProducts();
    }

    // Triggers GET by ID call to App2
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id) {
        return service.fetchProductById(id);
    }

    // Triggers POST call to App2
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return service.createProduct(product);
    }
}