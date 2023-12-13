package com.codewithkarthik.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithkarthik.beans.Responses;
import com.codewithkarthik.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	
	
	@GetMapping(value= "/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Responses getOrderDeatil(@PathVariable String orderId) {
		
		return orderService.getOrderDetail(orderId);
		
	}
	
	
	
	@PostMapping
	public String createOrder(@RequestBody Responses responses) {
		orderService.sendMessage(responses);
		return "Order Creation is in process...";
		
	}
	
	
	
	

}
