package com.springboot.api.repository;

import java.util.List;

 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.api.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	Customer findByName(String name);
	List<Customer> findByCity(String city);
	List<Customer> findByProductsId(long pid);
	
	@Query("select distinct(c) from Customer c join c.products p join p.vendor v where v.id=?1")
	List<Customer> getCustomerByVendor(long vid);
	
	@Query("select distinct(c) from Review r join r.product p join p.customers c where r.rating>?1")
	List<Customer> getCustomerByReviewRating(double rating);

}
