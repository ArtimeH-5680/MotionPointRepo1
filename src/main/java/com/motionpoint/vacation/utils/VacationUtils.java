/**
 *
 */
package com.motionpoint.vacation.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.motionpoint.components.Reservation;
import com.motionpoint.components.Room;

/**
 * @author Henry Artime
 *
 *         NOTE : this class must be visible / accessible by all packages in the
 *         project. This a class containing utility methods for ALL packages in
 *         this project.
 *
 */
public class VacationUtils {
	private static final Logger logger = LogManager.getLogger("VacationUtils");

	/*
	 * @ param reservation and room collection
	 *
	 * @ return amount to pay
	 */
	public static BigDecimal calculatePaymentAmount(Reservation res, Set<Room> rooms) {

		final LocalDate checkIn;
		final LocalDate checkOut;
		final Period intervalPeriod;
		BigDecimal work = new BigDecimal(BigInteger.ZERO, 2);
		BigDecimal totalAmount = new BigDecimal(BigInteger.ZERO, 2);

		checkIn = res.getCheckInDate().toLocalDate();
		checkOut = res.getCheckOutDate().toLocalDate();

		if (logger.isDebugEnabled()) {
			logger.debug("INTERVAL NUMBER OF DAYS :" + "checkin date= " + checkIn.toString() + "checkout date= "
					+ checkOut.toString());
		}
		intervalPeriod = Period.between(checkIn, checkOut);
		BigDecimal days = new BigDecimal(intervalPeriod.getDays());

		if (logger.isDebugEnabled()) {
			logger.debug("INTERVAL NUMBER OF DAYS = " + days.toString());
		}

		for (Room r : rooms) {
			work = r.getPrice().multiply(days);
			totalAmount = totalAmount.add(work);

		}
		return totalAmount;
	}
}
