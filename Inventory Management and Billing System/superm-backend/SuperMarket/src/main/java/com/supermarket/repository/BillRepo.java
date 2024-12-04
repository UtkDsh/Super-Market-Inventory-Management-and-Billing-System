package com.supermarket.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supermarket.entity.Bill;
import com.supermarket.entity.Customer;

public interface BillRepo extends JpaRepository<Bill, Long> {
	
	public Bill findByBillId(Long id);
	public List<Bill> findByBillDate(LocalDateTime date);
	public List<Bill> findByCustomer(Customer customer);


}
