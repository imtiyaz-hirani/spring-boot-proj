package com.springboot.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.model.Product;
import com.springboot.api.model.Vendor;
import com.springboot.api.repository.ProductRepository;
import com.springboot.api.repository.VendorRepository;
import com.springboot.api.service.ProductService;
@RestController
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	//GETALL, GETONE, POST, PUT , DELETE API
	
	@Autowired
	private VendorRepository vendorRepository;
	
	@Autowired
	private ProductService productService; 
	
	@PostMapping("/product/{vid}")
	public Product postProduct(@PathVariable("vid") long vid, @RequestBody Product product) {
		
		//Step 1: go to DB and fetch vendor record. 
		Vendor vendor = vendorRepository.getById(vid);
		//step 2: attach vendor to product
		product.setVendor(vendor);
		//step 3: save the product in DB
		return productRepository.save(product);
	}
	
	//fetch all products by vendor ID
	@GetMapping("/product/vendor/{vid}")
	public List<Product> fetchProductByVendorId(@PathVariable("vid") long vid) {
		return productService.fetchProductByVendorId(vid);
	}
}
