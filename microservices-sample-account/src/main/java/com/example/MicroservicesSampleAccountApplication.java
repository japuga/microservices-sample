package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication
public class MicroservicesSampleAccountApplication {

	public static void main(String[] args) {
		
		System.setProperty("spring.config.name", "account-server");
		SpringApplication.run(MicroservicesSampleAccountApplication.class, args);
		
		
	}
}
