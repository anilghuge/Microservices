package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Proj09CreatingConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Proj09CreatingConfigServerApplication.class, args);
	}

}
