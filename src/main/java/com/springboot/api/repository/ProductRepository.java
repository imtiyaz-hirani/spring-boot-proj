package com.springboot.api.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.api.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	@Transactional
	List<Product> findByVendorId(long id);
}
