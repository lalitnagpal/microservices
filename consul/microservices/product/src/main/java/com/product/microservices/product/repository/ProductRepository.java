package com.product.microservices.product.repository;

import org.springframework.data.repository.CrudRepository;

import com.product.microservices.product.entity.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Long> {

    List<Product> findAll();
}
