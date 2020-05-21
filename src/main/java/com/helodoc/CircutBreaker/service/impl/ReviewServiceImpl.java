package com.helodoc.CircutBreaker.service.impl;

import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.helodoc.CircutBreaker.service.IReviewService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ReviewServiceImpl implements IReviewService {

	@Autowired
	private RestTemplate restTemplate;
	public static Map<LocalTime, Integer> map = new LinkedHashMap<>();

	@HystrixCommand(fallbackMethod = "fallBack")
	public String getReviewDeatils() {
		try {
			try {
				ResponseEntity<String> response = restTemplate.exchange("http://127.0.0.1:8084/jwtSecurity/hello",
						HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
						}, "HighSchool");
			} catch (HttpServerErrorException e) {
				boolean isMatched = Pattern.compile("^[5][0-1]{1}[0-1]{1}$")
						.matcher(String.valueOf(e.getRawStatusCode())).matches();
				if (isMatched /*&& matchTimeLimit(comparingTheTime())*/) {
					throw new RuntimeException("Get 500 Exception");
				}
			} catch (HttpClientErrorException e) {
				System.out.println("4xx exception");
			}
			return "Success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	public boolean matchTimeLimit(LocalTime key) {
		return map.get(key) == 10;
	}

	public LocalTime comparingTheTime() {
		LocalTime key = null;
		try {
			key = getKey();
			LocalTime localTime = LocalTime.now();
			LocalTime fiveMinutesLater = key.plusMinutes(5);
			if (fiveMinutesLater.isBefore(localTime) == false) {
				map.put(key, map.get(key) + 1);
			} else {
				map.put(localTime, 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return key;
	}

	public LocalTime getKey() {
		LocalTime key = null;
		Set<LocalTime> keys = map.keySet();
		for (LocalTime keyss : keys) {
			key = keyss;
		}
		return key;
	}

	private String fallBack() {
		return "Hello FallBack!";
	}

}
