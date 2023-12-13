package com.codewithkarthik.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codewithkarthik.beans.Inventory;

@FeignClient(name="inventory-service")
@RibbonClient(name = "inventory-service")
public interface InventoryServiceProxy {
	
	@GetMapping("/inventory/{productId}")
	public Inventory getInventoryDetails(@PathVariable("productId")  String productId);

}
