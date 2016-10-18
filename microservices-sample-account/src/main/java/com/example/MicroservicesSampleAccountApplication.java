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

import com.model.Account;
import com.repository.AccountRepositoryInterface;

@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages="com")
@EnableJpaRepositories(basePackages={"com.repository"})
@EntityScan("com.model")
public class MicroservicesSampleAccountApplication {

	public static void main(String[] args) {
		
		System.setProperty("spring.config.name", "account-server");
		SpringApplication.run(MicroservicesSampleAccountApplication.class, args);
		
		
	}
	
	@Autowired
	AccountRepositoryInterface accountRepository;
	
	
	
	@PostConstruct
	public void intAccount(){
		
		Account account = new Account();
		
		account.setAccountId(200);
		account.setAccountNo(11111);
		account.setType("checking");
		
		accountRepository.save(account);
		
		
	}
}
