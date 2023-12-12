package com.codewithkarthik.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithkarthik.entity.Product;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@GetMapping("/1")
	public Product getProduct() {
		Product p = new Product();
		p.setId(1235);
		p.setProdcutDesc("X1");
		p.setProductName("Launched in 2025");
		
		return p;
		
	}

}
