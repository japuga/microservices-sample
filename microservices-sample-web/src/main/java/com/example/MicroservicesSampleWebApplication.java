package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroservicesSampleWebApplication {

	public static void main(String[] args) {
		//System.setProperty("spring.config.name", "web-server");
		
		SpringApplication.run(MicroservicesSampleWebApplication.class, args);
	}
}
