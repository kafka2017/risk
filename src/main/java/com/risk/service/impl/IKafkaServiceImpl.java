package com.risk.service.impl;

import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Service;

import com.risk.service.IKafkaService;

@Service
public class IKafkaServiceImpl implements IKafkaService {
	
	
	
	@Autowired
	private KafkaTemplate<String,Object> kafkaTemplate;
	

	@Override
	public void send() {
		kafkaTemplate.send("test11", "msg1");
		kafkaTemplate.metrics();
		kafkaTemplate.setProducerListener(new ProducerListener<String, Object>(){

			//成功回调函数
			@Override
			public void onSuccess(String topic, Integer partition, String key, Object value,
					RecordMetadata recordMetadata) {
				System.err.println(value);
			}
			//失败回调函数
			@Override
			public void onError(String topic, Integer partition, String key, Object value, Exception exception) {
				// TODO 自动生成的方法存根
				
			}

			//
			@Override
			public boolean isInterestedInSuccess() {
				// TODO 自动生成的方法存根
				return false;
			}
			
		});
	}


	@Override
	@KafkaListener(topics = {"test11"})
	public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            System.err.println("listen1 " + message);
        }
    }

}
