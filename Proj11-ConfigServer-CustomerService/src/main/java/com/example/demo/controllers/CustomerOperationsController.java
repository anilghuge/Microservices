package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-api")
public class CustomerOperationsController {

	@Value("${dbuser}")
	private String username;
	
	@Value("${dbpassword}")
	private String pwd;
	
	
	@GetMapping("/cust-data")
	public ResponseEntity<String> showData(){
		return new ResponseEntity<>("Data is :: username : "+username+" password : "+pwd,HttpStatus.OK);
	}
}
