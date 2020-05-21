package com.helodoc.CircutBreaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.ComponentScan;

@EnableCircuitBreaker
@SpringBootApplication
public class CircutBreakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CircutBreakerApplication.class, args);
	}

}
