package com.example.sleuthandzipkin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppAutoConfiguration {
  @Bean 
  WebClient.Builder webClientBuilder() {
    return WebClient.builder();
  }
}
