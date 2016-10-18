package com.repository;

import java.util.HashMap;
import java.util.Map;

import com.model.Account;

public class AccountRepository {
	
	Map<Integer, Account> map = new HashMap<>();

	
	public void saveAccount(Account account){
		
		map.put(account.getAccountNo(), account);
	}
	
	public Account getAccountByNo(int accountNo){
		
		return map.get(accountNo);
	}
}
