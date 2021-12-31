package com.springboot.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.api.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{

	@Query("select r from Review r where r.customer.id = ?1")
	List<Review> getReviewByCustomer(long cid);

}
//select * from review where  customer_id = cid