package com.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.repository.AccountRepositoryInterface;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MicroservicesSampleAccountApplication.class)
@WebAppConfiguration
public class MicroservicesSampleAccountApplicationTests {

	
	@Autowired
	AccountRepositoryInterface accountRepository;
	
	@Test
	public void contextLoads() {
	}
	
	
	@Test
	public void saveReterievDataTest(){
		
		
		
		//assertTrue(accountRepository.findOne((long) 11111)).getType().equals("checking"));
		
		assertTrue(accountRepository.findOne((long) 200).getType().equals("checking"));

	}
	
	@Test
	public void reteriveAccountsByUserId(){
		
		
		
		//assertTrue(accountRepository.findOne((long) 11111)).getType().equals("checking"));
		
		//assertTrue(accountRepository.findOne((long) 200).getType().equals("checking"));
		assertTrue(accountRepository.findAccountsByUserId(100).get(0).getType().equals("checking"));

	}


}
