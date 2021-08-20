package com.tp.service;

import java.util.List;

import com.tp.entity.RentalTransport;

public interface RentalTransportService {
	
	public void createRentalTransport(RentalTransport rentalTransport);
	public List<RentalTransport> getAllRentalTransport();
//	public RentalTransport getRentalTransport(RentalTransport rentalTransport);
	public List<RentalTransport> updateRentalTransport(RentalTransport rentalTransport);
	public List<RentalTransport> deleteRentalTransport(int rtno);
	
	public RentalTransport getRentalTransportById(int rtid);

}
