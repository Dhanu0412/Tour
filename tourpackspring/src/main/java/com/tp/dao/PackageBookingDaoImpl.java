package com.tp.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tp.entity.PackageBooking;

@Repository
@Transactional
public class PackageBookingDaoImpl implements PackageBookingDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void createPackageBooking(PackageBooking packBooking) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		Date DiscountStartDate = new Date();
		try {
			DiscountStartDate = formatter.parse("25-08-2021");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		Date DiscountEndDate = new Date();
		try {
			DiscountEndDate = formatter.parse("27-08-2021");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		double discount = 0.10;
		if(((packBooking.getBookingDate()).after(DiscountStartDate))&&((packBooking.getBookingDate()).before(DiscountEndDate))) {
		packBooking.setPackageCost((((packBooking.getPack().getCostPerDay() + packBooking.getPack().getHotelCostPerDay())
				* packBooking.getNoOfPeope() + packBooking.getRentTransport().getChargesPerDay())
				* packBooking.getNoOfDays())*(1-discount));
		}
		else {
			packBooking.setPackageCost(((packBooking.getPack().getCostPerDay() + packBooking.getPack().getHotelCostPerDay())
					* packBooking.getNoOfPeope() + packBooking.getRentTransport().getChargesPerDay())
					* packBooking.getNoOfDays());
		}
		getSession().saveOrUpdate(packBooking);
		System.out.println("PackageBooking has been stored successfully in DB !");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PackageBooking> getAllPackageBookings() {

		Query query = getSession().createQuery("from PackageBooking packBooking");
		List<PackageBooking> packBookinglist = query.list();
		System.out.println(packBookinglist);
		return packBookinglist;
	}

	@Override
	public List<PackageBooking> updatePackageBooking(PackageBooking packBooking) {

		packBooking.setPackageCost(((packBooking.getPack().getCostPerDay() + packBooking.getPack().getHotelCostPerDay())
				* packBooking.getNoOfPeope() + packBooking.getRentTransport().getChargesPerDay())
				* packBooking.getNoOfDays());
		getSession().saveOrUpdate(packBooking);
		System.out.println("Package has been updated successfully in DB !");
		return getAllPackageBookings();
	}

	@Override
	public List<PackageBooking> deletePackageBooking(int pbno) {

		Query query = getSession().createQuery("delete from PackageBooking packBooking where packBookID=:pbno");
		query.setParameter("pbno", pbno);
		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Deleted " + noofrows + " rows");
		}
		return getAllPackageBookings();
	}

	@Override
	public PackageBooking getPackageBookingById(int pbid) {

		Criteria c = getSession().createCriteria(PackageBooking.class);
		c.add(Restrictions.eq("packBookID", pbid));
		PackageBooking packBooking = (PackageBooking) c.uniqueResult();
		System.out.println(packBooking);
		return packBooking;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PackageBooking> getPackageBookingsByCId(int cid) {

		Query query = getSession().createQuery("from PackageBooking packBooking where customerid=:cid");
		query.setParameter("cid", cid);
		List<PackageBooking> packBookinglist = query.list();
		System.out.println(packBookinglist);
		return packBookinglist;
	}

}
