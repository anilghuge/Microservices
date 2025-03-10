package com.example.demo.controllers;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing-api")
public class BillingServiceController {

    // Create a logger for this class
    private static final Logger logger = LoggerFactory.getLogger(BillingServiceController.class);

    /**
     * This endpoint handles the payment request and returns available payment methods.
     * 
     * @return ResponseEntity containing a message about the available payment methods.
     */
    @GetMapping("payment")
    public ResponseEntity<String> doPayment() {
        // Log the incoming request for the payment endpoint
        logger.info("Received request to process payment...");
        
        int amount=new Random().nextInt(100000000);
        // Respond with a message about available payment methods
        String responseMessage = "Bill Amount is "+amount+" Payment can be done via Cards, UPI Payment";

        // Log the response being sent
        logger.debug("Returning payment methods: {}", responseMessage);

        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }
}

