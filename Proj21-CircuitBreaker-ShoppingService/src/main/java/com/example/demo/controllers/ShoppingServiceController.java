package com.example.demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/shopping-api")
public class ShoppingServiceController {

	// Create a logger for this class
	private static final Logger logger = LoggerFactory.getLogger(ShoppingServiceController.class);

	
	@Autowired
	private IBillingServiceClientComponent client;

	/**
	 * Endpoint to handle shopping and payment processing
	 * 
	 * @return ResponseEntity with a shopping summary and payment status
	 */
	@GetMapping("/purchase")
	@CircuitBreaker(name = "Proj21-CircuitBreaker-ShoppingService",fallbackMethod = "billingFallback")
	public ResponseEntity<String> shoppping() {
		// Log entry into the method
		logger.info("Starting shopping process...{}",client.getClass());

//		try {
			// Invoke payment service to process the payment
			String result = client.invokeDoPayment();
			
			logger.info("client comp class obj:: {}",client.getClass());

			// Log successful payment invocation
			logger.info("Payment service invoked successfully. Result: {}", result);

			// Return response with shopping amount and payment result
			return new ResponseEntity<>("Shopping is done.Payment Status: " + result,HttpStatus.OK);
//		} catch (Exception e) {
//			// Log any error that occurs during payment processing
//			logger.error("Error occurred while invoking payment service: {}", e.getMessage(), e);
//			return new ResponseEntity<>("Shopping failed due to payment error.", HttpStatus.INTERNAL_SERVER_ERROR);
//		}
	}
	
	public ResponseEntity<String> billingFallback(Exception e){
		System.out.println("ShoppingServiceController.billingFallback()");
		return new ResponseEntity<>("Billling operations are out of service",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * Endpoint to handle shopping and payment processing with cardNo
	 * @param cardNo
	 * @return ResponseEntity with a shopping summary and payment status
	 */
	
	@GetMapping("/purchase/{cardNo}")
	public ResponseEntity<String> shoppping(@PathVariable("cardNo") long cardNo) {
		// Log entry into the method
		logger.info("Starting shopping process...{}",client.getClass());

		try {
			// Invoke payment service to process the payment
			String result = client.invokeDoPayment(cardNo);

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
