package com.codewithkarthik.starter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithkarthik.starter.beans.Product;
import com.codewithkarthik.starter.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product createProduct(Product product) {
		
		product = productRepository.save(product);
		return product;
		
	}
	
	public Iterable<Product> findAll(){
		return productRepository.findAll();
	}
	
	
	public List<Product> findByproductName(String productName){
		
		
		return productRepository.findByProductName(productName);
		
	}
	
	public List<Product> findbyProductPrice(String productPrice){
		
		return productRepository.findByproductPrice(productPrice);
		
	}

}
