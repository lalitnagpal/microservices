package com.ecomm.microservices.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.microservices.ecommerce.assembler.ProductAssembler;
import com.ecomm.microservices.ecommerce.entity.EcommerceProduct;
import com.ecomm.microservices.ecommerce.entity.EcommerceProductResponse;

import java.util.List;

@RestController
public class EcommerceController {

    @Autowired
    ProductAssembler productAssembler;

    @GetMapping("/ecommerceProducts")
    public EcommerceProductResponse getAllEcommerceProducts(){
        return new EcommerceProductResponse(productAssembler.getEcommerceProducts());
    }
}
