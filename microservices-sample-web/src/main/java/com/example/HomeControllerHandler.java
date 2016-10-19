package com.example;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HomeControllerHandler {

	
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	public List<User> getUsersLocal(){
		List<User> users = new ArrayList<User>();
		User user = new User();
		user.setFirstName("Javier");
		user.setLastName("Puente");
		user.setId(100);
		users.add(user);
		
		return users;
	}
	
	public List<User> getUsers(){
		RestTemplate template = new RestTemplate();
		List<User> users = new ArrayList<User>();
		URI uri;
		List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
		ServiceInstance instance = instances.iterator().next();
		try {
			
			//uri = new URI("http://localhost:2222/users");
			uri = new URI(instance.getUri() +"/users");
			
			ResponseEntity<List> responseEntities = template.getForEntity(uri, List.class);
			
			
			for(Iterator<LinkedHashMap> itr = responseEntities.getBody().iterator(); itr.hasNext(); ){
				LinkedHashMap map = itr.next();
				User user = new User();
				for(Iterator iterator = map.keySet().iterator(); iterator.hasNext();){
					String propName = (String)iterator.next();
					if(propName.equals("id")){
						//String userId =(String)map.get(propName);
						user.setId((Integer)map.get(propName));

						System.out.println(user.getId());
					}if(propName.equals("firstName"))
						user.setFirstName((String)map.get(propName));
					if(propName.equals("lastName"))
						user.setLastName((String)map.get(propName));
				}
				users.add(user);
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
	}
	
	public void addUser(){
		
	}

	public List<Account> getAccountsLocal() {
		List<Account> accounts = new ArrayList<Account>();
		Account account = new Account();
		account.setAccountId(201);
		account.setAccountNo(102313);
		//account.setBalance(500.00);
		accounts.add(account);
		
		return accounts;
	}
	
	public List<Account> getAccounts(int id) {
		RestTemplate template = new RestTemplate();
		List<Account> accounts = null;
		Account[] accountsArray = null;
		URI uri;
		List<ServiceInstance> instances = discoveryClient.getInstances("account-service");
		ServiceInstance instance = instances.iterator().next();
		
		try {
			System.out.println(instance.getUri());
			uri = new URI(instance.getUri()+ "/accountsByUserId/"+id);
			//users = template.getForObject(uri, List.class);
			ResponseEntity<Account[]> responseEntities = template.getForEntity(uri, Account[].class);
			accountsArray = responseEntities.getBody();
			if(accountsArray.length>0)
				accounts = Arrays.asList(accountsArray);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return accounts;
	}
}
