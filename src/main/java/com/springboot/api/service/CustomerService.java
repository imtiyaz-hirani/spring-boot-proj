package com.springboot.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.api.model.Customer;
import com.springboot.api.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository; 
	
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	public Customer getById(long id) {
		return customerRepository.getById(id);
	}

	public void deleteById(long id) {
		customerRepository.deleteById(id);
	}

	public Customer findByName(String name) {
		return customerRepository.findByName(name);
	}

	public List<Customer> findByCity(String city) {
		return customerRepository.findByCity(city);
	}

	public List<Customer> getCustomerByProductId(long pid) {
		return customerRepository.findByProductsId(pid);
	}

	
}
