package com.springboot.api.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "cname")
	private String name; 
	
	@Column(name = "ccity")
	private String city;
 
	@ManyToMany
	@JoinTable(name = "customer_product" , 
	joinColumns = {
			@JoinColumn(name="customer_id", nullable = false, referencedColumnName = "id")
	}, 
	inverseJoinColumns = {
			@JoinColumn(name="product_id", nullable = false, referencedColumnName = "id")
	})
	private List<Product> products; 
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	} 
	
	
	
}
