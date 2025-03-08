package com.example.demo.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BillingServiceClientComponent {

    // Create a logger for this class
    private static final Logger logger = LoggerFactory.getLogger(BillingServiceClientComponent.class);

    @Autowired
    private DiscoveryClient client; // Injecting the DiscoveryClient to discover service instances

    /**
     * This method invokes the billing service to process the payment.
     * It uses Eureka to discover the Billing Service instance and make a request to it.
     * 
     * @return the result of the payment service as a String
     */
    public String invokeDoPayment() {
        logger.info("Invoking payment service...");

        try {
            // Get the list of instances for the BillingService from Eureka
            List<ServiceInstance> instanceList = client.getInstances("Proj04-CreatingDiscoveryClient-BillingService");
            
            if (instanceList == null || instanceList.isEmpty()) {
                logger.error("No instances found for BillingService.");
                return "Error: No instances available for BillingService";
            }

            // Get the first instance (assuming there's at least one instance available)
            ServiceInstance instance = instanceList.get(0);
            String url = instance.getUri() + "/billing-api/payment";  // Construct the URL for the payment API

            // Log the URL being called
            logger.debug("Calling billing service at URL: {}", url);

            // Set up the RestTemplate to send the request
            RestTemplate restTemplate = new RestTemplate();

            // Make the GET request to the billing service and get the result
            String result = restTemplate.getForObject(url, String.class);

            // Log the result received from the billing service
            logger.info("Received payment response: {}", result);

            return result;
        } catch (Exception e) {
            // Log the error if anything goes wrong
            logger.error("Error occurred while invoking payment service: {}", e.getMessage(), e);
            return "Error: Payment service invocation failed";
        }
    }
}

