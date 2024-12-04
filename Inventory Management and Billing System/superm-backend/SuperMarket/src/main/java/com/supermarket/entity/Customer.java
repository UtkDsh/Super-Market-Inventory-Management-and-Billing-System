package com.supermarket.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	private String customerName;
	private String customerAddress;
	private double customerMobileNumber;
	private double rewardPoints;
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Bill> bills=new ArrayList<>();

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public double getCustomerMobileNumber() {
		return customerMobileNumber;
	}

	public void setCustomerMobileNumber(double customerMobileNumber) {
		this.customerMobileNumber = customerMobileNumber;
	}

	public double getRewardPoints() {
		return rewardPoints;
	}

	public void setRewardPoints(double rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}
	
	public Customer()
	{
		
	}

	public Customer(Long customerId, String customerName, String customerAddress, double customerMobileNumber,
			double rewardPoints, List<Bill> bills) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerMobileNumber = customerMobileNumber;
		this.rewardPoints = rewardPoints;
		this.bills = bills;
	}
	
	
	
}
