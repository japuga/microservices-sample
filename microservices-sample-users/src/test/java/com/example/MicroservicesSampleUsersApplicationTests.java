package com.example;

import static org.junit.Assert.assertTrue;

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
	
	@Test
	public void testSave(){
		//UserService userService = wac.getBean(UserService.class);
		User user = new User((long) 1000, "James", "John"); 
		userService.save(user);
			assertTrue(userService.getUserById((long) 1000).getFirstName().equals("James"));
	}

}
