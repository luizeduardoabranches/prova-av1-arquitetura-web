package com.example.Av1.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {"com.example"})
@EnableMongoRepositories("com.example.Av1.repository")
public class Av1Application {

	public static void main(String[] args) {
		SpringApplication.run(Av1Application.class, args);
	}

}

