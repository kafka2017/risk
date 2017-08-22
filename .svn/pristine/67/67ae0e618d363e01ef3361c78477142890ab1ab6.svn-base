package com.risk.kafka;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.concurrent.ListenableFuture;

import com.risk.service.IKafkaService;

import test.SpringBaseTestCase;

public class KafkaTest extends SpringBaseTestCase {

	@Autowired
	private IKafkaService kafkaSerivce;
	
	@Test
	public void send(){
		kafkaSerivce.send();
	}
	
	
	
//	@Test
//	@KafkaListener(topics = {"test1"})
//	public void getMsg(ConsumerRecord<?, ?> record){
//		Optional<?> kafkaMessage = Optional.ofNullable(record.value());
//        if (kafkaMessage.isPresent()) {
//            Object message = kafkaMessage.get();
//            System.out.println("listen1 " + message);
//        }
//	}
	
	
}
