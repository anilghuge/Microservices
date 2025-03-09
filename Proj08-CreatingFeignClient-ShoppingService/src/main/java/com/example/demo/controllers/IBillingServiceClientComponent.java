package com.example.demo.controllers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("Proj07-CreatingFeignClient-BillingService")
public interface IBillingServiceClientComponent {
	
	@GetMapping("/billing-api/payment")
    public String invokeDoPayment();
	
	@GetMapping("/billing-api/payment/{cardNo}")
    public String invokeDoPayment(@PathVariable("cardNo") long cardNo);
}

