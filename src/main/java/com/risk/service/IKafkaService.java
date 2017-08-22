package com.risk.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface IKafkaService {

	public void send();
	
	public void listen(ConsumerRecord<?, ?> record);
}
