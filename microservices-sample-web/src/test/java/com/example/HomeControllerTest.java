package com.example;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MicroservicesSampleWebApplication.class)
@WebAppConfiguration
public class HomeControllerTest {

	@Test
	public void getUsersTest(){
		/*
		RestTemplate template = new RestTemplate();
		URI url;
		try {
			url = new URI("http://localhost:8010/users");
			List<User> users  = template.getForObject(url, List.class);
			System.out.println(users.get(0).getFirstName());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
}
