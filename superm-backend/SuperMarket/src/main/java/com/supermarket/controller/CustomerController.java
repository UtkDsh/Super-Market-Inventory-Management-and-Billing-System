package com.supermarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.supermarket.dto.CustomerDTO;
import com.supermarket.service.CustomerService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/customer")
public class CustomerController {

	
	@Autowired
	private CustomerService cservice;
	
	
	@PostMapping(value="/addCustomer",consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addcustomer(@RequestBody CustomerDTO customerdto)
	{
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(cservice.addCustomer(customerdto));
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error adding customer"
					+e.getMessage());
		}
			
		
	}
	
	@GetMapping("/getCustomerbyId/{customerid}")
	public ResponseEntity<?> getcustomer(@PathVariable Long customerid)
	{
		
		try {
			CustomerDTO cst=cservice.getCustomerbyId(customerid);

			if(cst==null)
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
			}
			
			return ResponseEntity.ok(cst);
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
					body("Error retrieving customer data");
		}
		
	}
	
	@GetMapping("/getCustomerbyname/{customerName}")
	public ResponseEntity<?> getcustomerbyname(@PathVariable String customerName)
	{
		
		try {
			CustomerDTO cst=cservice.getCustomerbyName(customerName);

			if(cst==null)
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
			}
			
			return ResponseEntity.ok(cst);
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
					body("Error retrieving customer data");
		}
		
	}
	
	@GetMapping("/getCustomerbymobilenumber/{customerMoibleNumber}")
	public ResponseEntity<?> getcustomer(@PathVariable double customerMoibleNumber)
	{
		
		try {
			CustomerDTO cst=cservice.getCustomerbyMobileNumber(customerMoibleNumber);

			if(cst==null)
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
			}
			
			return ResponseEntity.ok(cst);
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
					body("Error retrieving customer data");
		}
		
	}
	
	
	
	
	@GetMapping("/getallcustomers")
	public ResponseEntity<?> getallcustomers()
	{
		
		try {
	
			List<CustomerDTO> cst=cservice.getAllCustomers();
			if(cst==null)
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No customer records available");
				
			}
			
			
			return new ResponseEntity<List<CustomerDTO>>(cservice.getAllCustomers(),HttpStatus.OK);
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error "
					+ "retrieving customer records");
		}
		
		
		
		
	}
	
	@PutMapping("/updatecustomer/{customerId}")
	public ResponseEntity<?> updatecustomer(@RequestBody CustomerDTO customerdto,@PathVariable Long customerId)
	{
		
		try {
			
			CustomerDTO cst=cservice.updateCustomer(customerdto, customerId);
			if(cst==null)
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
			}
			return ResponseEntity.ok(cst);
			
		} catch (Exception e) {


			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating customer");
		}
		
	}
	
	
	@DeleteMapping("/deletecustomer/{customerId}")
	public ResponseEntity<?> deletecustomer(@PathVariable Long customerId)
	{
		try {
			String s=cservice.deleteCustomer(customerId);
			if(s==null)
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("customer not found");
			}
			
			return ResponseEntity.status(HttpStatus.OK).body(s);
		} catch (Exception e) {
		
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Could"
					+ "not delete Customer");
		}
	}
	
	
}
