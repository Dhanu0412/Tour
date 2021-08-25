package com.tp.dao;

import java.util.List;

import com.tp.entity.FourWheeler;
import com.tp.entity.RentalTransport;
import com.tp.entity.TwoWheeler;
/**
 * The Interface RentalTransportDao.
 * * @author Dhanushya
 */
public interface RentalTransportDao {
	/**
	 * Creates the fourwheeler.
	 * @author Dhanushya
	 * @param fourwheeler the fourwheeler
	 */
	public void createFourWheeler(FourWheeler fourWheeler);
	/**
	 * Creates the twowheeler.
	 * @author Dhanushya
	 * @param twowheeler the twowheeler
	 */
	public void createTwoWheeler(TwoWheeler twoWheeler);
	/**
	 * Gets the rentaltransport list.
	 * @author Dhanushya
	 * @return the rentaltransport list
	 */
	public List<RentalTransport> getAllRentalTransport();
	/**
	 * Update fourwheeler.
	 * @author Dhanushya
	 * @param fourwheeler This Param includes 
	 *                  the fourwheeler object
	 * @return the fourwheeler list
	 */
	public List<RentalTransport> updateFourWheeler(FourWheeler fourWheeler);
	/**
	 * Update twowheeler.
	 * @author Dhanushya
	 * @param twowheeler This Param includes 
	 *                  the twowheeler object
	 * @return the twowheeler list
	 */
	public List<RentalTransport> updateTwoWheeler(TwoWheeler twoWheeler);
	/**
	 * Delete rentaltransport.
	 * @author Dhanushya
	 * @param rtno This Param includes the
	 *           id of the rentaltransport to be deleted
	 * @return the rentaltransport list
	 */
	public List<RentalTransport> deleteRentalTransport(int rtno);
	
	/**
	 * Gets the rentaltransport.
	 * @author Dhanushya
	 * @param rtid This Param includes the
	 *           id of the rentaltransport object to be retreived
	 * @return the rentaltransport list
	 */
	public RentalTransport getRentalTransportById(int rtid);
	
	/**
	 * Gets the rentaltransport list.
	 * @author Dhanushya
	 * @param min,max This Param includes the
	 *           range of chargesperday of the rentaltransport object to be retreived
	 * @return the rentaltransport list
	 */
	public List<RentalTransport> SortRentalTransportByCharges(double min,double max);

}
