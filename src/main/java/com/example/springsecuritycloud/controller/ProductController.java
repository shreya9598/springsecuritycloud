package com.example.springsecuritycloud.controller;

import com.example.springsecuritycloud.model.Product;
import com.example.springsecuritycloud.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductRepo productRepo;
    @PostMapping("/products")
    public void createCoupon(@RequestBody Product product) {
        System.out.println("POST MAPPING");
        productRepo.save(product);
    }

    @GetMapping("/products")
    public List<Product> getAllCoupons() {
        // return List.of();
        return productRepo.findAll();
    }

    @GetMapping("/products/{name}")
    public Product getCoupon(@PathVariable("name") String name) {
        Product product = productRepo.findByName(name);
        return product;
    }

    @PostMapping("/test")
    void test() {
        System.out.println("TESTPOST");
    }
}
