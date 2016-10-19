package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.model.User;
import com.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/users")
	public List<User> getAllUsers(){
		
		
		return userService.getUsers();
		
	}
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public void save(User user){
		
		userService.save(user);
	}
	
	@RequestMapping(value="/userById/{userId}", method=RequestMethod.GET)
	public User getUserById(@PathVariable("userId") Long userId){
		
		return userService.getUserById(userId);
	}
	
	/*@RequestMapping(value="/accountByUserId/{userId}", method=RequestMethod.GET)
	public List<Account> getAllAccount(@PathVariable("userId") Long userId){
		
		return userService.getUserById(userId).getAccounts();
	}*/
}
