package com.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supermarket.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

	
	Customer findByCustomerId(Long customerId);
	Customer findByCustomerName(String customerName);
	Customer findByCustomerAddress(String customerAddress);
	Customer findByCustomerMobileNumber(double mobileNumber);
}
