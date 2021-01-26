/**
 *
 */
package com.motionpoint.builders;

import java.util.Set;

import com.motionpoint.components.Payment;
import com.motionpoint.components.Reservation;
import com.motionpoint.components.Room;
import com.motionpoint.components.VacationTypes;

/**
 * @author Henry Artime Interface methods to build a Vacation instance
 */
public interface VacationBuilder {

	public void setVacationType(VacationTypes vacation);

	public void setNumberOfPersons(int persons);

	public void setNumberOfRoomsOrCabins(int nums);

	public void setPayment(Payment pay);

	public void setRooms(Set<Room> rooms);

	public void setReservation(Reservation res);

	public VacationTypes getVacationType();

	public int getNumberOfRoomsOrCabins();

	public int getNumberOfPersons();

	public Payment getPayment();

	public Set<Room> getRooms();

	public Reservation getReservation();

}
