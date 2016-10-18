package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages="com")
@EnableJpaRepositories(basePackages={"com.repository"})
@EntityScan("com.model")
public class MicroservicesSampleUsersApplication {

	public static void main(String[] args) {
		
		System.setProperty("spring.config.name", "user-server");
		SpringApplication.run(MicroservicesSampleUsersApplication.class, args);
	}
}
