package com.springboot.api.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.api.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	@Transactional
	List<Product> findByVendorId(long id);

	@Query("select distinct(p) from Product p join p.vendor v "
			+ "join p.customers c where v.name=?1 and c.city=?2")
	List<Product> getProductsByVendorAndCustomerCity(String name, String city);
	
	 
}
