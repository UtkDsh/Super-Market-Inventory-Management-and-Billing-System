package com.supermarket.dto;

import java.util.List;

public class ProductDTO {

	
	private Long productId;
	private String productName;
	private String productCategory;
	private String productBrand;
	private double currentStock;
	private double criticalStock;
	private double soldStock;
	private double costPrice;
	private double sellingPrice;
	private double weight;
	
	private List<Long> billIds;
	
	
	

	public ProductDTO(Long productId, String productName, String productCategory, String productBrand,
			double currentstock, double criticalstock, double soldstock, double costPrice, double sellingPrice,
			double weight, List<Long> billIds) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productBrand = productBrand;
		this.currentStock = currentstock;
		this.criticalStock = criticalstock;
		this.soldStock = soldstock;
		this.costPrice = costPrice;
		this.sellingPrice = sellingPrice;
		this.weight = weight;
		this.billIds = billIds;
	}

	public ProductDTO() {
		
	}
	
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public double getCurrentStock() {
		return currentStock;
	}

	public void setCurrentStock(double currentStock) {
		this.currentStock = currentStock;
	}

	public double getCriticalStock() {
		return criticalStock;
	}

	public void setCriticalStock(double criticalStock) {
		this.criticalStock = criticalStock;
	}

	public double getSoldStock() {
		return soldStock;
	}

	public void setSoldStock(double soldStock) {
		this.soldStock = soldStock;
	}

	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public List<Long> getBillIds() {
		return billIds;
	}

	public void setBillIds(List<Long> billIds) {
		this.billIds = billIds;
	}
	
	
}
