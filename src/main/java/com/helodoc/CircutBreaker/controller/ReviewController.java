package com.helodoc.CircutBreaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.helodoc.CircutBreaker.service.IReviewService;

@RestController
public class ReviewController {
	
	@Autowired
	private IReviewService reviewService;
	
	@RequestMapping(value="/getReview",method=RequestMethod.GET)
	public String getReviewDetails() {
		return reviewService.getReviewDeatils();
	}
	
}
