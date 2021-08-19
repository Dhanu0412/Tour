package com.tp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tp.entity.PackageBooking;

import com.tp.service.PackageBookingService;

@RestController
@RequestMapping(value = "/packageBooking")
public class PackageBookingRestController {
	@Autowired
	PackageBookingService packageBookingService;
	
	@GetMapping("/allPackBooking")
	public ResponseEntity<List<PackageBooking>> allPackageBookings() {
		
		List<PackageBooking> packbookinglist = packageBookingService.getAllPackageBooking();
		System.out.println("From Rest allpackBooking : " + packbookinglist);
		
		if(packbookinglist.isEmpty()) {
			
			return new ResponseEntity<List<PackageBooking>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<PackageBooking>>(packbookinglist,HttpStatus.OK);		
	}
	
	@PostMapping("/createPackBooking")
	public PackageBooking createPackage(@RequestBody PackageBooking packBooking) {
		packageBookingService.createPackageBooking(packBooking);
		return packBooking;
	}
	
	@PutMapping("/updatePackBooking")
	public ResponseEntity<List<PackageBooking>> updatePackageBooking(@RequestBody PackageBooking packBooking) {
		
		List<PackageBooking> packBookinglist = packageBookingService.updatePackageBooking(packBooking);
		System.out.println("From Rest update packBooking : " + packBookinglist);
		
		if(packBookinglist.isEmpty()) {
			
			return new ResponseEntity<List<PackageBooking>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<PackageBooking>>(packBookinglist,HttpStatus.OK);		
	}
	
	@DeleteMapping("/deletePackBooking/{id}")
	public ResponseEntity<List<PackageBooking>> deletePackageBooking(@PathVariable("id") int pbid) {
		
		List<PackageBooking> packBookinglist = packageBookingService.deletePackageBooking(pbid);
		System.out.println("From Rest update packBooking : " + packBookinglist);
		
		if(packBookinglist.isEmpty()) {
			
			return new ResponseEntity<List<PackageBooking>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<PackageBooking>>(packBookinglist,HttpStatus.OK);		
	}
	
	@GetMapping("/getPackBookingAdmin/{id}")
	public ResponseEntity<PackageBooking> getPackageBookingById(@PathVariable("id") int pbid) {
		
		PackageBooking packBooking = packageBookingService.getPackageBookingById(pbid);
		System.out.println("From Rest update packBooking : " + packBooking);
		
		if(packBooking == null) {
			
			return new ResponseEntity<PackageBooking>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<PackageBooking>(packBooking,HttpStatus.OK);		
	}
	
	@GetMapping("/getPackBookingCustomer/{id}")
	public ResponseEntity<PackageBooking> getPackageBookingByCId(@PathVariable("id") int cid) {
		
		PackageBooking packBooking = packageBookingService.getPackageBookingByCId(cid);
		System.out.println("From Rest update packBooking : " + packBooking);
		
		if(packBooking == null) {
			
			return new ResponseEntity<PackageBooking>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<PackageBooking>(packBooking,HttpStatus.OK);		
	}
	
	
}