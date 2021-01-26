package com.motionpoint.agents;
/**
 * Author Henry Artime
 */

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

import com.motionpoint.builders.VacationBuilder;
import com.motionpoint.components.Card;
import com.motionpoint.components.CardTypes;
import com.motionpoint.components.Payment;
import com.motionpoint.components.Reservation;
import com.motionpoint.components.Room;
import com.motionpoint.components.RoomTypes;
import com.motionpoint.components.VacationTypes;
import com.motionpoint.exceptions.NoAvailableRoomsException;
import com.motionpoint.vacation.utils.VacationUtils;

public class TravelAgent {

	public void ceateBookingLuxuryCasinoResortVisaCard(VacationBuilder builder) throws Exception {

		builder.setVacationType(VacationTypes.Casino_Resort);
		builder.setNumberOfPersons(2);
		builder.setNumberOfRoomsOrCabins(2);

		Room rooms = new Room(RoomTypes.Luxury, new BigDecimal("400.99"), LocalDateTime.of(2020, 4, 10, 12, 0));
		Set<Room> availableRooms = rooms.getAvailableRooms(new BigDecimal("300.00"), new BigDecimal("450.99"));

		if (availableRooms.isEmpty() || availableRooms == null
				|| builder.getNumberOfRoomsOrCabins() < availableRooms.size()) {
			throw new NoAvailableRoomsException(
					"Booking cannot be completed: room not available-try changing price or check in date");
		}
		builder.setRooms(availableRooms);

		Card card = new Card(CardTypes.Visa, 4554999988881000L, "16-66 Bell Blvd, NY.", "Henry", "Jones", 11361,
				LocalDate.of(2022, 11, 1));

		ZoneId zone = ZoneId.of("America/New_York");

		Reservation res = new Reservation(ZonedDateTime.of(LocalDateTime.of(2020, 4, 10, 12, 0), zone),
				ZonedDateTime.of(LocalDateTime.of(2020, 4, 17, 20, 0), zone));

		builder.setReservation(res);

		BigDecimal amount = VacationUtils.calculatePaymentAmount(res, availableRooms);

		/**
		 * PAYMENT CAN BE INVOKED HERE....
		 */

		Payment pay = new Payment(card);
		pay.setAmount(amount);
		builder.setPayment(pay);
		/*
		 * PAYMENT WILL BE INVOKED IN ClientTest.java class file.
		 */
		return;

	}
}
