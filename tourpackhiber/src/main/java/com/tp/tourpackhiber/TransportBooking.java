package com.tp.tourpackhiber;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class TransportBooking {

	@Id
	@GeneratedValue
	private int transportBookingID;

	private double distance;
	private double transportCost;
	private int noOfPeople;
	private String startLocation;
	private String endLocation;
	private boolean twoWay;
	
	@Temporal(TemporalType.DATE)
	private Date onwardDate;
	
	@Temporal(TemporalType.DATE)
	private Date returnDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "modeID")
	private ModeOfTransport modeOfTransport;

	public TransportBooking() {
		super();
	}

	public TransportBooking(int transportBookingID, double distance, double transportCost, int noOfPeople,
			String startLocation, String endLocation, boolean twoWay, Date onwardDate, Date returnDate,
			ModeOfTransport modeOfTransport) {
		super();
		this.transportBookingID = transportBookingID;
		this.distance = distance;
		this.transportCost = transportCost;
		this.noOfPeople = noOfPeople;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
		this.twoWay = twoWay;
		this.onwardDate = onwardDate;
		this.returnDate = returnDate;
		this.modeOfTransport = modeOfTransport;
	}

	public int getTransportBookingID() {
		return transportBookingID;
	}

	public void setTransportBookingID(int transportBookingID) {
		this.transportBookingID = transportBookingID;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getTransportCost() {
		return transportCost;
	}

	public void setTransportCost(double transportCost) {
		this.transportCost = transportCost;
	}

	public int getNoOfPeople() {
		return noOfPeople;
	}

	public void setNoOfPeople(int noOfPeople) {
		this.noOfPeople = noOfPeople;
	}

	public String getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}

	public String getEndLocation() {
		return endLocation;
	}

	public void setEndLocation(String endLocation) {
		this.endLocation = endLocation;
	}

	public boolean isTwoWay() {
		return twoWay;
	}

	public void setTwoWay(boolean twoWay) {
		this.twoWay = twoWay;
	}

	public Date getOnwardDate() {
		return onwardDate;
	}

	public void setOnwardDate(Date onwardDate) {
		this.onwardDate = onwardDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public ModeOfTransport getModeOfTransport() {
		return modeOfTransport;
	}

	public void setModeOfTransport(ModeOfTransport modeOfTransport) {
		this.modeOfTransport = modeOfTransport;
	}

	@Override
	public String toString() {
		return "TransportBooking [transportBookingID=" + transportBookingID + ", distance=" + distance
				+ ", transportCost=" + transportCost + ", noOfPeople=" + noOfPeople + ", startLocation=" + startLocation
				+ ", endLocation=" + endLocation + ", twoWay=" + twoWay + ", onwardDate=" + onwardDate + ", returnDate="
				+ returnDate + ", modeOfTransport=" + modeOfTransport + "]";
	}
	
}
