package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {
	
	@Id
	private Long addressId;
	
	private int streetNo;
	private String street;
	private String city;
	private String state;
	private int zip;
	public Address( long id, int streetNo, String street, String city, String state, int zip) {
		super();
		
		this.addressId = id;
		this.streetNo = streetNo;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	
	public Long getAddressId() {
		return addressId;
	}


	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}


	public int getStreetNo() {
		return streetNo;
	}
	public void setStreetNo(int streetNo) {
		this.streetNo = streetNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	
	
	

}
