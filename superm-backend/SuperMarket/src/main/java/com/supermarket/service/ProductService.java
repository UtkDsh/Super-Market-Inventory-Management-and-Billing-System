package com.supermarket.service;

import java.util.List;

import com.supermarket.dto.ProductDTO;
import com.supermarket.entity.Product;

public interface ProductService {

	public ProductDTO addProduct(ProductDTO productdto);
	public ProductDTO getProductById(Long productId);
	public ProductDTO getProductByProductName(String productName);
	public List<ProductDTO> getAllProducts();
	public ProductDTO updateProduct(ProductDTO productdto,Long productId);
	public String deleteProduct(Long productId);
	public Product updateProductEntity(Product pd);
	
}
