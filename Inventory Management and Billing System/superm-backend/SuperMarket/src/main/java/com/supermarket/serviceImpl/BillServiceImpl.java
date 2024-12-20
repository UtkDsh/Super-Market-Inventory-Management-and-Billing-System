package com.supermarket.serviceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermarket.dto.BasketDTO;
import com.supermarket.dto.BillDTO;
import com.supermarket.dto.CartDTO;
import com.supermarket.dto.CustomerDTO;
import com.supermarket.dto.ProductDTO;
import com.supermarket.entity.Bill;
import com.supermarket.entity.Customer;
import com.supermarket.entity.Product;
import com.supermarket.repository.BillRepo;
import com.supermarket.repository.CustomerRepo;
import com.supermarket.repository.ProductRepo;
import com.supermarket.service.BillService;
import com.supermarket.service.CustomerService;
import com.supermarket.service.ProductService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BillServiceImpl implements BillService {

	

	
	@Autowired
	private BillRepo brepo;
	
	@Autowired
	private CustomerRepo crepo;
	
	@Autowired
	private CustomerService cservice;
	
	@Autowired
	private ProductService pservice;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ProductRepo prepo;
	
	@Override
	public BillDTO createBill(CartDTO cartdto) {
				
		BillDTO bdto=new BillDTO();
		bdto.setBillId(cartdto.getBillId());
		bdto.setBillAmount(cartdto.getBillAmount());
		try {
			System.out.println(cartdto.getBillDate());
			ZonedDateTime zt=ZonedDateTime.parse(cartdto.getBillDate());
			LocalDateTime lt=zt.toLocalDateTime();
			bdto.setBillDate(lt);
			System.out.println(lt.toString());
		} catch (Exception e) {
				System.out.println("error"+e.getMessage());
		}
		
		Customer c=crepo.findByCustomerId(cartdto.getCustomerId());
		bdto.setCustomer(c);
		
		List<BasketDTO> bkdto=cartdto.getProducts();
		List<ProductDTO> productdto=new ArrayList<>();
		for(BasketDTO b:bkdto)
		{
			ProductDTO p=new ProductDTO();
			Product pr=prepo.findByProductId(b.getProductId());
			modelMapper.map(pr, p);
//			System.out.println("After Mapping"+pr.toString());
			pr.setSoldStock(b.getSoldStock());
			p.setSoldStock(b.getSoldStock());
			pservice.updateProduct(p, p.getProductId());
			
			System.out.println("After setting soldstock"+pr.getSoldStock());
			System.out.println("After setting soldstock productdto"+p.getSoldStock());
			productdto.add(p);
		}
//		List<Product> products=productdto.stream().map(prd->modelMapper.map(prd, Product.class))
//				.collect(Collectors.toList());
		bdto.setProducts(productdto);
		Bill bill=modelMapper.map(bdto, Bill.class);
		updateStock(bdto);
		brepo.save(bill);
		reviseStock(bill);
		System.out.println(bill.getBillDate());
		updateCustomerRewardPoints(bill);
//		updateStock(bdto);
		
		return bdto;
		
		
		
	}

	@Override
	public BillDTO getBillById(Long billId) {
		
		Bill bill=brepo.findByBillId(billId);
		BillDTO billdto= modelMapper.map(bill, BillDTO.class);
		return billdto;
	}

	@Override
	public List<BillDTO> getAllBills() {
		
		List<Bill> bills=brepo.findAll();
		List<BillDTO> billdtos=bills.stream().map(bill->modelMapper.map(bill,BillDTO.class))
				.collect(Collectors.toList());
		
		return billdtos;
	}

	@Override
	public List<BillDTO> getBillsByDate(String date) {

		LocalDate ltd=LocalDate.parse(date);
		System.out.println(ltd);
		List<Bill> allBills=brepo.findAll();
		List<Bill> billsByDate=allBills.stream().filter(e->(e.getBillDate().toLocalDate().equals(ltd)))
				.collect(Collectors.toList());
		List<BillDTO> billsByDateDto=billsByDate.stream().map(bill->modelMapper.map(bill, BillDTO.class))
				.collect(Collectors.toList());
		return billsByDateDto;
		
	
	}

	@Override
	public List<BillDTO> getBillsByMonth(Integer month,Integer year) {
		
		List<Bill> bills=brepo.findAll();
		List<Bill> billsByMonth= bills.stream().filter(e->(e.getBillDate().getMonth().getValue()==month)
				&&(e.getBillDate().getYear()==year)).collect(Collectors.toList());
		List<BillDTO> billdtos=billsByMonth.stream().map(e->modelMapper.map(e, BillDTO.class))
				.collect(Collectors.toList());
		return billdtos;
	}

	@Override
	public List<BillDTO> getBillsByYear(Integer year) {
		
		List<Bill> bills=brepo.findAll();
		List<Bill> billsByYear=bills.stream().filter(e->(e.getBillDate().getYear()==year))
				.collect(Collectors.toList());
		List<BillDTO> billdtos=billsByYear.stream().map(e->modelMapper.map(e, BillDTO.class))
				.collect(Collectors.toList());
		return billdtos;
		
	}

	@Override
	public String deleteBill(Long billId) {
		
		brepo.deleteById(billId);
		return "Bill Record successfully deleted";
	}

	@Override
	public void updateCustomerRewardPoints(Bill bill)
	{
		
		Customer customer=bill.getCustomer();
		double existingpoints=customer.getRewardPoints();
		double points=bill.getBillAmount()/100;
		double updatedRewardPoints=existingpoints+points;
		customer.setRewardPoints(updatedRewardPoints);
		CustomerDTO customerdto=modelMapper.map(customer, CustomerDTO.class);
		cservice.updateCustomer(customerdto, customerdto.getCustomerId());
		
	}

//	@Override
//	public void updateStock(BillDTO billdto) {
//		
//		List<ProductDTO> productList=billdto.getProducts();
//		List<Product> products=productList.stream().map(e->modelMapper.map(e, Product.class))
//				.collect(Collectors.toList());
//		
//	for(Product p:products)
//	{
//		double stock=p.getCurrentStock()-p.getSoldstock();
//		p.setCurrentStock(stock);
//		
//	}
//	
//	List<ProductDTO> productAfterUpdating=products.stream().map(e->modelMapper.map(e, ProductDTO.class))
//			.collect(Collectors.toList());
//	for(ProductDTO pr:productAfterUpdating)
//	{
//		pservice.updateProduct(pr, pr.getProductId());
//	}
//	
//
//	}

	@Override
	public void reviseStock(Bill bill) {
		
		List<Product> pr=bill.getProducts();
		List<Product> prds=prepo.findAll();
		for(Product p:pr)
		{
			
			double updatedStock=p.getCurrentStock()-p.getSoldStock();
			p.setCurrentStock(updatedStock);
			
			pservice.updateProductEntity(p);
		
		
		}
		
		
		
	}

	@Override
	public void updateStock(BillDTO billdto) {
		
		
		List<ProductDTO> prodList=billdto.getProducts();
		List<Product> products=prodList.stream().map(prod->modelMapper.map(prod,Product.class))
				.collect(Collectors.toList());
		
		for(Product p:products)
		{
			double updatedStock=p.getCurrentStock()-p.getSoldStock();
			p.setCurrentStock(updatedStock);
			prepo.save(p);
		}
		
	}

	

	@Override
	public double calculateProfitPerBill(Long billId) {
		
		Bill bill=brepo.findByBillId(billId);
		double totalProfit=bill.getProducts().stream().
				mapToDouble(product->{
					double sellingPrice=product.getSellingPrice();
					double costPrice=product.getCostPrice();
					double stockSold=product.getSoldStock();
					return (sellingPrice*stockSold)-(costPrice*stockSold);
				})
				.sum();
		System.out.println(totalProfit);
		return totalProfit;
	}

	@Override
	public double calculateProfitPerDay(String date) {
		
		
		List<BillDTO> billsPerDaydto=getBillsByDate(date);
		List<Bill> billsPerDay=billsPerDaydto.stream().map(b->modelMapper.map(b, Bill.class))
				.collect(Collectors.toList());
		double profitPerDay=billsPerDay.stream().mapToDouble(
				bill->{
					return calculateProfitPerBill(bill.getBillId());
				}						
				).sum();
		
		return profitPerDay;
	}

	@Override
	public double calculateProfitPerMonth(Integer month, Integer year) {
		
		List<BillDTO> billsPerMonthdto=getBillsByMonth(month, year);
		List<Bill> billsPerMonth=billsPerMonthdto.stream().map(b->modelMapper.map(b, Bill.class))
				.collect(Collectors.toList());
		
		double profitPerMonth=billsPerMonth.stream().mapToDouble(
				bill->{
					
					return calculateProfitPerBill(bill.getBillId());
					
				}
				).sum();
		
		
		
		return profitPerMonth;
	}

	@Override
	public double calculateProfitPerYear(Integer year) {
		
		
		List<BillDTO> billsPerYearDto=getBillsByYear(year);
		List<Bill> billsPerYear=billsPerYearDto.stream().map(b->modelMapper.map(b, Bill.class))
				.collect(Collectors.toList());
		double profitPerYear=billsPerYear.stream().mapToDouble(
				bill->{
					return calculateProfitPerBill(bill.getBillId());
				}
				).sum();
		
		return profitPerYear;
	}

	@Override
	public double calcualateRevenuePerBill(Long billId) {
		
		Bill bill=brepo.findByBillId(billId);
		
		
		
		
		
		return bill.getBillAmount();
	}

	@Override
	public double calcualateRevenuePerDay(String date) {
		
		List<BillDTO> billsPerDay=getBillsByDate(date);
		double revenue=billsPerDay.stream().mapToDouble(b->
		{
			return  b.getBillAmount();
		}).sum();
		return revenue;
	}

	@Override
	public double calcualateRevenuePerMonth(Integer month, Integer year) {
		
		List<BillDTO> billsPerMonth=getBillsByMonth(month, year);
		double revenue=billsPerMonth.stream().mapToDouble(
				b->{
					return b.getBillAmount();
				}
				).sum();
		
		return revenue;
	}

	@Override
	public double calcualateRevenuePerYear(Integer year) {
		
		List<BillDTO> billsPerYear=getBillsByYear(year);
		double revenue=billsPerYear.stream().mapToDouble(b->{
			return b.getBillAmount();
		}).sum();
		
		
		return revenue;
	}

	@Override
	public double numberOfBillsPerDay(String date) {
		
		List<BillDTO> billsPerDay=getBillsByDate(date);
		return billsPerDay.size();
		
		
	}

	@Override
	public double numberOfBillsPerMonth(Integer month, Integer year) {
		
		List<BillDTO> billsPerMonth=getBillsByMonth(month, year);
		
		
		return billsPerMonth.size();
	}

	@Override
	public double numberOfBillsPerYear(Integer year) {
		
		List<BillDTO> billsPerYear=getBillsByYear(year);
		
		return billsPerYear.size();
	}
		
	
	
}
