package com.tp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tp.entity.Customer;
import com.tp.service.CustomerService;

@RestController
@RequestMapping(value = "/customer")
public class CustomerRestController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/allCus")
	public ResponseEntity<List<Customer>> allCustomer() {
		
		List<Customer> emplist = customerService.getAllCustomers();
		System.out.println("From Rest allemp : " + emplist);
		
		if(emplist.isEmpty()) {
			
			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Customer>>(emplist,HttpStatus.OK);		
	}
}
