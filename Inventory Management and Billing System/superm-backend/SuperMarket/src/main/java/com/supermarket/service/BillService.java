package com.supermarket.service;



import java.util.List;

import com.supermarket.dto.BillDTO;
import com.supermarket.dto.CartDTO;

import com.supermarket.entity.Bill;

public interface BillService {

	
	public BillDTO createBill(CartDTO cartdto);
	public BillDTO getBillById(Long billId);
	public List<BillDTO> getAllBills();
	public List<BillDTO> getBillsByDate(String date);
	public List<BillDTO> getBillsByMonth(Integer month,Integer year);
	public List<BillDTO> getBillsByYear(Integer  year);
	public String deleteBill(Long billId);
	public void updateCustomerRewardPoints(Bill bill);
	public void updateStock(BillDTO billdto);
	public void reviseStock(Bill bill);
	public double calculateProfitPerBill(Long billId);
	public double calculateProfitPerDay(String date);
	public double calculateProfitPerMonth(Integer month,Integer year);
	public double calculateProfitPerYear(Integer year);
	public double calcualateRevenuePerBill(Long billId);
	public double calcualateRevenuePerDay(String date);
	public double calcualateRevenuePerMonth(Integer month,Integer year);
	public double calcualateRevenuePerYear(Integer year);
	public double numberOfBillsPerDay(String date);
	public double numberOfBillsPerMonth(Integer month,Integer year);
	public double numberOfBillsPerYear(Integer year);
}
