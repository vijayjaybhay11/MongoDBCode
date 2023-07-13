package com.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableMongoRepositories("com.mongodb.dto")
public class MongoDbCrudOperationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDbCrudOperationsApplication.class, args);
	}

}
