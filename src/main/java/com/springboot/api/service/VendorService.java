package com.springboot.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.api.repository.ProductRepository;

@Service
public class VendorService {
	@Autowired
	private ProductRepository productRepository;
	
	
}
