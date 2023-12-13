package com.codewithkarthik.beans;

public class Orders {
	
	private String orderId;
	private String orderQty;
	private String productId;
	private Product product;
	private Inventory inventory;
	
	public Inventory getInventory() {
		return inventory;
	}
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(String orderQty) {
		this.orderQty = orderQty;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderQty=" + orderQty + ", productId=" + productId + ", product="
				+ product + ", inventory=" + inventory + "]";
	}
	
	
	

}
