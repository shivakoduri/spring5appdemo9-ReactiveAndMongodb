package com.myprojects.spring5.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication
public class ApplicationDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationDemoApplication.class, args);
	}
}
