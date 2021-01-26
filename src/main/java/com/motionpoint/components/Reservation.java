package com.motionpoint.components;

import java.time.ZonedDateTime;

/**
 * @author Henry Artime
 *
 */
public class Reservation {
	/**
	 * check in date.
	 */
	private ZonedDateTime checkInDate;
	/**
	 * checkout date
	 */
	private ZonedDateTime checkOutDate;

	public Reservation(ZonedDateTime checkInDate, ZonedDateTime checkOutDate) {

		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
	}

	public Reservation() {
	};

	/**
	 * @return the checkInDate
	 */
	public ZonedDateTime getCheckInDate() {
		return checkInDate;
	}

	public ZonedDateTime getCheckOutDate() {
		return checkOutDate;
	}

	/**
	 * @param checkOutDate
	 *            the checkOutDate to set
	 */
	private void setCheckOutDate(ZonedDateTime checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "Reservation [checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + "]";
	}

}
