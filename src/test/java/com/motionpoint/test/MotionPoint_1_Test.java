package com.motionpoint.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class MotionPoint_1_Test {
	private static final Logger logger = LogManager.getLogger("MotionPoint_1_Test");

	@Test
	public void test() {
		// JUST TESTING LOGGER CONFIGURATION!
		if (logger.isDebugEnabled()) {
			logger.debug("*** DEBUG IS ENABLED");
		}
		logger.error("**** ERROR *****");
		logger.info("**** INFO *****");
	}
}
