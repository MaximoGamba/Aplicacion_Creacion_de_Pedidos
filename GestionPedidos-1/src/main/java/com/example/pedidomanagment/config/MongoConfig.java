package com.example.pedidomanagment.config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration

@EnableMongoRepositories(basePackages = {"com.example.pedidomanagment.repository","com.example.demo",
	    "com.example.pedidomanagement.model",
	    "com.example.pedidomanagment.config",
	    "com.example.pedidomanagment.controller",
	    "com.example.pedidomanagment.security",
	    "com.example.pedidomanagment.service" })


public class MongoConfig {

}
