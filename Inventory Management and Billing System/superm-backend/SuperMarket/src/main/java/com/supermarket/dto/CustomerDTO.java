package com.supermarket.dto;

import java.util.List;


public class CustomerDTO {

	
	private Long customerId;
	private String customerName;
	private String customerAddress;
	private double customerMobileNumber;
	private double rewardPoints;
	
	
	private List<BillDTO> bills;


	
	public CustomerDTO(Long customerId, String customerName, String customerAddress, double customerMobileNumber,
			double rewardPoints, List<BillDTO> bills) {
		super();	
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerMobileNumber = customerMobileNumber;
		this.rewardPoints = rewardPoints;
		this.bills = bills;
	}


	public CustomerDTO()
	{
		
	}
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


	public List<BillDTO> getBills() {
		return bills;
	}


	public void setBills(List<BillDTO> bills) {
		this.bills = bills;
	}
	
}
