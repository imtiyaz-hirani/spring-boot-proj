package com.springboot.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.model.Vendor;
import com.springboot.api.repository.VendorRepository;

@RestController
public class VendorController {

	@Autowired
	private VendorRepository vendorRepository;
	//GETALL, GETONE, POST, PUT , DELETE API
	
	@PostMapping("/vendor")
	public Vendor postVendor(@RequestBody Vendor vendor) {
		return vendorRepository.save(vendor);
	}
	
}
