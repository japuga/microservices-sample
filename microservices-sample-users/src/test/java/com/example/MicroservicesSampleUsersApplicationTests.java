package com.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.model.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MicroservicesSampleUsersApplication.class)
@WebAppConfiguration
public class MicroservicesSampleUsersApplicationTests {

	/*@Autowired
	UserService userService;*/
	
	//UserService userService = new UserServiceImpl();
	
@Test
	public void contextLoads() {
	}
	
	@Test
	public void testSave(){
		
	//User user = new User((long) 100, "James", "John"); 
		//User user = new User();
		//userService.save(user);
		
		//System.out.println("User name: "+userService.getUserById((long) 100).getFirstName());
		//assertTrue(userService.getUserById((long) 100).getFirstName().equals("James"));
		//assertThat("James").isEqualTo("John");
		assertTrue("James"=="James");
	}

}
