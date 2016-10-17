package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(method=RequestMethod.GET, path="/users")
	public String getUsers(Model model, HttpServletRequest request){
		List<User> users = new ArrayList<User>();
		//model.addAttribute("users", users);
	
		request.getSession().setAttribute("users", users);
		
		return "listusers";
		
	}
}
