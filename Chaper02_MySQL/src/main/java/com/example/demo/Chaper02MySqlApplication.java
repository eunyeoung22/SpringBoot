package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"person.controller","person.bean","person.service","person.dao"})
public class Chaper02MySqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chaper02MySqlApplication.class, args);
	}

}
