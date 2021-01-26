/**
 *
 */
package com.motionpoint.exceptions;

/**
 * @author Henry Artime Note: we only use 1 constructor for this here...
 */
public class NoAvailableRoomsException extends Exception {
	private static final long serialVersionUID = 1L;

	public NoAvailableRoomsException() {
		super();

	}

	public NoAvailableRoomsException(String message, Throwable cause) {
		super(message, cause);

	}

	public NoAvailableRoomsException(String message) {
		super(message);

	}

	public NoAvailableRoomsException(Throwable cause) {
		super(cause);

	}

}
