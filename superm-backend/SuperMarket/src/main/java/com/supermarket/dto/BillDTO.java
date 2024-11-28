package com.supermarket.dto;

import java.time.LocalDateTime;

import java.util.List;

import com.supermarket.entity.Customer;

public class BillDTO {

	
	private Long billId;
	private LocalDateTime billDate;
	private double billAmount;
	private Customer customer;
	private List<ProductDTO> products;
	public Long getBillId() {
		return billId;
	}
	public void setBillId(Long billId) {
		this.billId = billId;
	}
	public LocalDateTime getBillDate() {
		return billDate;
	}
	public void setBillDate(LocalDateTime billDate) {
		this.billDate = billDate;
	}
	public double getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<ProductDTO> getProducts() {
		return products;
	}
	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}
	public BillDTO(Long billId, LocalDateTime billDate, double billAmount, Customer customer, List<ProductDTO> products) {
		super();
		this.billId = billId;
		this.billDate = billDate;
		this.billAmount = billAmount;
		this.customer = customer;
		this.products = products;
	}
	
	public BillDTO()
	{
		
	}
}
