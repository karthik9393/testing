package com.codewithkarthik.starter.controller;

import com.codewithkarthik.starter.beans.Product;
import com.codewithkarthik.starter.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/product")
@Api(value="Online Store", description = "Operations pertaining to products in Online Store")
public class ProductController {
	@Autowired
	ProductService productService;
	
	@ApiOperation(value = "View of available products", response = Product.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved list"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	
	@PostMapping
	public Product createProduct(@RequestBody Product product) { 
		return productService.createProduct(product);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Product> getProductDetailsAll(){
		return productService.findAll();
		
	}
	
	@GetMapping(value = "/findByProductName/{productName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> findByProductName(@PathVariable String productName){
		return productService.findByproductName(productName);
	}
	
	@GetMapping("/findByProductPrice/{productPrice}")
	public Iterable<Product> findByProductPrice(@PathVariable String productPrice) {
		return productService.findbyProductPrice(productPrice);
	}
	
	

}
