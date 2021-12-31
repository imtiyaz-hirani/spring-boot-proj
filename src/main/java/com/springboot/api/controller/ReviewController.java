package com.springboot.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.model.Customer;
import com.springboot.api.model.Product;
import com.springboot.api.model.Review;
import com.springboot.api.service.CustomerService;
import com.springboot.api.service.ProductService;
import com.springboot.api.service.ReviewService;

@RestController
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private ProductService productService; 
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/review/{pid}/{cid}")
	public Review postReview(@RequestBody Review review, @PathVariable("pid") long pid
			, @PathVariable("cid") long cid) {
		
		//go the DB and fetch product object based on {pid}
		Product p = productService.getProduct(pid);
		//attach this product object to review
		review.setProduct(p);
		
		//go to db and fetch customer based on {cid}
		Customer c = customerService.getById(cid);
		//attach this customer to review 
		review.setCustomer(c);
		
		//save review in DB
		return reviewService.postReview(review); 
	}
	
	@GetMapping("/review/customer/{cid}")
	public List<Review> getReviewByCustomer(@PathVariable("cid") long cid) {
		return reviewService.getReviewByCustomer(cid); 
	}
	
	
}
