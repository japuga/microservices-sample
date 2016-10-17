package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(method=RequestMethod.GET, path="/users")
	public String getUsers(Model model, HttpServletRequest request){
		List<User> users = new ArrayList<User>();
		User user = new User();
		user.setFirstName("Javier");
		user.setLastName("Puente");
		user.setUid(100);
		users.add(user);
		model.addAttribute("users", users);
	
		//request.getSession().setAttribute("users", users);
		
		return "listusers";
		
	}
	

	@RequestMapping("/")
	public String home(){
		
		return "index";
	}


	@RequestMapping(method=RequestMethod.GET, path="/users/{uid}/accounts")
	public String getAccounts(@PathVariable  int uid, Model model){
		System.out.println(uid);
		List<Account> accounts = new ArrayList<Account>();
		Account account = new Account();
		account.setAccountId(201);
		account.setAccountNo("102313");
		account.setBalance(500.00);
		accounts.add(account);
		model.addAttribute("accounts", accounts);
		return "listaccounts";

	}
}
