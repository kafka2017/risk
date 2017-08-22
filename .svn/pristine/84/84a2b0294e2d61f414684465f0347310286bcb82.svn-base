package com.risk.redis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.risk.service.IRedisService;

import test.SpringBaseTestCase;

public class RedisTest extends SpringBaseTestCase {

	@Autowired
	IRedisService redisService;
	
	@Test
	public void get(){
		String s = redisService.get("t");
		System.out.println(s);
	}
}
