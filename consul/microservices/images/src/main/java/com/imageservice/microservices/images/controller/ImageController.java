package com.imageservice.microservices.images.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imageservice.microservices.images.entity.ImageResponse;
import com.imageservice.microservices.images.repository.ImageRepository;

@RestController
public class ImageController {

    @Autowired
    private ImageRepository imageRepository;

    @GetMapping("/images")
    public ImageResponse getAllImages(){
        return new ImageResponse(imageRepository.findAll());
    }
}
