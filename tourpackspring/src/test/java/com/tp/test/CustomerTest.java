package com.tp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tp.dao.CustomerDao;


/**
 * The Class CustomerTest.
 * @author Bharath
 */
public class CustomerTest {

	/** The customer dao. */
	static CustomerDao customerDao;
	
	/**
	 * Setup.
	 */
	@BeforeClass
	public static void setup() {
		System.out.println("Before class");
		ApplicationContext context = new ClassPathXmlApplicationContext("dispserv-servlet.xml");
		customerDao = (CustomerDao) context.getBean("customerDao");
	}
	
	/**
	 * Gets the customer list.
	 *
	 * @return the customer list
	 */
	@Test
	public void testGetAllCustomers() {

		assertTrue((customerDao.getAllCustomers()).size() >= 1);
	}
	
	/**
	 * Test get customer.
	 */
	@Test
	public void testGetCustomer() {
		
		String email = "bharath@gmail.com";
		assertEquals(customerDao.getCustomer(email).getCustomerName().getFname(), "Bharath");
	}
	
}
