package com.springboot.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.api.model.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long>{

}
