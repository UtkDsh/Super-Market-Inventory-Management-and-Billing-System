package com.supermarket.service;

import java.util.List;

import com.supermarket.dto.BillDTO;
import com.supermarket.dto.CustomerDTO;
import com.supermarket.entity.Bill;
import com.supermarket.entity.Customer;

public interface CustomerService {

	public CustomerDTO addCustomer(CustomerDTO customer);
	public CustomerDTO getCustomerbyId(Long id);
	public List<CustomerDTO> getAllCustomers();
	public CustomerDTO updateCustomer(CustomerDTO customer,Long customerId);
	public String deleteCustomer(Long id);
	public CustomerDTO getCustomerbyName(String name);
	public CustomerDTO getCustomerbyMobileNumber(double mnumber);
}
