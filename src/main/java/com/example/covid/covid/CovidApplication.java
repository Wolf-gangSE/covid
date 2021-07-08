package com.example.covid.covid;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@ServletComponentScan
@SpringBootApplication
public class CovidApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovidApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(List<HttpMessageConverter<?>>messageConverters) {
	return new RestTemplate(messageConverters);
	}

}
