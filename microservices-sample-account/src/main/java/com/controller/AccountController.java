package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.Account;
import com.repository.AccountRepositoryInterface;

@RestController
public class AccountController {
	
	@Autowired
	AccountRepositoryInterface accountRepositoryInterface;
	
	
	@RequestMapping(value="/saveAccount", method=RequestMethod.POST)
	public void saveAccount(Account account){
		
		
		accountRepositoryInterface.save(account);
		
	}
	
	@RequestMapping(value="/getAccount/{accountNo}", method=RequestMethod.GET)
	public Account getAccountByNo(@PathVariable("accountNo") int accountNo){
		
		return accountRepositoryInterface.findOne((long) accountNo);
	}

}
