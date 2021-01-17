package com.product.microservices.product.entity;

import java.util.List;

public class ProductResponse {
    private List<Product> products;

    public ProductResponse(List<Product> products){
        this.products = products;
    }
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
