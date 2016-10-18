package com.example;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HomeControllerHandler {

	public List<User> getUsersLocal(){
		List<User> users = new ArrayList<User>();
		User user = new User();
		user.setFirstName("Javier");
		user.setLastName("Puente");
		user.setUid(100);
		users.add(user);
		
		return users;
	}
	
	public List<User> getUsers(){
		RestTemplate template = new RestTemplate();
		List<User> users = null;
		URI uri;
		try {
			uri = new URI("http://localhost:2222/users");
			users = template.getForObject(uri, List.class);
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
	}
	
	public void addUser(){
		
	}
}
