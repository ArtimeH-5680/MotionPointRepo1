/**
 *
 */
package com.motionpoint.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import com.motionpoint.agents.TravelAgent;
import com.motionpoint.builder.impl.VacationsBuilder;
import com.motionpoint.components.Payment;
import com.motionpoint.components.Vacation;

/**
 * @author Henry
 *
 *         TEST THE BUILDER AND MAKE A PAYMENT
 */
public class ClientTest {
	private static final Logger logger = LogManager.getLogger("ClientTest");

	public ClientTest() {
	}

	@Test
	public void testBuilderAndMakePayment() {

		TravelAgent agent = new TravelAgent();

		VacationsBuilder builder = new VacationsBuilder();

		try {

			agent.ceateBookingLuxuryCasinoResortVisaCard(builder);

		} catch (Exception e) {
			logger.error("*** EXCEPTION DURING VACATION BUILD: ", e);
		}

		Vacation vacation = builder.build();
		Payment payment = vacation.getPay();

		logger.debug("AVAILABLE ROOMS FOR THIS BOOKING = " + String.valueOf(vacation.getNumberOfRoomsOrCabins()));
		assertFalse(vacation.getRooms().isEmpty());

		logger.debug("ROOMS = " + vacation.getRooms().toString());

		logger.debug("TOTAL AMOUNT FOR BOOKING: " + payment.getAmount().toString());

		// check total amount of booking is correct!

		assertEquals(0, payment.getAmount().compareTo(new BigDecimal("5613.86")));

		/* Try an Asynchronous payment **/
		logger.debug("INVOKING ASYNCHRONOUS PAYMENT");
		try {
			int status = payment.payAsync(payment.getCard());

			assertTrue(status >= 0 && status <= 6);

			logger.debug(" PAYMENT STATUS = " + String.valueOf(status));

			logger.debug("INVOKING SYNCHRONOUS PAYMENT");

			int status2 = payment.payNow();

			assertTrue(status >= 0 && status <= 6);

			logger.debug(" SYNCHRONOUS PAYMENT STATUS = " + String.valueOf(status2));

		} catch (Exception e) {
			logger.error("*** EXCEPTION DURING PAYMENT: ", e);
			e.printStackTrace();
		}

	}

}
