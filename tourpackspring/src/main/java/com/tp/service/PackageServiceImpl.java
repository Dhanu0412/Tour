package com.tp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tp.dao.PackageDao;
import com.tp.entity.Package;

@Service
@Transactional
public class PackageServiceImpl implements PackageService{
	
	@Autowired
	PackageDao packDao;

	@Override
	public void createPackage(Package pack) {
		// TODO Auto-generated method stub
		
		packDao.createPackage(pack);
		
	}

	@Override
	public List<Package> getAllPackages() {
		// TODO Auto-generated method stub
		return packDao.getAllPackages();
	}

	@Override
	public Package getPackage(Package pack) {
		// TODO Auto-generated method stub
		return packDao.getPackage(pack);
	}

	@Override
	public List<Package> updatePackage(Package pack) {
		// TODO Auto-generated method stub
		return packDao.updatePackage(pack);
	}

	@Override
	public List<Package> deletePackage(int pno) {
		// TODO Auto-generated method stub
		return packDao.deletePackage(pno);
	}

	@Override
	public List<Package> getPackageById(int pid) {
		// TODO Auto-generated method stub
		return packDao.getPackageById(pid);
	}

}
