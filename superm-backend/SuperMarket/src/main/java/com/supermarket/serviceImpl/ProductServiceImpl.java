package com.supermarket.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.supermarket.dto.ProductDTO;
import com.supermarket.entity.Product;
import com.supermarket.repository.ProductRepo;
import com.supermarket.service.ProductService;

import jakarta.transaction.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo prepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public ProductDTO addProduct(ProductDTO productdto) {
		
		Product product=this.modelMapper.map(productdto, Product.class);
		prepo.save(product);
		ProductDTO productd=modelMapper.map(product, ProductDTO.class);
		return productd;
		
		
	}

	@Override
	public ProductDTO getProductById(Long productId) {
		
		Product product=prepo.findByProductId(productId);
		ProductDTO prddto=modelMapper.map(product, ProductDTO.class);
		return prddto;
	}

	@Override
	public ProductDTO getProductByProductName(String productName) {
		
		Product product=prepo.findByProductName(productName);
		ProductDTO prddto=modelMapper.map(product, ProductDTO.class);
		return prddto;
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		
		List<Product> products=prepo.findAll();
		return products.stream().map(product->modelMapper.map(product, ProductDTO.class))
				.collect(Collectors.toList());
		
	}

	@Override
	public ProductDTO updateProduct(ProductDTO productdto, Long productId) {
		
		Product existingProduct=prepo.findByProductId(productId);
		modelMapper.map(productdto,existingProduct);
		prepo.save(existingProduct);
		return modelMapper.map(existingProduct, ProductDTO.class);
		
	}

	@Override
	@Transactional
	public String deleteProduct(Long productId) {
		
		String mg="DELETE FROM bill_product WHERE product_id=?";
		int rowsAffected=jdbcTemplate.update(mg,productId);
		

		
		prepo.deleteByProductId(productId);
		return "Product deleted";
	}

	@Override
	public Product updateProductEntity(Product pd) {
		
		Long id=pd.getProductId();
		Product p=prepo.findByProductId(id);
		modelMapper.map(p, pd);
		double st=p.getCurrentStock()-p.getSoldStock();
		p.setCurrentStock(st);
		 prepo.save(p);
		 
		 return p;
	}

}
