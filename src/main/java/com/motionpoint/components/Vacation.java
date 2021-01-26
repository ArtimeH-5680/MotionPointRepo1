/**
 *
 */
package com.motionpoint.components;

import java.util.Set;

/**
 * @author Henry Artime
 *
 */
public class Vacation {
	/**
	 * number of rooms to reserve.
	 */
	private int numerOfPersons;
	/**
	 * number of persons attending this vacation.
	 */
	private int numberOfRoomsOrCabins;
	/**
	 * type of vacation.
	 */
	private VacationTypes type;
	/**
	 * reservation dates.
	 */
	private Reservation reservation;
	/**
	 * available rooms.
	 */
	private Set<Room> rooms;
	/**
	 * payment processor.
	 */
	private Payment pay;

	public Vacation(int numerOfPersons, int numberOfRoomsOrCabins, VacationTypes type, Reservation reservation,
			Set<Room> rooms, Payment pay) {
		super();
		this.numerOfPersons = numerOfPersons;
		this.numberOfRoomsOrCabins = numberOfRoomsOrCabins;
		this.type = type;
		this.reservation = reservation;
		this.rooms = rooms;
		this.pay = pay;
	}

	/**
	 * @return the numerOfPersons
	 */
	public int getNumerOfPersons() {
		return numerOfPersons;
	}

	/**
	 * @param numerOfPersons
	 *            the numerOfPersons to set
	 */
	public void setNumerOfPersons(int numerOfPersons) {
		this.numerOfPersons = numerOfPersons;
	}

	/**
	 * @return the numberOfRoomsOrCabins
	 */
	public int getNumberOfRoomsOrCabins() {
		return numberOfRoomsOrCabins;
	}

	/**
	 * @param numberOfRoomsOrCabins
	 *            the numberOfRoomsOrCabins to set
	 */
	public void setNumberOfRoomsOrCabins(int numberOfRoomsOrCabins) {
		this.numberOfRoomsOrCabins = numberOfRoomsOrCabins;
	}

	/**
	 * @return the type
	 */
	public VacationTypes getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(VacationTypes type) {
		this.type = type;
	}

	/**
	 * @return the reservation
	 */
	public Reservation getReservation() {
		return reservation;
	}

	/**
	 * @param reservation
	 *            the reservation to set
	 */
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	/**
	 * @return the rooms
	 */
	public Set<Room> getRooms() {
		return rooms;
	}

	/**
	 * @param rooms
	 *            the rooms to set
	 */
	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

	/**
	 * @return the pay
	 */
	public Payment getPay() {
		return pay;
	}

	/**
	 * @param pay
	 *            the pay to set
	 */
	public void setPay(Payment pay) {
		this.pay = pay;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vacation [numerOfPersons=" + numerOfPersons + ", numberOfRoomsOrCabins=" + numberOfRoomsOrCabins
				+ ", type=" + type + ", reservation=" + reservation + ", rooms=" + rooms + ", pay=" + pay + "]";
	}

}
