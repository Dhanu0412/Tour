package com.tp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tp.dao.PackageBookingDao;
import com.tp.entity.PackageBooking;

@Service
@Transactional
public class PackageBookingServiceImpl implements PackageBookingService{
	
	@Autowired
	PackageBookingDao packBookingDao;
	
	@Override
	public void createPackageBooking(PackageBooking packBook) {
		
		packBookingDao.createPackageBooking(packBook);
		
	}

	@Override
	public List<PackageBooking> getAllPackageBookings() {
		
		return packBookingDao.getAllPackageBookings();
	}

	@Override
	public List<PackageBooking> updatePackageBooking(PackageBooking packBook) {
		
		return packBookingDao.updatePackageBooking(packBook);
	}

	@Override
	public List<PackageBooking> deletePackageBooking(int pbno) {
		
		return packBookingDao.deletePackageBooking(pbno);
	}

	@Override
	public PackageBooking getPackageBookingById(int pbid) {
		
		return packBookingDao.getPackageBookingById(pbid);
	}

	@Override
	public List<PackageBooking> getPackageBookingByCId(int cid) {
		
		return packBookingDao.getPackageBookingsByCId(cid);
	}
	
}
