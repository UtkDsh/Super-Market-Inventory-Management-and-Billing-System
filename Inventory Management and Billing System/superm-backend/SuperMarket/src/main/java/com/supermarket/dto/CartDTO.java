package com.supermarket.dto;

import java.util.List;

public class CartDTO {
	private Long billId;
	private String billDate;
	private double billAmount;
	private Long customerId;
	private List<BasketDTO> products;
	public Long getBillId() {
		return billId;
	}
	public void setBillId(Long billId) {
		this.billId = billId;
	}
	public String getBillDate() {
		return billDate;
		
	}
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}
	public double getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public List<BasketDTO> getProducts() {
		return products;
	}
	public void setProducts(List<BasketDTO> products) {
		this.products = products;
	}
	public CartDTO(Long billId, String billDate, double billAmount, Long customerId, List<BasketDTO> products) {
		super();
		this.billId = billId;
		this.billDate = billDate;
		this.billAmount = billAmount;
		this.customerId = customerId;
		this.products = products;
	}
	
	
	public CartDTO()
	{
		
	}
}
