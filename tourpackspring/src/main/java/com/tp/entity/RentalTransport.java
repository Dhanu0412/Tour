package com.tp.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "RENTAL_TYPE")
@Entity
public class RentalTransport {

	@Id
	@GeneratedValue
	private int rentalTransportID;

	private String vehicleProvider;

	@OneToOne
	@JoinColumn(name = "packageID",referencedColumnName = "PACKAGEID")
	private Packages pack;

	public RentalTransport() {
		super();
		System.out.println("From RentalTransport");
	}

	public RentalTransport(int rentalTransportID, String vehicleProvider, Packages pack) {
		super();
		this.rentalTransportID = rentalTransportID;
		this.vehicleProvider = vehicleProvider;
		this.pack = pack;
	}

	public int getRentalTransportID() {
		return rentalTransportID;
	}

	public void setRentalTransportID(int rentalTransportID) {
		this.rentalTransportID = rentalTransportID;
	}

	public String getVehicleProvider() {
		return vehicleProvider;
	}

	public void setVehicleProvider(String vehicleProvider) {
		this.vehicleProvider = vehicleProvider;
	}

	public Packages getPack() {
		return pack;
	}

	public void setPack(Packages pack) {
		this.pack = pack;
	}

	@Override
	public String toString() {
		return "RentalTransport [rentalTransportID=" + rentalTransportID + ", vehicleProvider=" + vehicleProvider
				+ ", pack=" + pack + "]";
	}

}
