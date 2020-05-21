package com.helodoc.CircutBreaker;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.helodoc.CircutBreaker.Model.TimeModel;
import com.helodoc.CircutBreaker.service.impl.ReviewServiceImpl;

@Configuration
public class Config {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public TimeModel startTime() {
		TimeModel timeMode = new TimeModel();
		LocalTime time =getCurrentTime();
		ReviewServiceImpl.map.put(time, 0);
		return timeMode;
	}
	
	public static LocalTime getCurrentTime() {
		return LocalTime.now();
	}
	
}
