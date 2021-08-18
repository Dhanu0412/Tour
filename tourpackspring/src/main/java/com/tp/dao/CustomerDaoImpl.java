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

@Repository
public class CustomerDaoImpl implements CustomerDao{


	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(customer);
		System.out.println("Customer has been stored successfully in DB !");
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("from Customer cus");
		List<Customer> cuslist = query.list();
		System.out.println(cuslist);
		return cuslist; 
	}

	@Override
	public Customer getCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Criteria c = getSession().createCriteria(Customer.class);
		c.add(Restrictions.eq("email", customer.getEmail()));
		c.add(Restrictions.eq("password", customer.getPassword()));
		Customer cus = (Customer)c.uniqueResult();
		System.out.println("Customer Retrieved : " + cus);
		return cus;
	}

	@Override
	public List<Customer> updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("update Customer cus set username=:username,gender=:gender,email=:email,password=:password where eid=:eno");
		query.setParameter("fname", customer.getUsername());
		//query.setParameter("lname", customer.getLname());
		query.setParameter("gender", customer.getGender());
		query.setParameter("email", customer.getEmail());
		query.setParameter("password", customer.getPassword());
//		query.setParameter("cno", customer.getCid());
		int noofrows = query.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Updated " + noofrows + " rows");
		}
		
		return getAllCustomers();
	}

	@Override
	public List<Customer> deleteCustomer(int cno) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("delete from Customer cus where cid=:cno");
		query.setParameter("eno", cno);
		int noofrows = query.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Deleted " + noofrows + " rows");
		}
		
		return getAllCustomers();
	}

	@Override
	public List<Customer> getCustomerById(int cid) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("from Customer cus where cid=:cno");
		query.setParameter("eno", cid);
		List <Customer> cuslist = query.list();
		System.out.println(cuslist);
		return cuslist; 
	}
	
}
