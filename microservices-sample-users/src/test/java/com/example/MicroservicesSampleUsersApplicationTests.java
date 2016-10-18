package com.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.model.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MicroservicesSampleUsersApplication.class)
@WebAppConfiguration
public class MicroservicesSampleUsersApplicationTests {

	/*@Autowired
	UserService userService;*/
	

	UserService userService = new UserServiceImpl();
	



	
	@Test
	public void testSave(){

		
	
		

		
		//System.out.println("User name: "+userService.getUserById((long) 100).getFirstName());
		//assertTrue(userService.getUserById((long) 100).getFirstName().equals("James"));

		//UserService userService = wac.getBean(UserService.class);
		User user = new User((long) 1000, "James", "John"); 
		
		userService.save(user);
		
		
		assertTrue(userService.getUserById((long) 1000).getFirstName()=="James");

		
		assertTrue("James"=="James");
	}

}
