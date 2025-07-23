package com.example.hoche;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HocheApplication {

	public static void main(String[] args) {

		SpringApplication.run(HocheApplication.class, args);
		System.out.println("Server run at: http://localhost:8080");
	}
}
