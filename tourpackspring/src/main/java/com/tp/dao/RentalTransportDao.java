package com.tp.dao;

import java.util.List;

import com.tp.entity.RentalTransport;

public interface RentalTransportDao {
	

	public void createRentalTransport(RentalTransport rentalTransport);
	public List<RentalTransport> getAllRentalTransport();
	public List<RentalTransport> updateRentalTransport(RentalTransport pack);
	public List<RentalTransport> deleteRentalTransport(int rtno);
	
	public RentalTransport getRentalTransportById(int rtid);
	


}
