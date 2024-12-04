package com.supermarket.service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import com.supermarket.dto.BillDTO;
import com.supermarket.dto.CartDTO;
import com.supermarket.dto.CustomerDTO;
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
	public Long calculateProfitPerBill(Long billId);

	
}
