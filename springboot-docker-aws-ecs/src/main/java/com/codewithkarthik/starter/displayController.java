package com.codewithkarthik.starter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class displayController {
	
	@GetMapping("/{name}")
	public String message(@PathVariable String name) {
		return "Hello, This is "+name+" How are you doing???";
		
		
		
	}
	
	
	@GetMapping("/{address}/{name}")
	public String message2(@PathVariable String address, @PathVariable String name) {
		
		return "My addresss: " +address+ " My name: "+ name;
		
	}

}
