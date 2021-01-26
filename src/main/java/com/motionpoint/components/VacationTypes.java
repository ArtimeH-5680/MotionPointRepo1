/**
 *
 */
package com.motionpoint.components;

/**
 * @author Henry Artime - types of vacations we handle in this project
 */
public enum VacationTypes {
	/*
	 * @param types of vacation.
	 */
	Mountain_Cabin(1), Ski_Lodge(2), Casino_Resort(3), Ship_Cruise(4);
	/*
	 * @ param
	 * 
	 */
	private final int code;

	VacationTypes(int code) {
		this.code = code;
	}

	public int getVacationCode() {
		return this.code;
	}

}
