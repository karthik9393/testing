package com.codewithkarthik.config;

import org.springframework.kafka.annotation.KafkaListener;

import org.springframework.stereotype.Service;

import com.codewithkarthik.beans.Responses;

@Service
public class KafkaConsumer {
	
	@KafkaListener(topics = "java-topic", groupId = "group_id", containerFactory = "kafkaListenerContainerFactory")
	public void consumer1(Responses orderNotification) {
		
		System.out.println("Consumed by First consumer member "+orderNotification);
	}
	
	@KafkaListener(topics = "java-topic", groupId = "group_id", containerFactory = "kafkaListenerContainerFactory")
	public void consumer2(Responses orderNotification) {
		
		System.out.println("Consumed by Second consumer member "+orderNotification);
	}

}
