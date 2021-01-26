package com.motionpoint.processers;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.motionpoint.components.Card;
import com.motionpoint.exceptions.PaymentException;

public interface PaymentProcessor {
	/**
	 * Henry Artime - Asynchronous payment.
	 */
	/*
	 * @ param Card
	 *
	 * @ return status
	 */
	default int payAsync(Card card) throws Exception {

		return doPay(card);
	}

	// simulate a simple payment with integer status 0 = Okay , 1 = declined etc
	static int doPay(Card card) throws Exception {
		// In the real world a remote service would be called.......
		Callable<Integer> paymentTask = () -> {

			Random status = new Random();
			return status.nextInt(6);
		};

		ExecutorService exec = Executors.newSingleThreadExecutor();
		Future<Integer> future = exec.submit(paymentTask);
		// In the real world I would call get() with a time out....
		try {
			Integer paymentStatus = future.get();
			return paymentStatus;

		} catch (InterruptedException | ExecutionException e) {
			throw new PaymentException(" Payment may not have completed!", e);

		} finally {
			if (exec != null) {
				exec.shutdownNow();
			}
		}
	}

}
