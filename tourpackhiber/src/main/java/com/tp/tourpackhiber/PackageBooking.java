package com.tp.tourpackhiber;

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
	private Package pack;
	
	@ManyToOne
	@JoinColumn(name = "customerID")
	private Customer customer;
	
//	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
//	@JoinColumn(name = "paymentID_FK")
//	private Payment payment;

	public PackageBooking() {
		super();
	}

	public PackageBooking(int packageBookingID, int noOfDays, int noOfPeope, double packageCost, Date startDate,
			Date endDate, Package pack, Customer customer) {//, com.tp.tourpackhiber.Payment payment) {
		super();
		this.packageBookingID = packageBookingID;
		this.noOfDays = noOfDays;
		this.noOfPeope = noOfPeope;
		this.packageCost = packageCost;
		this.startDate = startDate;
		this.endDate = endDate;
		this.pack = pack;
		this.customer = customer;
//		this.payment = payment;
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

	public Package getPack() {
		return pack;
	}

	public void setPack(Package pack) {
		this.pack = pack;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

//	public Payment getPayment() {
//		return payment;
//	}
//
//	public void setPayment(Payment payment) {
//		this.payment = payment;
//	}

	@Override
	public String toString() {
		return "PackageBooking [packageBookingID=" + packageBookingID + ", noOfDays=" + noOfDays + ", noOfPeope="
				+ noOfPeope + ", packageCost=" + packageCost + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", pack=" + pack + ", customer=" + customer + "]";//+ ", payment=" + payment + "]";
	}

}
