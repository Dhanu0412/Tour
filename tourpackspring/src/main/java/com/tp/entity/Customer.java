package com.tp.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Customer {

	@Id
	@GeneratedValue
	private int customerID;
	
	@Embedded
	private Name customerName;
	@Column
	private String gender;
	@Column
	private String password;
	@Column
	private String username;
	@Column
	private String email;
	
	@Column
	private Date dateOfBirth;
	@Column
	private long phone;
	
	@OneToOne
	@JoinColumn(name = "addressID",referencedColumnName = "ADDRESSID")
	private Address address;
	
	@OneToMany(targetEntity = PackageBooking.class, mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PackageBooking> packageBooking;

	public Customer() {
		super();
	}

	public Customer(int customerID, Name customerName, String gender, String password, String username, String email,
			Date dateOfBirth, long phone, Address address) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.gender = gender;
		this.password = password;
		this.username = username;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
		this.address = address;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public Name getCustomerName() {
		return customerName;
	}

	public void setCustomerName(Name customerName) {
		this.customerName = customerName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", gender=" + gender
				+ ", password=" + password + ", username=" + username + ", email=" + email + ", dateOfBirth="
				+ dateOfBirth + ", phone=" + phone + ", address=" + address + "]";
	}

}
