package com.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	
	@Id
	private long id;
	private String name;
	private String lName;
	private Address address;
	
	@OneToMany
	private List<Account> account;
	
	
	
	
	public User(Long id, String name, String lName, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.lName = lName;
		this.address = address;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	

}
