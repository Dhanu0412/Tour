package com.tp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tp.dao.PackageDao;
import com.tp.entity.PackageBooking;
import com.tp.entity.Packages;

@Service
@Transactional
public class PackageBookingServiceImpl implements PackageBookingService{
	
	@Autowired
	PackageBookingDao packBookingDao;
	
	@Override
	public void createPackageBooking(PackageBooking packBook) {
		// TODO Auto-generated method stub
		packBookingDao.createPackage(packBook);
		
	}

	@Override
	public List<PackageBooking> getAllPackageBooking() {
		// TODO Auto-generated method stub
		return packBookingDao.getAllPackageBooking();
	}

	@Override
	public PackageBooking getPackageBooking(PackageBooking packBook) {
		// TODO Auto-generated method stub
		return packBookingDao.getPackageBooking(packBook);
	}

	@Override
	public List<PackageBooking> updatePackageBooking(PackageBooking packBook) {
		// TODO Auto-generated method stub
		return packBookingDao.updatePackageBooking(packBook);
	}

	@Override
	public List<PackageBooking> deletePackageBooking(int pbno) {
		// TODO Auto-generated method stub
		return packBookingDao.deletePackage(pbno);
	}

	@Override
	public PackageBooking getPackageBookingById(int pbid) {
		// TODO Auto-generated method stub
		return packBookingDao.getPackageBookingById(pbid);
	}

	@Override
	public PackageBooking getPackageBookingByCId(int cid) {
		// TODO Auto-generated method stub
		return packBookingDao.getPackageBookingById(cid);
	}


}
