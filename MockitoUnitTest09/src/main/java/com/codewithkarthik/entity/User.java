package com.codewithkarthik.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "user_name")
	private String name;
	@Column(name = "user_phoneNo")
	private String phone;
	@Column(name = "user_address")
	private String address;
	
	public User() {
		super();
	}
	
	public User(Long id, String name, String phone, String address) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
		
	}
	
	public String getPhone() {
		return phone;
		
	}
	
	public String getAddress() {
		return address;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
		
	}
	public void setPhone(String phone) {
		this.phone = phone;
		
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + "]";
	}
	
	

}
