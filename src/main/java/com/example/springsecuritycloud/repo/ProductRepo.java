package com.example.springsecuritycloud.repo;

import com.example.springsecuritycloud.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ProductRepo extends CrudRepository<Product,Long> {
    Product findByName(String name);
    ArrayList<Product> findAll();
}
