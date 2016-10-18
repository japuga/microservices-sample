package com.example;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.model.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

import ch.qos.logback.core.net.SyslogOutputStream;



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
	
@Autowired
	UserService userService;
	
	
	@PostConstruct
	public void intUsers(){
		
		User user = new User();
		user.setFirstName("James");
		user.setLastName("Nani");
		user.setId((long) 100);
		
		userService.save(user);
		
		
		
	}
	
	
	
}
