package com.tp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.tp.entity.RentalTransport;

@Repository
public class RentalTransportDaoImpl implements RentalTransportDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}

	
	@Override
	public void createRentalTransport(com.tp.entity.RentalTransport rentalTransport) {

		getSession().saveOrUpdate(rentalTransport);
		System.out.println("RentalTransport has been stored successfully in DB !");
	}

	
	@Override
	public List<RentalTransport> getAllRentalTransport() {

		Query query = getSession().createQuery("from RentalTransport rentalTransport");
		List<RentalTransport> rentalTransportlist = query.list();
		System.out.println(rentalTransportlist);
		return rentalTransportlist;
	}

	@Override
	public List<com.tp.entity.RentalTransport> updateRentalTransport(com.tp.entity.RentalTransport rentalTransport) {

		getSession().saveOrUpdate(rentalTransport);
		System.out.println("RentalTransport has been updated successfully in DB !");
		return getAllRentalTransport();
	}

	@Override
	public List<com.tp.entity.RentalTransport> deleteRentalTransport(int rtno) {
		  
		Query query = getSession().createQuery("delete from RentalTransport rentalTransport where rentalTransportID=:rtno");
		query.setParameter("rtno", rtno);
		int noofrows = query.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Deleted " + noofrows + " rows");
		}
		return getAllRentalTransport();
	}

	@Override
	public com.tp.entity.RentalTransport getRentalTransportById(int rtid) {
		Criteria c = getSession().createCriteria(RentalTransport.class);
		c.add(Restrictions.eq("rentalTransportID", rtid));
		RentalTransport rentalTransport = (RentalTransport)c.uniqueResult();
		System.out.println(rentalTransport);
		return rentalTransport; 

	}

	

}
