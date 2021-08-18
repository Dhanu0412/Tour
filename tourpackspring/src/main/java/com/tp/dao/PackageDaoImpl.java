package com.tp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tp.entity.Customer;
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
		getSession().saveOrUpdate(pack);
		System.out.println("Package has been stored successfully in DB !");
		
	}

	@Override
	public List<Package> getAllPackages() {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("from Package pack");
		List<Package> packlist = query.list();
		System.out.println(packlist);
		return packlist; 
	}

	@Override
	public Package getPackage(Package pack) {
		// TODO Auto-generated method stub
		Criteria c = getSession().createCriteria(Package.class);
		c.add(Restrictions.eq("packagename", pack.getPackageName()));
		c.add(Restrictions.eq("location", pack.getLocation()));
		Package p = (Package)c.uniqueResult();
		System.out.println("Package Retrieved : " + p);
		return p;
	}

	@Override
	public List<Package> updatePackage(Package pack) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("update Package pack set packagename=:packagename,itenary=:itenary,email=:email,password=:password where eid=:eno");
		query.setParameter("packagename", pack.getPackageName());
		query.setParameter("itenary", pack.getItenary());
		query.setParameter("location", pack.getLocation());
		query.setParameter("hotelname", pack.getHotelName());
		query.setParameter("hotelcostperDay", pack.getHotelCostPerDay());
		query.setParameter("costperday", pack.getCostPerDay());
		query.setParameter("rentaltransport", pack.getRentalTransport());
		query.setParameter("packagebooking", pack.getPackageBooking());
		int noofrows = query.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Updated " + noofrows + " rows");
		}
		
		return getAllPackages();
	}

	@Override
	public List<Package> deletePackage(int pno) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("delete from Package pack where pid=:pno");
		query.setParameter("pno", pno);
		int noofrows = query.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Deleted " + noofrows + " rows");
		}
		
		return getAllPackages();
	}

	@Override
	public Package getPackageById(int pid) {
		// TODO Auto-generated method stub
		Criteria c = getSession().createCriteria(Package.class);
		c.add(Restrictions.eq("packageid", pid));
		Package packlist = (Package)c.uniqueResult();
		System.out.println(packlist);
		return packlist; 
	}

}
