package com.product.microservices.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.microservices.product.entity.ProductResponse;
import com.product.microservices.product.repository.ProductRepository;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

//    @Autowired
//    ExternalConfig externalConfig;

    @GetMapping("/products")
    public ProductResponse getAllProducts(){
//        System.out.println(externalConfig.getName());
        return new ProductResponse(productRepository.findAll());
    }
}
