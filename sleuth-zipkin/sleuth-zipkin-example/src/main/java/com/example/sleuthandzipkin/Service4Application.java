package com.example.sleuthandzipkin;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

@EnableAutoConfiguration
@RestController
public class Service4Application {

	private static final Logger log = LoggerFactory.getLogger(Service4Application.class.getName());

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

	public static void main(String[] args) {
		SpringApplication.run(Service4Application.class, "--spring.application.name=Service4", "--server.port=9094");
	}

	@Bean
	public RestTemplate getRestTemplate() {
		RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
		//interceptors.add(new LoggingRequestInterceptor());
		restTemplate.setInterceptors(interceptors);
		return restTemplate;
	}

	@RequestMapping("/")
	public String root() {
		String msg = "Service 4 : Root";
		log.info(msg);
		return msg;
	}

}
