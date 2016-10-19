package com.example;

public class Account {
	
	

	private long accountId;
	
	private int accountNo;
	
	private String type;
	
	public Account(){
		
	}

	public Account(long accountId, int accountNo, String type) {
		super();
		this.accountId = accountId;
		this.accountNo = accountNo;
		this.type = type;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
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
	
	
	
	

}
