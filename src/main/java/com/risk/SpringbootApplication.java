package com.risk;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootApplication {
	public static void main(String[] args) throws InterruptedException {
		ApplicationContext app = SpringApplication.run(SpringbootApplication.class, args);
		
	}
}
