package com.supermarket.controller;

import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supermarket.dto.BillDTO;
import com.supermarket.dto.CartDTO;
import com.supermarket.dto.CustomerDTO;
import com.supermarket.service.BillService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/bill")
public class BillController {

	@Autowired
	private BillService bservice;
	
	
	@PostMapping("/createbill")
	public ResponseEntity<?> createBill(@RequestBody CartDTO cartdto)
	{
		try {
			BillDTO billdt=bservice.createBill(cartdto);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(billdt);
			
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Could not generate Bill"
					+e.getMessage());			
		}
	}
	
	@GetMapping("/getbillbyid/{billId}")
	public ResponseEntity<?> getBillById(@PathVariable Long billId)
	{
		try {
			BillDTO billdto=bservice.getBillById(billId);
			
			if(billdto==null)
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Bill of this Id found");
			}
			return ResponseEntity.ok(billdto);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retreiving Bill"
					+e.getMessage());
		}
		
	}
	
	
	@GetMapping("/getallbills")
	public ResponseEntity<?> getAllBills()
	{
		try {
			List<BillDTO> billdtos=bservice.getAllBills();
			if(billdtos==null)
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No bills found");
			}
			return ResponseEntity.ok(billdtos);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving bills"
					+e.getMessage());
		}
	}
	
	@GetMapping("/getbillsbymonth/{month}/{year}")
	public ResponseEntity<?> getBillsByMonth(@PathVariable Month month,Integer year)
	{
		try {
			
			List<BillDTO> billsbymonth=bservice.getBillsByMonth(month, year);
			if(billsbymonth==null)
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No bill record found");
			}
			
			return ResponseEntity.ok(billsbymonth);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving bills"
					+e.getMessage());
		}
	}
	
	@GetMapping("/getbillsbyyear/{year}")
	public ResponseEntity<?> getBillsByYear(@PathVariable Integer year)
	{
		try {
			
			List<BillDTO> billsByYear=bservice.getBillsByYear(year);
			
			if(billsByYear==null)
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No bill record found");
			}
			
			return ResponseEntity.ok(billsByYear);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving bills"
					+e.getMessage());
		}
	}
	
	
	@DeleteMapping("/deletebill/{billId}")
	public ResponseEntity<?> deleteBill(@PathVariable Long billId)
	{
		try {
			
			String msg= bservice.deleteBill(billId);
			if(msg==null)
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such Bill exists");
			}
			
			return ResponseEntity.ok(msg);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving bills"
					+e.getMessage());
		}
	}
	
}