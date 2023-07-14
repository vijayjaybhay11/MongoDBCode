package com.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
//@EnableMongoRepositories("com.mongodb.dto")
public class MongoDbCrudOperationsApplication {
	public static void main(String[] args) {
		SpringApplication.run(MongoDbCrudOperationsApplication.class, args);
	}

}
