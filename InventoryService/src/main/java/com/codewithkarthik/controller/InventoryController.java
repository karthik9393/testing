package com.codewithkarthik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithkarthik.beans.Inventory;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
@RequestMapping("/inventory")
@Api(value="Operations pertaining to inventory in online store")
public class InventoryController {
	
	@ApiOperation(value = "View of available products", response = Inventory.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved list"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})	
	@GetMapping(value= "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Inventory getInventoryDetails(@PathVariable String productId) {
		Inventory i = new Inventory();
		i.setProductId(productId);
		i.setAvailableQuantity(20);
		i.setReservedQuantity(20);
		return i;
		
		
	}

}
