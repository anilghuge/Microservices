package com.example.demo.controllers;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-api")
public class ShoppingServiceController {

	// Create a logger for this class
	private static final Logger logger = LoggerFactory.getLogger(ShoppingServiceController.class);

	@Autowired
	private BillingServiceClientComponent client; // Injecting the BillingServiceClientComponent

	/**
	 * Endpoint to handle shopping and payment processing
	 * 
	 * @return ResponseEntity with a shopping summary and payment status
	 */
	@GetMapping("/purchase")
	public ResponseEntity<String> shoppping() {
		// Log entry into the method
		logger.info("Starting shopping process...");

		try {
			// Invoke payment service to process the payment
			String result = client.invokeDoPayment();

			// Log successful payment invocation
			logger.info("Payment service invoked successfully. Result: {}", result);

			// Return response with shopping amount and payment result
			return new ResponseEntity<>("Shopping is done.Payment Status: " + result,HttpStatus.OK);
		} catch (Exception e) {
			// Log any error that occurs during payment processing
			logger.error("Error occurred while invoking payment service: {}", e.getMessage(), e);
			return new ResponseEntity<>("Shopping failed due to payment error.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
