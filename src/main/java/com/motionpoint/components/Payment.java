/**
 * 
 */
package com.motionpoint.components;
import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.motionpoint.components.Card;
import com.motionpoint.processers.PaymentProcessorSync; 
import com.motionpoint.processers.PaymentProcessor;

/**
 * @author Henry Artime 
 *
 */
/* For now this class uses the default pay method in the interface */

public class Payment implements PaymentProcessor {
	
	private static final Logger logger = LogManager.getLogger("PaymentProcessor");
	
	UUID transactionId; 
	BigDecimal amount; 
    Card  card; 

    public Payment(Card card) {
    	
    	this.card = card; 
    	 
    	setTransactionId();
    }
       		
    	// Can implement various payment logic using functional interface 
        // This is just a simulation and only a dummy status code is returned. 
        // In the real world a remote service would be invoked. 
      public int payNow()	{
    	  
    	  PaymentProcessorSync p =
    	      (pay)-> { 
    	    	  
    		  Random r = new Random(); 
    		         
    		  return r.nextInt(6);
    	  };
    	  return p.paySync(this.card);
      }
    
    	
   	/**
	 * @return the transactionId
	 */
	public UUID getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	private void setTransactionId() {
		this.transactionId = UUID.randomUUID();
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * @return the card
	 */
	public Card getCard() {
		return card;
	}

	/**
	 * @param card the card to set
	 */
	public void setCard(Card card) {
		this.card = card;
	}
	@Override
	public String toString() {
		return "Payment [transactionId=" + transactionId + ", amount=" + amount + ", card=" + card + "]";
	}
}  
    