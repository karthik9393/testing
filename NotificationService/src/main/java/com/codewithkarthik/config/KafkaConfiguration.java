package com.codewithkarthik.config;

import java.util.HashMap;

import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.util.backoff.FixedBackOff;



import com.codewithkarthik.beans.Responses;


@Configuration
@EnableKafka
public class KafkaConfiguration {
	
	@Bean
	public ConsumerFactory<String, Responses> consumerFactory() {
		Map<String, Object> configs = new HashMap<>();
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092,127.0.0.1:9094");
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		configs.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
		return new DefaultKafkaConsumerFactory<String, Responses>(configs, new StringDeserializer(),
				new JsonDeserializer(Responses.class));

	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Responses> kafkaListenerContainerFactory(
			KafkaTemplate<String, Responses> kafkaTemplate) {
		ConcurrentKafkaListenerContainerFactory<String, Responses> factory = new ConcurrentKafkaListenerContainerFactory<String, Responses>();
		factory.setConsumerFactory(consumerFactory());
		DeadLetterPublishingRecoverer recoverer = new DeadLetterPublishingRecoverer(kafkaTemplate,
				(record, ex) -> new TopicPartition("java-topic-dead", record.partition()));

		factory.setCommonErrorHandler(new DefaultErrorHandler(recoverer, new FixedBackOff(1000, 3)));
		return factory;
	}

	@Bean
	public ProducerFactory<String, Responses> producerFactory(){
		Map<String, Object> configs = new HashMap<>();
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092,127.0.0.1:9094");
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(configs);
	}
	
	@Bean
	public KafkaTemplate<String, Responses> kafkaTemplate(){
		return new KafkaTemplate<>(producerFactory());
	}

}
