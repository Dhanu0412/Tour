package com.tp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tp.dao.RentalTransportDao;
import com.tp.entity.RentalTransport;

public class RentalTransportServiceImpl implements RentalTransportService{
	
	@Autowired
	RentalTransportDao rentalTransportDao;

	@Override
	public void createRentalTransport(RentalTransport rentalTransport) {

		rentalTransportDao.createRentalTransport(rentalTransport);
		
	}

	@Override
	public List<RentalTransport> getAllRentalTransport() {
		
		return rentalTransportDao.getAllRentalTransport();
	}

	
	@Override
	public List<RentalTransport> updateRentalTransport(RentalTransport rentalTransport) {

		return rentalTransportDao.updateRentalTransport(rentalTransport);
	}

	@Override
	public List<RentalTransport> deleteRentalTransport(int rtno) {

		return rentalTransportDao.deleteRentalTransport(rtno);
	}

	@Override
	public RentalTransport getRentalTransportById(int rtid) {

		return rentalTransportDao.getRentalTransportById(rtid);
	}

}