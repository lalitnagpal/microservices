package com.ecomm.microservices.ecommerce.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
public class ExternalConfig {

    //To add this property in consul UI, add it as config/ecommerce-service/useImages
    //and add its value as true

    @Value("${useImages:true}")
    private String useImages;

    public boolean getUseImages() {
        return Boolean.parseBoolean(useImages);
    }

    public void setUseImages(String useImages) {
        this.useImages = useImages;
    }
}
