package com.tp.tourpackhiber;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Address {

	@Id
	@GeneratedValue
	private int addressID;

	private int doorno;
	private String street;
	private String city;
	private int pincode;
	
	@OneToOne
	@JoinColumn(name = "customerID",referencedColumnName = "CUSTOMERID")
	private Customer customer;

	public Address() {
		super();
	}

	public Address(int doorno, String street, String city, int pincode, Customer customer) {
		super();
		this.doorno = doorno;
		this.street = street;
		this.city = city;
		this.pincode = pincode;
		this.customer = customer;
	}

	public int getAddressID() {
		return addressID;
	}

	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}

	public int getDoorno() {
		return doorno;
	}

	public void setDoorno(int doorno) {
		this.doorno = doorno;
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

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Address [addressID=" + addressID + ", doorno=" + doorno + ", street=" + street + ", city=" + city
				+ ", pincode=" + pincode + ", customer=" + customer + "]";
	}
	
}
