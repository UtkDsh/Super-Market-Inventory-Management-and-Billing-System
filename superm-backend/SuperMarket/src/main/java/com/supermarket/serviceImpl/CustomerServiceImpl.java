package com.supermarket.serviceImpl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.supermarket.dto.BillDTO;
import com.supermarket.dto.CustomerDTO;
import com.supermarket.entity.Bill;
import com.supermarket.entity.Customer;
import com.supermarket.repository.CustomerRepo;
import com.supermarket.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo crepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public CustomerDTO addCustomer(CustomerDTO customerdto) {
		
		Customer customer=this.modelMapper.map(customerdto, Customer.class);

		crepo.save(customer);
		return modelMapper.map(customer, CustomerDTO.class);
	}

	@Override
	public CustomerDTO getCustomerbyId(Long id) {
		
		Customer customer=crepo.findByCustomerId(id);
		CustomerDTO customerdto=modelMapper.map(customer, CustomerDTO.class);
		return customerdto;
	}
	
	
	
	@Override
	public List<CustomerDTO> getAllCustomers() {
		
		List<Customer> customers=crepo.findAll();
		
		return customers.stream().map(customer->modelMapper.map(customer, CustomerDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public CustomerDTO updateCustomer(CustomerDTO customer,Long customerId) {
		
		Customer existingcustomer=crepo.findByCustomerId(customerId);
		modelMapper.map(customer,existingcustomer );
		crepo.save(existingcustomer);
		return modelMapper.map(existingcustomer, CustomerDTO.class);
	}

	@Override
	public String deleteCustomer(Long id) {
		
		crepo.deleteById(id);
		return "Customer data deleted";
	}

	@Override
	public CustomerDTO getCustomerbyName(String name) {
		
		Customer customer=crepo.findByCustomerName(name);
		CustomerDTO customerdto=modelMapper.map(customer, CustomerDTO.class);
		return customerdto;
		
	}

	@Override
	public CustomerDTO getCustomerbyMobileNumber(double mnumber) {
		
		Customer customer=crepo.findByCustomerMobileNumber(mnumber);
		CustomerDTO customerdto=modelMapper.map(customer, CustomerDTO.class);
		return customerdto;
	}

	


	
}
