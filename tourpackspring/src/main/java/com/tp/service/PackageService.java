package com.tp.service;

import java.util.List;

import com.tp.entity.Packages;

public interface PackageService {

	public void createPackage(Packages pack);
	public List<Packages> getAllPackages();
	public List<Packages> updatePackage(Packages pack);
	public List<Packages> deletePackage(int pno);
	
	public Packages getPackageById(int pid);
}
