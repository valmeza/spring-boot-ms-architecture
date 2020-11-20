package com.example.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class UserCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserCrudApplication.class, args);
	}

}
