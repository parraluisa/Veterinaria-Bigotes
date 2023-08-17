package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entidad.User;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public User user(){
		return new User(
				"Juan",
				"juseanto",
				"juseanto@javeriana",
				23
		);
	}

	@Bean
	public User user2(){
		return new User(
				"Juan2",
				"juseanto2",
				"juseanto2@javeriana",
				24
		);
	}

}
