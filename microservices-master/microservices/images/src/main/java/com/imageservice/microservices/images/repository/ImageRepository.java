package com.imageservice.microservices.images.repository;

import org.springframework.data.repository.CrudRepository;

import com.imageservice.microservices.images.entity.Image;

import java.util.List;

public interface ImageRepository extends CrudRepository<Image,Long>{

    List<Image> findAll();
}
