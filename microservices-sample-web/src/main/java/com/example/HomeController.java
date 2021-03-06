package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@Autowired 
	HomeControllerHandler handler;
	
	@RequestMapping(method=RequestMethod.GET, path="/users")
	public String getUsers(Model model, HttpServletRequest request){
		List<User> users = handler.getUsers();
		model.addAttribute("users", users);
	
		return "listusers";
		
	}
	

	@RequestMapping("/")
	public String home(){
		
		return "index";
	}


	@RequestMapping(method=RequestMethod.GET, path="/users/{uid}/accounts")
	public String getAccounts(@PathVariable  int uid, Model model){
		List<Account> accounts = handler.getAccounts(uid);
		
		
		model.addAttribute("accounts", accounts);
		return "listaccounts";

	}
}
