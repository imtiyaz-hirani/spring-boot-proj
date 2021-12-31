package com.springboot.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.api.model.Review;
import com.springboot.api.repository.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository; 
	
	public Review postReview(Review review) {
		return reviewRepository.save(review);
	}

}
