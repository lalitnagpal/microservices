package com.imageservice.microservices.images.entity;

import java.util.List;

public class ImageResponse {
    private List<Image> images;

    public ImageResponse(){
    }

    public ImageResponse(List<Image> images){
        this.images = images;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
