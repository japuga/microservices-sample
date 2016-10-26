package com.example;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;

public class HomeControllerTest {

	@Mock
	DiscoveryClient discoveryClient;
	
	@Mock
	HomeControllerHandler homeControllerHandler;
	
	@InjectMocks
	HomeController homeController;
	
	MockMvc mockMvc;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
		
	}
	
	@Test
	public void getUsersTest() throws Exception{
		List<User> users = new ArrayList<User>();
		User user = new User();
		users.add(user);

		URI uri = new URI("http://localhost:2222/");
		ServiceInstance instance = Mockito.mock(ServiceInstance.class);
		Mockito.when(instance.getUri()).thenReturn(uri);
		List<ServiceInstance> instances = new ArrayList<ServiceInstance>();
		instances.add(instance);
		Mockito.when(discoveryClient.getInstances("user-service")).thenReturn(instances);
		
		RestTemplate template = Mockito.mock(RestTemplate.class);
		ResponseEntity<User[]> responseEntity = 
				new ResponseEntity<User[]>(users.toArray(new User[]{}), HttpStatus.OK);
		Mockito.when(template.getForEntity(uri, User[].class)).thenReturn(responseEntity);
		homeControllerHandler.setTemplate(template);
		Mockito.when(homeControllerHandler.getUsers()).thenReturn(users);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/users"))
				.andExpect(status().isOk())
				.andExpect(view().name("listusers"))
				.andExpect(model().attribute("users", users));
	
	}
}
