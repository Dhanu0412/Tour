package com.tp.tourpackhiber;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();	
		session.beginTransaction();
		
		FourWheeler fourWheeler = new FourWheeler();
		Package pack = new Package();
		Customer customer = new Customer();
		PackageBooking packageBooking = new PackageBooking();
//		Payment payment = new Payment();
//		ModeOfTransport modeOfTransport = new ModeOfTransport();
//		TransportBooking transportBooking = new TransportBooking();
		
		List<PackageBooking> pBook = new ArrayList<PackageBooking>();
		
		customer.setCustomerName(new Name("Thomas","Cat"));
		customer.setAddress(new Address(58, "Tom and Jerry","NewYork",10001,customer));
		customer.setGender("Male");
		customer.setEmail("tom_jerry@gmail.com");
		customer.setPhone(99999945);
		customer.setDateOfBirth(formatter.parse("18/08/1940"));
		customer.setUsername("Tom_the_Cat");
		customer.setPassword("Pussy123");
		customer.setPackageBooking(pBook);
		
		fourWheeler.setVehicleProvider("Honda");
		fourWheeler.setNoOfSeats(4);
		fourWheeler.setChargesPerDay(200);
		fourWheeler.setPack(pack);
		
		pack.setPackageName("GoGoaGone");
		pack.setLocation("Goa");
		pack.setItenary("1. Travel to Beach. 2. Drink 3.Get Sloshed 4. Repeat");
		pack.setHotelName("Goa Paradise");
		pack.setHotelCostPerDay(200.00);
		pack.setCostPerDay(1000);
		pack.setRentalTransport(fourWheeler);
		pack.setPackageBooking(pBook);
		
		packageBooking.setNoOfDays(3);
		packageBooking.setNoOfPeope(5);
		packageBooking.setPackageCost(pack.getCostPerDay()+pack.getHotelCostPerDay()+fourWheeler.getChargesPerDay());
		packageBooking.setStartDate(formatter.parse("18/08/2021"));
		packageBooking.setEndDate(formatter.parse("21/08/2021"));
		packageBooking.setPack(pack);
		packageBooking.setCustomer(customer);
		
		pBook.add(packageBooking);
		
//		payment.setPackageBooking(packageBooking);
//		payment.setPaymentDate(formatter.parse("17/08/2021"));
//		payment.setPaymentMode("UPI");
//		payment.setPaymentStatus(true);
//		payment.setRefundStatus(false);
		
//		modeOfTransport.setModeName("Train");
//		modeOfTransport.setChargesPerKm(2);
//		modeOfTransport.setTransportBooking(transportBooking);
//		
//		transportBooking.setDistance(560.0);
//		transportBooking.setTransportCost(6720.0);
//		transportBooking.setNoOfPeople(3);
//		transportBooking.setStartLocation("Bangalore");
//		transportBooking.setEndLocation("Goa");
//		transportBooking.setTwoWay(true);
//		transportBooking.setOnwardDate(formatter.parse("17/08/2021"));
//		transportBooking.setReturnDate(formatter.parse("22/08/2021"));
//		transportBooking.setModeOfTransport(modeOfTransport);
		
		session.save(customer);
		session.save(pack);
		session.save(packageBooking);
//		session.save(payment);
//		session.save(modeOfTransport);
//		session.save(transportBooking);
		
		session.getTransaction().commit();
		System.out.println("Txn completed.");
	}

}
