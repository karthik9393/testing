package com.codewithkarthik.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codewithkarthik.beans.Product;

@FeignClient(name= "product-service")
@RibbonClient(name = "product-service")
public interface ProductServiceProxy {
	@GetMapping("product/{productId}")
	public Product getProductDetails(@PathVariable("productId") String  productId);

}
