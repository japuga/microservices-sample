package com.service;

import java.util.List;

import com.model.User;

public interface UserService {
	
	public List<User> getUsers();
	
	public User getUserById(Long id);
	
	public void save(User user);
	

}
