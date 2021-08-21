package com.tp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tp.dao.PackageDao;

public class PackagesTest {

	static PackageDao packageDao;
	
	@BeforeClass
	public static void setup() {
		System.out.println("Before class");
		ApplicationContext context = new ClassPathXmlApplicationContext("dispserv-servlet.xml");
		packageDao = (PackageDao) context.getBean("packageDao");
	}
	
	@Test
	public void testGetAllPackagess() {

		assertTrue((packageDao.getAllPackages()).size() >= 1);
	}
	
	@Test
	public void testGetPackage() {
		
		int id = 1;
		assertEquals(packageDao.getPackageById(id).getPackageName(),"GoGoaGone");
	}
	
}
