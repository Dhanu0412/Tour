package com.tp.dao;

import java.util.List;

import com.tp.entity.Package;

public interface PackageDao {
	
	public void createPackage(Package pack);
	public List<Package> getAllPackages();
	public Package getPackage(Package pack);
	public List<Package> updatePackage(Package pack);
	public List<Package> deletePackage(int pno);
	
	public List<Package> getPackageById(int pid);

}
