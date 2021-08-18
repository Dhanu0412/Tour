package com.tp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tp.entity.Package;

@Repository
public class PackageDaoImpl implements PackageDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void createPackage(Package pack) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Package> getAllPackages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Package getPackage(Package pack) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Package> updatePackage(Package pack) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Package> deletePackage(int pno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Package> getPackageById(int pid) {
		// TODO Auto-generated method stub
		return null;
	}

}
