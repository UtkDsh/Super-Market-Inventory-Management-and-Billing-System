package com.supermarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supermarket.dto.ProductDTO;
import com.supermarket.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService pservice;
	
	@PostMapping("/addproduct")
	public ResponseEntity<?> addProduct(@RequestBody ProductDTO productdto)
	{
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(pservice.addProduct(productdto));
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding product");
		}
	}
	
	
	@GetMapping("/getproductbyid/{productId}")
	public ResponseEntity<?> getProduct(@PathVariable Long productId)
	{
		try {
			ProductDTO prd=pservice.getProductById(productId);
			if(prd==null)
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product is not present");
			}
			
			
			return ResponseEntity.ok(prd);
			
		} catch (Exception e) {
		
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching product "
					+ "details"+e.getMessage());
		}
	}
	
	@GetMapping("/getallproducts")
	public ResponseEntity<?> getAllProduct()
	{
		try {
			List<ProductDTO> prd=pservice.getAllProducts();
			if(prd==null)
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product is not present");
			}
			
			
			return ResponseEntity.ok(prd);
			
		} catch (Exception e) {
		
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching product "
					+ "details"+e.getMessage());
		}
	}
	
	
	@GetMapping("/getproductbyname/{productName}")
	public ResponseEntity<?> getProductByName(@PathVariable String productName)
	{
		try {
			ProductDTO products=pservice.getProductByProductName(productName);
			if(products==null)
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Product Record found");
			}
			
			return ResponseEntity.ok(products);
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching product List"+
			e.getMessage());
		}
		
	}
		@PutMapping("/updateproduct/{productId}")
		public ResponseEntity<?> updateProduct(@RequestBody ProductDTO productdto,@PathVariable Long productId)
		{
			try {
				ProductDTO product=pservice.updateProduct(productdto, productId);
				if(product==null)
				{
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such Product Found");
					
				}
			
				return ResponseEntity.ok(product);
				
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching product List"+
						e.getMessage());
			}
		}
		
		@DeleteMapping("/deletebyid/{productId}")
		public ResponseEntity<?> deleteproductbyId(@PathVariable Long productId)
		{
			try {
				
				String pmessage=pservice.deleteProduct(productId);
				if(pmessage==null)
				{
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
				}
				
				return ResponseEntity.ok(pmessage);
			} catch (Exception e) {
				
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching product List"+
						e.getMessage());
			}
		}
		
		
	}
	
	

