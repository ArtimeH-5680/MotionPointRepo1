/**
 *
 */
package com.motionpoint.processers;

import com.motionpoint.components.Card;

/**
 * @author Henry Artime
 *
 */
@FunctionalInterface
public interface PaymentProcessorSync {

	public abstract int paySync(Card card);

}
