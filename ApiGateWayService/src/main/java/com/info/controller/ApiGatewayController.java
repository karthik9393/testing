package com.info.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.info.beans.Response;

@RestController
@RequestMapping("/fallback")
public class ApiGatewayController {

	@GetMapping("/productService")
	public Response getFallBackProduct() {
		Response response = new Response();
		response.setDt(new Date());
		response.setMessage("Product Service is down...");
		return response;
	}
	
	@GetMapping("/orderService")
	public Response getFallBackOrder() {
		Response response = new Response();
		response.setDt(new Date());
		response.setMessage("Order Service is down...");
		return response;
	}
	
	@GetMapping("/defaultService")
	public Response getFallBackDefault() {
		Response response = new Response();
		response.setDt(new Date());
		response.setMessage("This Service is down...");
		return response;
	}
}
