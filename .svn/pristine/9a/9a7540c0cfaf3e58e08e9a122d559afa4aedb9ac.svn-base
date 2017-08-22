package com.risk.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.Mongo;

@Configuration
public class MongoConfig {

	private static Logger logger = Logger.getLogger(MongoConfig.class);
	
	private String username;
	
	private String password;
	
	@Value("${spring.data.mongodb.database}")
	private String database;
	
	@Value("${spring.data.mongodb.host}")
	private String host;
	
	@Bean
	public MongoDbFactory mongodbFactory(){
		logger.info("mongodb注入成功");
		logger.info("mongodb地址：" + host);
		UserCredentials usercre = new UserCredentials(username,password);
		MongoDbFactory db = new SimpleMongoDbFactory(new Mongo(host),database,usercre);
		return db;
	}
	
	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
	    return new MongoTemplate(mongodbFactory());
	}
}
