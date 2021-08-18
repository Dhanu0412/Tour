package com.tp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tp.entity.Packages;

@Repository
public class PackageDaoImpl implements PackageDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void createPackage(Packages pack) {
		
		getSession().saveOrUpdate(pack);
		System.out.println("Package has been stored successfully in DB !");
	}

	@Override
	public List<Packages> getAllPackages() {
		
		Query query = getSession().createQuery("from Package pack");
		List<Packages> packlist = query.list();
		System.out.println(packlist);
		return packlist;
	}

	@Override
	public Packages getPackage(Packages pack) {
		
		Criteria c = getSession().createCriteria(Packages.class);
		c.add(Restrictions.eq("packagename", pack.getPackageName()));
		c.add(Restrictions.eq("location", pack.getLocation()));
		Packages p = (Packages)c.uniqueResult();
		System.out.println("Package Retrieved : " + p);
		return p;
	}

	@Override
	public List<Packages> updatePackage(Packages pack) {
		getSession().saveOrUpdate(pack);
		System.out.println("Package has been updated successfully in DB !");
		
		return getAllPackages();
	}

	@Override
	public List<Packages> deletePackage(int pno) {
		
		Query query = getSession().createQuery("delete from Package pack where packageid=:pno");
		query.setParameter("pno", pno);
		int noofrows = query.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Deleted " + noofrows + " rows");
		}
		
		return getAllPackages();
	}

	@Override
	public Packages getPackageById(int pid) {
		
		Criteria c = getSession().createCriteria(Packages.class);
		c.add(Restrictions.eq("packageID", pid));
		Packages pack = (Packages)c.uniqueResult();
		System.out.println(pack);
		return pack; 
	}

}
