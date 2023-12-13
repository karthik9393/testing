package com.codewithkarthik.starter.beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import io.swagger.annotations.ApiModelProperty;
//Instead of using entity annotations, I used document annotation
@Document(indexName = "product", type = "doc")
public class Product {
	@Id
	@ApiModelProperty("The database generated product ID")
	private String productId;
	@ApiModelProperty("The product description")
	private String productName;
	@ApiModelProperty("The product price")
	private String productPrice;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	
	

}
