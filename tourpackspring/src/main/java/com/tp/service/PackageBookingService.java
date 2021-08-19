package com.tp.service;

import java.util.List;

import com.tp.entity.PackageBooking;

public interface PackageBookingService {
	
	public void createPackageBooking(PackageBooking packBook);
	public List<PackageBooking> getAllPackageBooking();
	public PackageBooking getPackageBooking(PackageBooking packBook);
	public List<PackageBooking> updatePackageBooking(PackageBooking packBook);
	public List<PackageBooking> deletePackageBooking(int pbno);
	
	public PackageBooking getPackageBookingById(int pbid);
	
	public PackageBooking getPackageBookingByCId(int cid);
}

