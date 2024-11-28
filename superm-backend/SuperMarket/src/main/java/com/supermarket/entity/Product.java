package com.supermarket.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@ManyToMany(mappedBy = "products",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JsonBackReference
	private List<Bill> bills=new ArrayList<>();

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

	public void setCurrentStock(double currentstock) {
		this.currentStock = currentstock;
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

	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}
	
	
	
	
}
