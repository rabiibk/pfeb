package com.example.springbootcrudapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.angular.springbootcrudapi.model")
public class SpringbootCrudApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCrudApiApplication.class, args);
	}


}
