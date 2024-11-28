package com.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supermarket.entity.Product;

public interface ProductRepo extends JpaRepository<Product,Long> {
	
	Product findByProductId(Long productId);
	Product findByProductName(String productName);
	Product findByProductCategory(String productCategory);
	Product findByProductBrand(String productBrand);
	String deleteByProductId(Long productId);
	

}
