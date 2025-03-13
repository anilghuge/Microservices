package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Proj21CircuitBreakerShoppingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Proj21CircuitBreakerShoppingServiceApplication.class, args);
	}

}
