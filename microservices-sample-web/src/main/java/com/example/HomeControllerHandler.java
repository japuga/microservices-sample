package com.example;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HomeControllerHandler {

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
		try {
			uri = new URI("http://localhost:2222/users");
			//users = template.getForObject(uri, List.class);
			ResponseEntity<List> responseEntities = template.getForEntity(uri, List.class);
			//users = responseEntities.getBody();
			//System.out.println(responseEntities.getBody().getClass().getName());
			
			//LinkedHashMap map = (LinkedHashMap)responseEntities.getBody().iterator().next();
			
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
}