package com.tp.tourpackhiber;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ModeOfTransport {

	@Id
	@GeneratedValue
	private int modeID;
	
	private String modeName;
	private double chargesPerKm;
	
//	private TransportBooking transportBooking;

	public ModeOfTransport() {
		super();
	}

	public ModeOfTransport(int modeID, String modeName, double chargesPerKm) {//, TransportBooking transportBooking) {
		super();
		this.modeID = modeID;
		this.modeName = modeName;
		this.chargesPerKm = chargesPerKm;
//		this.transportBooking = transportBooking;
	}

	public int getModeID() {
		return modeID;
	}

	public void setModeID(int modeID) {
		this.modeID = modeID;
	}

	public String getModeName() {
		return modeName;
	}

	public void setModeName(String modeName) {
		this.modeName = modeName;
	}

	public double getChargesPerKm() {
		return chargesPerKm;
	}

	public void setChargesPerKm(double chargesPerKm) {
		this.chargesPerKm = chargesPerKm;
	}

//	public TransportBooking getTransportBooking() {
//		return transportBooking;
//	}
//
//	public void setTransportBooking(TransportBooking transportBooking) {
//		this.transportBooking = transportBooking;
//	}

	@Override
	public String toString() {
		return "ModeOfTransport [modeID=" + modeID + ", modeName=" + modeName + ", chargesPerKm=" + chargesPerKm
				+ "]";// ", transportBooking=" + transportBooking + "]";
	}
	
}
