package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;
import com.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/getUsers")
	public List<User> getAllUsers(){
		
		
		return userService.getUsers();
		
	}
	
	@RequestMapping("/addUser")
	public void save(User user){
		
		userService.save(user);
	}
}
