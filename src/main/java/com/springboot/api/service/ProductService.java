package com.springboot.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.api.model.Product;
import com.springboot.api.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> fetchProductByVendorId(long vid) {
		return productRepository.findByVendorId(vid); 
	}

	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}
	
	public Product getProduct(long pid) {
		return productRepository.getOneById(pid);
	}

}
