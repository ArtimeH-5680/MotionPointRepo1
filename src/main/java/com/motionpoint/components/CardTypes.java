/**
 *
 */
package com.motionpoint.components;

/**
 * @author Henry Artime
 *
 */
public enum CardTypes {
	/**
	 * types of payment cards.
	 */
	Visa(1), Master_Card(2), American_Express(3),;
	/**
	 * enum type as int
	 */
	private final int code;

	CardTypes(int code) {
		this.code = code;
	}

	public int getCode(int code) {
		return this.code;
	}
}
