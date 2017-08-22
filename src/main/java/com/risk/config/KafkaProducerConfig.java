package com.risk.config;

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

/**
 * 生产者配置
 * @author Administrator
 *
 */
@Configuration
@EnableKafka
public class KafkaProducerConfig {
	
	private String BOOTSTRAP_SERVERS_CONFIG = "192.168.146.128:9092,192.168.146.129:9092,192.168.146.130:9092";
	
	private Integer RETRIES_CONFIG = 0;
	
	private Integer BATCH_SIZE_CONFIG = 4096;
	
	private Integer LINGER_MS_CONFIG = 1;
	
	private Integer BUFFER_MEMORY_CONFIG = 40960;
	

	public Map<String,Object> producerConfigs(){
		Map<String, Object> props = new HashMap<String,Object>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS_CONFIG);
        props.put(ProducerConfig.RETRIES_CONFIG, RETRIES_CONFIG);
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, BATCH_SIZE_CONFIG);
        props.put(ProducerConfig.LINGER_MS_CONFIG, LINGER_MS_CONFIG);
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, BUFFER_MEMORY_CONFIG);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return props;
	}
	
	public ProducerFactory<String, Object> producerFactory(){
		return new DefaultKafkaProducerFactory<>(producerConfigs());
	}
	
	
	@Bean
	public KafkaTemplate<String,Object> kafkaTemplate(){
		KafkaTemplate<String,Object> template = new KafkaTemplate<String,Object>(producerFactory());
		return template;
	}
}
