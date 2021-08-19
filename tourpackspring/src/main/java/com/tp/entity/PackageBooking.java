package com.tp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PackageBooking {

	@Id
	@GeneratedValue
	private int packageBookingID;

	private int noOfDays;
	private int noOfPeope;
	private double packageCost;

	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Temporal(TemporalType.DATE)
	private Date endDate;

	@ManyToOne
	@JoinColumn(name = "packageID", referencedColumnName = "PACKAGEID")
	private Packages pack;
	
	@ManyToOne
	@JoinColumn(name = "customerID", referencedColumnName = "CUSTOMERID")
	private Customer customer;

	public PackageBooking() {
		super();
	}

	public PackageBooking(int packageBookingID, int noOfDays, int noOfPeope, double packageCost, Date startDate,
			Date endDate, Packages pack, Customer customer) {
		super();
		this.packageBookingID = packageBookingID;
		this.noOfDays = noOfDays;
		this.noOfPeope = noOfPeope;
		this.packageCost = packageCost;
		this.startDate = startDate;
		this.endDate = endDate;
		this.pack = pack;
		this.customer = customer;
	}

	public int getPackageBookingID() {
		return packageBookingID;
	}

	public void setPackageBookingID(int packageBookingID) {
		this.packageBookingID = packageBookingID;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	public int getNoOfPeope() {
		return noOfPeope;
	}

	public void setNoOfPeope(int noOfPeope) {
		this.noOfPeope = noOfPeope;
	}

	public double getPackageCost() {
		return packageCost;
	}

	public void setPackageCost(double packageCost) {
		this.packageCost = packageCost;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Packages getPack() {
		return pack;
	}

	public void setPack(Packages pack) {
		this.pack = pack;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "PackageBooking [packageBookingID=" + packageBookingID + ", noOfDays=" + noOfDays + ", noOfPeope="
				+ noOfPeope + ", packageCost=" + packageCost + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", pack=" + pack + ", customer=" + customer + "]";
	}

}
