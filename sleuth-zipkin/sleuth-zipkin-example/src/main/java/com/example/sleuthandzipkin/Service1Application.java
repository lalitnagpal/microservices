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
public class Service1Application {

	private static final Logger log = LoggerFactory.getLogger(Service1Application.class.getName());

	@Autowired
	private RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(Service1Application.class, "--spring.application.name=Service1", "--server.port=9091");
	}

	@Bean
	public RestTemplate getRestTemplate() {
		RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
		//interceptors.add(new LoggingRequestInterceptor());
		restTemplate.setInterceptors(interceptors);
		return restTemplate;
	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}


	@RequestMapping("/")
	public String root() {
		String msg = "Service 1 : Root";
		log.info(msg);
		return msg;
	}

	@RequestMapping("/callService2")
	public String callService2() {
		String msg = "service1 : callService2";
		msg += " --> " + restTemplate.getForObject("http://localhost:9092", String.class);
		log.info(msg);
		return msg;
	}

	@RequestMapping("/callService4")
	public String callService4() {
		String msg = "service1 : callService4";
		msg += " --> " + restTemplate.getForObject("http://localhost:9094", String.class);
		log.info(msg);
		return msg;
	}


}
