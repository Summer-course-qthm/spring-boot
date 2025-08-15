package com.example.hoche;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManagerApplication {

	public static void main(String[] args) {

		SpringApplication.run(ManagerApplication.class, args);
		System.out.println("Server run at: http://localhost:8080");
	}
}
