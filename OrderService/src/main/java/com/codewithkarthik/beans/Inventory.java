package com.codewithkarthik.beans;

public class Inventory {
	
	private String productId;
	private int availableQuantity;
	private int reservedQuantity;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public int getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	public int getReservedQuantity() {
		return reservedQuantity;
	}
	public void setReservedQuantity(int reservedQuantity) {
		this.reservedQuantity = reservedQuantity;
	}
	@Override
	public String toString() {
		return "Inventory [productId=" + productId + ", availableQuantity=" + availableQuantity + ", reservedQuantity="
				+ reservedQuantity + "]";
	}

	
	
}
