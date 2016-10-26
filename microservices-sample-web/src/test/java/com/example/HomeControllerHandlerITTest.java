package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MicroservicesSampleWebApplication.class)
@WebAppConfiguration
public class HomeControllerHandlerITTest {

	@Autowired
	HomeControllerHandler homeControllerHandler;
	
	@Test
	public void getAccountsLocalTest(){
		int id = 100;
		List<Account> accountsLocal = homeControllerHandler.getAccountsLocal(id);
		assertTrue(accountsLocal!=null);
	}
	
	@Test
	public void getAccountsTest(){
		int id = 100;
		List<Account> accounts = homeControllerHandler.getAccounts(id);
		
		assertTrue(accounts!=null);
	}
	
	@Test
	public void getUserLocalTest(){
		
		List<User> users = homeControllerHandler.getUsersLocal();
		
		assertTrue(users!=null);
	}
	
	@Test
	public void getuserTest(){
		List<User> users = homeControllerHandler.getUsers();
		assertTrue(users!=null);
		
	}
}
