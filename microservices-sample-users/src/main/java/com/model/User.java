package com.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	
	@Id
	private long id;
	private String firstName;
	private String lastName;
	//private Address address;
	
	@OneToMany
	private List<Account> account;
	
	
	public User(){
		
	}
	
	public User(Long id, String name, String lName) {
		super();
		this.id = id;
		this.firstName = name;
		this.lastName = lName;
		//this.address = address;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String name) {
		this.firstName = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lName) {
		this.lastName = lName;
	}
	/*public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	*/
	
	

}
