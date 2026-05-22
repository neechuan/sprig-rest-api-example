package com.example.app1client.service;

import com.example.app1client.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductClientService {

    private final RestTemplate restTemplate;
    private final String app2BaseUrl;

    public ProductClientService(RestTemplate restTemplate,
                                 @Value("${app2.base-url}") String app2BaseUrl) {
        this.restTemplate = restTemplate;
        this.app2BaseUrl = app2BaseUrl;
    }

    // Call App2 — GET all products
    public List<Product> fetchAllProducts() {
        String url = app2BaseUrl + "/api/products";
        Product[] products = restTemplate.getForObject(url, Product[].class);
        return products != null ? Arrays.asList(products) : List.of();
    }

    // Call App2 — GET product by ID
    public Product fetchProductById(int id) {
        String url = app2BaseUrl + "/api/products/" + id;
        return restTemplate.getForObject(url, Product.class);
    }

    // Call App2 — POST create product
    public Product createProduct(Product product) {
        String url = app2BaseUrl + "/api/products";
        return restTemplate.postForObject(url, product, Product.class);
    }
}