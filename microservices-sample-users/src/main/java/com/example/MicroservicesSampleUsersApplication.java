package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication
public class MicroservicesSampleUsersApplication {

	public static void main(String[] args) {
		
		System.setProperty("spring.config.name", "user-server");
		SpringApplication.run(MicroservicesSampleUsersApplication.class, args);
	}
}
