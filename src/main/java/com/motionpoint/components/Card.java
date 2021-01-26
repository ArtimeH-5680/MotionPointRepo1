package com.motionpoint.components;

import java.time.LocalDate;

/*
 * Author Henry Artime
 */
public class Card {
	/**
	 * card type.
	 */
	private CardTypes type;
	/**
	 * the card number.
	 */
	private long cardNumber;
	/**
	 * the single line address.
	 */
	private String address;
	/**
	 * card holder's zip code.
	 */
	private int zipCode;
	/**
	 * holder's first name.
	 */
	private String firstName;
	/**
	 * holders last name.
	 */
	private String lastName;
	/**
	 * expiration date MM/YY.
	 */
	private LocalDate expires;

	public Card(CardTypes type, long cardNumber, String address, String firstName, String lastName, int zipCode,
			LocalDate expires) {

		this.type = type;
		this.cardNumber = cardNumber;
		this.address = address;
		this.zipCode = zipCode;
		this.firstName = firstName;
		this.lastName = lastName;
		this.expires = expires;
	}

	/**
	 * @return the type
	 */
	public CardTypes getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	private void setType(CardTypes type) {
		this.type = type;
	}

	/**
	 * @return the cardNumber
	 */
	public double getCardNumber() {
		return cardNumber;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the zipCode
	 */
	public int getZipCode() {
		return zipCode;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Card [type=" + type + ", cardNumber=" + cardNumber + ", address=" + address + ", zipCode=" + zipCode
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", expires=" + expires + "]";
	}

}
