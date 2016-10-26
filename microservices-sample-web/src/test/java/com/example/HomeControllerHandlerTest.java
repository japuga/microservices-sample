package com.example;


import static org.junit.Assert.assertTrue;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.client.RestTemplate;

public class HomeControllerHandlerTest {

	@Mock
	DiscoveryClient discoveryClient;
	
	@InjectMocks
	HomeControllerHandler homeControllerHandler;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getAccountsLocalTest(){
		int id=100;
		List<Account> accountsLocal = homeControllerHandler.getAccountsLocal(id);
		assertTrue(accountsLocal!=null);
	}
	
	@Test
	public void getAccountsTest() throws Exception{
		int id = 100;
		
		ServiceInstance instance = Mockito.mock(ServiceInstance.class);
		Mockito.when(instance.getUri()).thenReturn(new URI("http://localhost:3333/"));
		List<ServiceInstance> instances = new ArrayList<ServiceInstance>();
		instances.add(instance);
		
		Mockito.when(discoveryClient.getInstances("account-service")).thenReturn(instances);
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
