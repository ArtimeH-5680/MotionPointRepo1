/**
 *
 */
package com.motionpoint.builder.impl;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.motionpoint.builders.VacationBuilder;
import com.motionpoint.components.Payment;
import com.motionpoint.components.Reservation;
import com.motionpoint.components.Room;
import com.motionpoint.components.Vacation;
import com.motionpoint.components.VacationTypes;

/**
 * @author Henry Artime -
 *
 */
public class VacationsBuilder implements VacationBuilder {
	public static final Logger logger = LogManager.getLogger("VacationsBuilder");
	/*
	 * Type of vacation
	 */
	public VacationTypes vacation;
	/*
	 * number of persons attending
	 */
	public int persons;
	/*
	 * number of rooms or cabins to reserve
	 */

	public int nums;
	/*
	 * Reference to Payment Object to facilitate Booking
	 */
	public Payment pay;
	/*
	 * collection of available rooms that satisfy price , reserve date
	 */
	public Set<Room> rooms;
	/*
	 * reference to reservation object
	 */
	public Reservation res;

	public Vacation build() {
		if (logger.isDebugEnabled()) {
			logger.debug("*** VACATION =   " + this.toString());
		}
		return new Vacation(persons, nums, vacation, res, rooms, pay);
	}

	/*
	 * @see
	 * com.motionpoint.builders.VacationBuilder#setVacationType(com.motionpoint.
	 * components.VacationTypes)
	 */
	@Override
	public void setVacationType(VacationTypes vacation) {
		this.vacation = vacation;
	}

	/*
	 * @see com.motionpoint.builders.VacationBuilder#setNumberOfPersons(int)
	 */
	@Override
	public void setNumberOfPersons(int persons) {
		this.persons = persons;

	}

	/*
	 * @see com.motionpoint.builders.VacationBuilder#setNumberOfRoomsOrCabins(int)
	 */
	@Override
	public void setNumberOfRoomsOrCabins(int nums) {
		this.nums = nums;

	}

	/*
	 * @see com.motionpoint.builders.VacationBuilder#setPayment(com.motionpoint.
	 * components.Payment)
	 */
	@Override
	public void setPayment(Payment pay) {
		this.pay = pay;
	}

	/*
	 * @see com.motionpoint.builders.VacationBuilder#setRooms(java.util.Set)
	 */
	@Override
	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

	/*
	 * @see com.motionpoint.builders.VacationBuilder#setReservation(com.motionpoint.
	 * components.Reservation)
	 */
	@Override
	public void setReservation(Reservation res) {
		this.res = res;
	}

	/*
	 * @see com.motionpoint.builders.VacationBuilder#getVacationType()
	 */
	@Override
	public VacationTypes getVacationType() {
		return vacation;
	}

	/*
	 * @see com.motionpoint.builders.VacationBuilder#getNumberOfRoomsOrCabins()
	 */
	@Override
	public int getNumberOfRoomsOrCabins() {
		// TODO Auto-generated method stub
		return nums;
	}

	/*
	 * @see com.motionpoint.builders.VacationBuilder#getNumberOfPersons()
	 */
	@Override
	public int getNumberOfPersons() {
		return persons;
	}

	/*
	 * @see com.motionpoint.builders.VacationBuilder#getPayment()
	 */
	@Override
	public Payment getPayment() {

		return pay;
	}

	/*
	 * @see com.motionpoint.builders.VacationBuilder#getRooms()
	 */
	@Override
	public Set<Room> getRooms() {
		return rooms;
	}

	/*
	 * @see com.motionpoint.builders.VacationBuilder#getReservation()
	 */
	@Override
	public Reservation getReservation() {
		return res;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "VacationsBuilder [vacation=" + vacation + ", persons=" + persons + ", nums=" + nums + ", pay=" + pay
				+ ", rooms=" + rooms + ", res=" + res + "]";
	}
}
