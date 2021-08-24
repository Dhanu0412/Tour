package com.tp.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tp.entity.FourWheeler;
import com.tp.entity.RentalTransport;
import com.tp.entity.TwoWheeler;
import com.tp.service.RentalTransportService;

/**
 * The Class PackageRestController.
 */
@CrossOrigin(origins="http://localhost:4200",methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping(value = "/rentalTransport")
public class RentalTransportRestController {
	
	/** The rental transport service. */
	@Autowired
	RentalTransportService rentalTransportService;
	
	/** The Constant logger. */
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger("RentalTransportRestController.class");
	
	/**
	 * Gets the rental transports.
	 * @author Dhanushya
	 * @return the rental transports
	 */
	@GetMapping("/allrentalTransport")
	public ResponseEntity<List<RentalTransport>> allRentalTransport() {
		
		List<RentalTransport> rentalTransportlist = rentalTransportService.getAllRentalTransport();
		System.out.println("From Rest allrentalTransport : " + rentalTransportlist);
		
		if(rentalTransportlist.isEmpty()) {
			
			return new ResponseEntity<List<RentalTransport>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<RentalTransport>>(rentalTransportlist,HttpStatus.OK);		
	}
	
	/**
	 * Creates the four wheeler rental transport.
	 *
	 * @param fourWheeler the four wheeler
	 * @return the four wheeler
	 */
	@PostMapping("/createFourWheeler")
	public RentalTransport createFourWheeler(@RequestBody FourWheeler fourWheeler) {
		rentalTransportService.createFourWheeler(fourWheeler);
		return fourWheeler;
	}
	
	/**
	 * Creates the two wheeler rental transport.
	 *
	 * @param twoWheeler the two wheeler
	 * @return the two wheeler
	 */
	@PostMapping("/createTwoWheeler")
	public RentalTransport createTwoWheeler(@RequestBody TwoWheeler twoWheeler) {
		rentalTransportService.createTwoWheeler(twoWheeler);
		return twoWheeler;
	}
	
	/**
	 * Update four wheeler rental transport.
	 * @author Dhanushya
	 * @param fourWheeler This param includes
	 *               the details of four wheeler
	 *               to be updated
	 * @return the response entity
	 */
	@PutMapping("/updateFourWheeler")
	public ResponseEntity<List<RentalTransport>> updateFourWheeler(@RequestBody FourWheeler rentalTransport) {
		
		List<RentalTransport> rentalTransportlist = rentalTransportService.updateFourWheeler(rentalTransport);
		System.out.println("From Rest update rentalTransport : " + rentalTransportlist);
		
		if(rentalTransportlist.isEmpty()) {
			
			return new ResponseEntity<List<RentalTransport>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<RentalTransport>>(rentalTransportlist,HttpStatus.OK);		
	}
	
	/**
	 * Update two wheeler rental transport.
	 * @author Dhanushya
	 * @param twoWheeler This param includes
	 *               the details of two wheeler
	 *               to be updated
	 * @return the response entity
	 */
	@PutMapping("/updateTwoWheeler")
	public ResponseEntity<List<RentalTransport>> updateTwoWheeler(@RequestBody TwoWheeler rentalTransport) {
		
		List<RentalTransport> rentalTransportlist = rentalTransportService.updateTwoWheeler(rentalTransport);
		System.out.println("From Rest update rentalTransport : " + rentalTransportlist);
		
		if(rentalTransportlist.isEmpty()) {
			
			return new ResponseEntity<List<RentalTransport>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<RentalTransport>>(rentalTransportlist,HttpStatus.OK);		
	}
	
	/**
	 * Delete rental transport.
	 * @author Dhanushya
	 * @param id  This param includes which
	 *             rental transport should be deleted
	 * @return the response entity
	 */
	@DeleteMapping("/deleteRentalTransport/{id}")
	public ResponseEntity<List<RentalTransport>> deleteRentalTransport(@PathVariable("id") int rtid) {
		
		List<RentalTransport> rentalTransportlist = rentalTransportService.deleteRentalTransport(rtid);
		System.out.println("From Rest update rentalTransport : " + rentalTransportlist);
		
		if(rentalTransportlist.isEmpty()) {
			
			return new ResponseEntity<List<RentalTransport>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<RentalTransport>>(rentalTransportlist,HttpStatus.OK);		
	}
	
	/**
	 * Gets the rental transports.
	 * @author Dhanushya
	 * @param id  This param includes 
	 *              the id of a rental transport
	 *                to retrive details
	 * @return the rental transports
	 */	
	@GetMapping("/getRentalTransport/{id}")
	public ResponseEntity<RentalTransport> getRentalTransport(@PathVariable("id") int rtid) {
		
		RentalTransport rentalTransport = rentalTransportService.getRentalTransportById(rtid);
		System.out.println("From Rest update rentalTransport : " +rentalTransport);
		
		if(rentalTransport == null) {
			
			return new ResponseEntity<RentalTransport>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<RentalTransport>(rentalTransport,HttpStatus.OK);		
	}
	
	/**
	 * Gets the rental transports based on range of the hotel charges per day.
	 * @author Dhanushya
	 * @param min  This param includes 
	 *              the minimum charge of the rental transport
	 *                to retrive details
	 * @param max  This param includes 
	 *              the maximum charge of the rental transport
	 *                to retrive details
	 * @return the rental transports
	 */
	@GetMapping("/sortRentTransCharges/{min}/{max}")
	public ResponseEntity<List<RentalTransport>> sortRentalTransportByCharges(@PathVariable("min") double min, @PathVariable("max") double max) {
		
		List<RentalTransport> rentalTransportlist = rentalTransportService.SortRentalTransportByCharges(min, max);
		System.out.println("From Rest sort rentTrans : " + rentalTransportlist);
		
		if(rentalTransportlist.isEmpty()) {
			
			return new ResponseEntity<List<RentalTransport>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<RentalTransport>>(rentalTransportlist,HttpStatus.OK);		
	}
	
}