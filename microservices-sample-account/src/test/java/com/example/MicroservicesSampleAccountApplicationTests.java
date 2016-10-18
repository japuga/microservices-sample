package com.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.model.Account;
import com.repository.AccountRepository;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MicroservicesSampleAccountApplication.class)
@WebAppConfiguration
public class MicroservicesSampleAccountApplicationTests {

	
	AccountRepository accountRepository = new AccountRepository();
	@Test
	public void contextLoads() {
	}
	
	
	@Test
	public void saveReterievDataTest(){
		
		Account account = new Account(100, 11111, "checking");
		
		accountRepository.saveAccount(account);
		
		//asserTrue(accountRepository.getAccountByNo(11111).getAccountId().equals(100));
		
		System.out.println("Account Type: "+accountRepository.getAccountByNo(11111).getType());
		assertTrue("James"=="James");
	
	}

}
