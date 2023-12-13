package com.codewithkarthik.kafkaconfig;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.codewithkarthik.beans.Responses;



@Configuration
@EnableKafka
public class KafkaConfiguration {
	
	@Bean
	public ProducerFactory<String, Responses> productFactory(){
		Map<String,Object> configs = new HashMap<>();
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092,127.0.0.1:9094");
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		configs.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, KafkaSenderInterceptor.class.getName());
		//configs.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, 3);
		return new DefaultKafkaProducerFactory<>(configs);
	}
	
	@Bean
	public KafkaTemplate<String, Responses> kafkaTemplate(){
		return new KafkaTemplate<>(productFactory());
	}

}
