package com.springboot.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.api.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{

}
