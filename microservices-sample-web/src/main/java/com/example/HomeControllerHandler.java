package com.example;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class HomeControllerHandler {

	
	private RestTemplate template = new RestTemplate();
	
	
	public RestTemplate getTemplate() {
		return template;
	}

	public void setTemplate(RestTemplate template) {
		this.template = template;
	}

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
		//RestTemplate template = new RestTemplate();
		List<User> users = new ArrayList<User>();
		URI uri;
		List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
		ServiceInstance instance = instances.iterator().next();
		try {
			
			//uri = new URI("http://localhost:2222/users");
			uri = new URI(instance.getUri() +"/users");

			/*
			ResponseEntity<List> responseEntities = template.getForEntity(uri, List.class);
			
			
			for(Iterator<LinkedHashMap> itr = responseEntities.getBody().iterator(); itr.hasNext(); ){
				LinkedHashMap map = itr.next();
				User user = new User();
				for(Iterator iterator = map.keySet().iterator(); iterator.hasNext();){
					String propName = (String)iterator.next();
					if(propName.equals("id")){
						user.setId((Integer)map.get(propName));

						System.out.println(user.getId());
					}if(propName.equals("firstName"))
						user.setFirstName((String)map.get(propName));
					if(propName.equals("lastName"))
						user.setLastName((String)map.get(propName));
				}
				users.add(user);
			}
			*/
			User[] usersArray = null;
			ResponseEntity<User[]> responseEntities = template.getForEntity(uri, User[].class);
			usersArray = responseEntities.getBody();
			if(usersArray.length>0)
				users = Arrays.asList(usersArray);

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
	}
	
	public void addUser(){
		
	}

	public List<Account> getAccountsLocal(int id) {
		List<Account> accounts = new ArrayList<Account>();
		Account account = new Account();
		account.setAccountId(444);
		account.setAccountNo(102030);
		//account.setBalance(500.00);
		account.setType("checking");
		accounts.add(account);
		
		return accounts;
	}
	
	@HystrixCommand(fallbackMethod="getAccountsLocal")
	public List<Account> getAccounts(int id) {
		
		List<Account> accounts = null;
		Account[] accountsArray = null;
		URI uri;
		List<ServiceInstance> instances = discoveryClient.getInstances("account-service");
		ServiceInstance instance = instances.iterator().next();
		
		try {
			System.out.println(instance.getUri());
			uri = new URI(instance.getUri()+ "/accountsByUserId/"+id);
			
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
