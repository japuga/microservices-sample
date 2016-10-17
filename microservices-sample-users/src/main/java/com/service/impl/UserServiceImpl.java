package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.model.User;
import com.repository.UserRepository;
import com.service.UserService;

public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	

	@Override
	public List<User> getUsers() {
		
		
		return userRepository.findAll();
		 
	}

	@Override
	public User getUserById(Long id) {
		
		return userRepository.findOne(id);
	}

	@Override
	public void save(User user) {

		
		userRepository.save(user);
	}

}
