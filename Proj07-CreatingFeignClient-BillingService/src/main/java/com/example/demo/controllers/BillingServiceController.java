package com.example.demo.controllers;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing-api")
public class BillingServiceController {

    // Create a logger for this class
    private static final Logger logger = LoggerFactory.getLogger(BillingServiceController.class);
    
    @Value("${server.port}")
    private int port;
    
    @Value("${eureka.instance.instance-id}")
    private String instanceId;

    /**
     * This endpoint handles the payment request and returns available payment methods.
     * 
     * @return ResponseEntity containing a message about the available payment methods.
     */
    @GetMapping("payment")
    public ResponseEntity<String> doPayment() {
        // Log the incoming request for the payment endpoint
        logger.info("Received request to process payment...");
        
        logger.info("Instanc Id{}",instanceId);
        int amount=new Random().nextInt(100000000);
        // Respond with a message about available payment methods
        String responseMessage = String.format("Bill Amount is %s. Payment can be done via Cards, UPI Payment %s : %d", amount, instanceId, port);

        // Log the response being sent
        logger.debug("Returning payment methods: {}", responseMessage);

        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }
    
    @GetMapping("/payment/{cardNo}") // Corrected path to include the dynamic part
    public ResponseEntity<String> doPayment(@PathVariable("cardNo") long cardNo) {
        // Log the incoming request for the payment endpoint
        logger.info("Received request to process payment...");

        // Generate a random amount for the bill
        int amount = new Random().nextInt(100000000);

        // Respond with a message about available payment methods
        String responseMessage = String.format(
            "Bill Amount is %s. Payment can be done using CardNO: %d. Instance ID: %s, Port: %d", 
            amount, cardNo, instanceId, port
        );

        // Log the response being sent
        logger.debug("Returning payment methods: {}", responseMessage);

        // Return the response message with a status of OK
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

}

