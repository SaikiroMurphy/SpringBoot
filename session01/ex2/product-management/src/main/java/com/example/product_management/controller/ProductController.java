package com.example.product_management.controller;

import org.springframework.stereotype.Controller;

import com.example.product_management.service.ProductService;

@Controller
public class ProductController {
    private ProductService productService;

    public ProductController (ProductService productService) {
        this.productService = productService;
    }
}
