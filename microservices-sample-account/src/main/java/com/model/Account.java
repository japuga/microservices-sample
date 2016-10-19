package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Account {
	
	@Id
	private long accountId;
	
	private int accountNo;
	
	private String type;
	
	private double balance;
	
	private long userId;
	
	public Account(){
		
	}

	public Account(long id, int accountNo, String type, double balance) {
		super();
		this.accountId = id;
		this.accountNo = accountNo;
		this.type = type;
		this.balance = balance;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long id) {
		this.accountId = id;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	
	

}
