package com.example.product_management.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.product_management.model.Product;

@Service
public class ProductService {
    private ArrayList<Product> products;

    public ProductService() {
        products = new ArrayList<>();
        Product p1 = new Product(0, "A", 1000);
        Product p2 = new Product(1, "B", 2000);
        Product p3 = new Product(2, "C", 3000);

        products.add(p1);
        products.add(p2);
        products.add(p3);
    }
    
    public void getAllProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
