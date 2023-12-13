package com.codewithkarthik.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.codewithkarthik.beans.Inventory;
import com.codewithkarthik.beans.Orders;
import com.codewithkarthik.beans.Product;
import com.codewithkarthik.beans.Responses;

@Service
public class OrderService {

	@Autowired
	private RestTemplate restTemplate;

	private String URL = "http://PRODUCT-SERVICE/product/";

	private String URL2 = "http://INVENTORY-SERVICE/inventory/";

	public Responses getOrderDetail(String orderId) {

		Orders orders = new Orders();
		orders.setOrderId(orderId);
		orders.setProductId("P10001");
		orders.setOrderQty("20");

		orders.setProduct(getProductDetail(orders.getProductId()));
		orders.setInventory(getInventoryDetail(orders.getProductId()));

		Responses responses = new Responses();
		responses.setData(orders);
		responses.setStatus(HttpStatus.OK.toString());
		responses.setMsg("SUCCESS...");
		return responses;
	}

	private Product getProductDetail(String productId) {

		Product product = restTemplate.getForObject(URL + productId, Product.class);

		return product;
	}

	private Inventory getInventoryDetail(String productId) {

		Inventory inventory = restTemplate.getForObject(URL2 + productId, Inventory.class);

		return inventory;
	}
	
	
	@Autowired
	private KafkaTemplate<String, Responses> kafkaTemplate;
	

	private String topicName = "karthik-topic";
	
	
	public void sendMessage(Responses responses) {
		kafkaTemplate.send(topicName, responses);
		System.out.println("Message sent to Kafka Server...");
	}
}
