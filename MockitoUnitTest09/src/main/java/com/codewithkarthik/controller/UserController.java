package com.codewithkarthik.controller;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codewithkarthik.entity.User;
import com.codewithkarthik.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService service;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAll(){
		
		return ResponseEntity.ok(service.getAll());
		
	}
	
	@GetMapping("/user/{id} ")
	public ResponseEntity<User> getById(@PathVariable Long id){
		return ResponseEntity.ok(service.getById(id));
		
	}
	
	@GetMapping("/user/{name}")
	public ResponseEntity<User> getByName(@PathVariable String name) {
		return ResponseEntity.ok(service.getByName(name));
		
	}
	
	@PostMapping("/user")
	public ResponseEntity<User> addUser(@RequestBody User user){
		return ResponseEntity.ok(service.addUser(user));
		
	}
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id){
		service.deleteUserbyId(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUsers(@PathVariable Long id,@RequestBody User user){
		return ResponseEntity.ok(service.updateUser(id, user));
		
	}
	
	@PatchMapping("/user/{id}")
	public ResponseEntity<User> updateUserFields(@PathVariable Long id,@RequestBody Map<String, Object> fields){
		return ResponseEntity.ok(service.updateUserByFields(id, fields));
		
	}
	
	

}
