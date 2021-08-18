package com.tp.service;

import java.util.List;

import com.tp.entity.Package;

public interface PackageService {
	public void createPackage(Package pack);

	public List<Package> getAllPackages();

	public Package getPackage(Package pack);

	public List<Package> updatePackage(Package employee);

	public List<Package> deletePackage(int pno);

	public List<Package> getPackageById(int pid);
}

