package com.motionpoint.components;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Henry Artime
 *
 */
public class Room {
	/**
	 * transaction id.
	 */
	private UUID id;
	/**
	 * type of room.
	 */
	private RoomTypes type;
	/**
	 * room price.
	 */
	private BigDecimal price;
	/**
	 * reservation date.
	 */
	private LocalDateTime date_time;
	/**
	 * collection of total rooms for all types of vacations.
	 */
	private static Set<Room> rooms = new HashSet<>();

	static {
		rooms.add(new Room(RoomTypes.Economy, new BigDecimal("89.99"), LocalDateTime.of(2020, 4, 10, 12, 0)));
		rooms.add(new Room(RoomTypes.Economy, new BigDecimal("99.99"), LocalDateTime.of(2020, 4, 10, 12, 0)));
		rooms.add(new Room(RoomTypes.Standard, new BigDecimal("120.99"), LocalDateTime.of(2020, 4, 10, 12, 0)));
		rooms.add(new Room(RoomTypes.Standard, new BigDecimal("135.99"), LocalDateTime.of(2020, 4, 10, 12, 0)));
		rooms.add(new Room(RoomTypes.Luxury, new BigDecimal("400.99"), LocalDateTime.of(2020, 4, 10, 12, 0)));
		rooms.add(new Room(RoomTypes.Luxury, new BigDecimal("400.99"), LocalDateTime.of(2020, 4, 10, 12, 0)));

	}

	// ensure each room has an ID at instantiation
	public Room() {
		setId(UUID.randomUUID());
	}

	public Room(RoomTypes type, BigDecimal price, LocalDateTime checkInDate) {
		setId(UUID.randomUUID());
		setType(type);
		setPrice(price);
		setCheckInDate(checkInDate);
	}

	/**
	 *
	 * @param price_low
	 * @param price_high
	 * @return
	 */
	public Set<Room> getAvailableRooms(BigDecimal price_low, BigDecimal price_high)

	{
		/*
		 * NOTE: Decided to use multiple filter() methods because combining the
		 * predicates was causing me problems...!
		 */

		Predicate<Room> roomType = (p -> p.type == this.type);
		Predicate<Room> checkInAvailable = (p -> p.date_time.isEqual(this.date_time));
		Predicate<Room> priceLow1 = (p -> p.price.compareTo(price_low) == 0);
		Predicate<Room> priceLow2 = (p -> p.price.compareTo(price_low) > 0);
		Predicate<Room> priceHigh1 = (p -> p.price.compareTo(price_high) == 0);
		Predicate<Room> priceHigh2 = (p -> p.price.compareTo(price_high) < 0);

		Set<Room> filtered = rooms.stream().filter(roomType).filter(checkInAvailable).filter(priceLow1.or(priceLow2))
				.filter(priceHigh1.or(priceHigh2)).collect(Collectors.toSet());

		return filtered;
	}

	/**
	 *
	 * @return type of room
	 */
	public RoomTypes getType() {
		return type;
	}

	/**
	 * @ param set
	 */

	private void setType(RoomTypes type) {
		this.type = type;
	}

	/**
	 *
	 * @return price of room
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @ param price
	 */
	private void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * @ param checkin
	 */
	private void setCheckInDate(LocalDateTime checkin) {
		this.date_time = checkin;
	}

	public UUID getId() {
		return id;
	}

	private void setId(UUID id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", type=" + type + ", price=" + price + "]";
	}
}
