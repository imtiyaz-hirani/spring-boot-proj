package com.springboot.api.repository;

import java.util.List;

 
import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.api.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	Customer findByName(String name);
	List<Customer> findByCity(String city);
	List<Customer> findByProductsId(long pid);

}
