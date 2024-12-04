package com.supermarket.dto;

public class BasketDTO {

	
	private Long productId;
	private double soldStock;
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public double getSoldStock() {
		return soldStock;
	}
	public void setSoldstock(double soldStock) {
		this.soldStock = soldStock;
	}
	public BasketDTO(Long productId, double soldStock) {
		super();
		this.productId = productId;
		this.soldStock = soldStock;
	}
	public BasketDTO() {
		super();
	}
	
	
}
