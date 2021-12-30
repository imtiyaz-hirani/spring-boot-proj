package com.springboot.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.model.Customer;
import com.springboot.api.repository.CustomerRepository;
import com.springboot.api.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	 
	@PostMapping("/customer")
	public Customer insertCustomer(@RequestBody Customer customer) {
		return customerService.save(customer); 
				
	}
	
	@GetMapping("/customer")
	public List<Customer> getAllCustomers() {
		return customerService.findAll(); 
				
	}
	
	@GetMapping("/customer/{id}")
	public Customer getSingleCustomer(@PathVariable("id") long id) {
		Customer c = customerService.getById(id);
		return c; 
	}
	
	//id - newCustomer
	@PutMapping("/customer/{id}") // http://localhost:8181/customer/3
	public Customer editCustomer(@PathVariable("id") long id, @RequestBody Customer newCustomer) {
		//1. fetch the existing customer based on given ID 
		Customer customerDB = customerService.getById(id);
		//2. SET new values
		customerDB.setCity(newCustomer.getCity());
		customerDB.setName(newCustomer.getName());
		//3. save it back in the DB 
		return customerService.save(customerDB); 
	}
	
	@DeleteMapping("/customer") 
	public void deleteCustomer(@RequestParam("id") long id) {//http://localhost:8181/customer?id=3
		customerService.deleteById(id);
	}
	
	@GetMapping("/customer/name")
	public Customer findByName(@RequestParam("name") String name) {
		return customerService.findByName(name); 		
	}
	
	@GetMapping("/customer/city")
	public List<Customer> findByCity(@RequestParam("city") String city) {
		return customerService.findByCity(city);		
	}
}










