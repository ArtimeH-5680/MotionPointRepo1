package com.motionpoint.components;

public enum RoomTypes {
	/**
	 * room types available.
	 */
	Luxury(1), Standard(2), Economy(3);
	/**
	 * room type an integer.
	 */
	private final int code;

	RoomTypes(int code) {
		this.code = code;
	}

	public int getCode() {
		return this.code;
	}
}
