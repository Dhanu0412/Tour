package com.tp.tourpackhiber;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int paymentID;
	 
	@Temporal(TemporalType.TIMESTAMP)
	private Date paymentDate;
	 
	private String paymentMode;
	private boolean paymentStatus;
	private boolean refundStatus;

//	@OneToOne(mappedBy = "payment", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "packageBookingID_FK")
	private PackageBooking packageBooking;

	public Payment() {
		super();
	}

	public Payment(int paymentID, Date paymentDate, String paymentMode, boolean paymentStatus, boolean refundStatus,
			PackageBooking packageBooking) {
		super();
		this.paymentID = paymentID;
		this.paymentDate = paymentDate;
		this.paymentMode = paymentMode;
		this.paymentStatus = paymentStatus;
		this.refundStatus = refundStatus;
		this.packageBooking = packageBooking;
	}

	public int getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public boolean isPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public boolean isRefundStatus() {
		return refundStatus;
	}

	public void setRefundStatus(boolean refundStatus) {
		this.refundStatus = refundStatus;
	}

	public PackageBooking getPackageBooking() {
		return packageBooking;
	}

	public void setPackageBooking(PackageBooking packageBooking) {
		this.packageBooking = packageBooking;
	}

	@Override
	public String toString() {
		return "Payment [paymentID=" + paymentID + ", paymentDate=" + paymentDate + ", paymentMode=" + paymentMode
				+ ", paymentStatus=" + paymentStatus + ", refundStatus=" + refundStatus + ", packageBooking="
				+ packageBooking + "]";
	}
	
}
