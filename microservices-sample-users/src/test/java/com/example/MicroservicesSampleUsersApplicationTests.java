package com.example;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.model.User;
import com.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MicroservicesSampleUsersApplication.class)
@WebAppConfiguration
public class MicroservicesSampleUsersApplicationTests {

	@Autowired
	UserService userService;
	

	//UserService userService = new UserServiceImpl();
	



	
	@Test
	public void testSave(){

		
		User user = new User();
		user.setFirstName("Merry");
		user.setLastName("Michael");
		user.setId((long) 1000);
		
		userService.save(user);
		
	
		//System.out.println("user name: "+ userService.getUserById((long) 100).getLastName());

		
		
		
		assertTrue(userService.getUserById((long) 1000).getFirstName().equals("Merry"));

		
		
	}
	
	@Test
	public void testSave1(){

		
		
		
	
		System.out.println("Output from Test1 user name: "+ userService.getUserById((long) 100).getLastName());

		
		
		
		assertTrue(userService.getUserById((long) 100).getFirstName().equals("James"));

		
		
	}
	
	

}
