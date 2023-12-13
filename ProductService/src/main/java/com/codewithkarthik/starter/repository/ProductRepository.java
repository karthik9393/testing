package com.codewithkarthik.starter.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.codewithkarthik.starter.beans.Product;
//Data JPA approach
public interface ProductRepository extends ElasticsearchRepository<Product, String>{
	//custom queries
	List<Product> findByProductName(String productName);
	List<Product> findByproductPrice(String productPrice);

}
