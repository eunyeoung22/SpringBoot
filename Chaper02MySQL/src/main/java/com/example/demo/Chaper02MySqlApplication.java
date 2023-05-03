package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages ={"main.controller", "user.controller", "user.service", "user.dao", "user.bean"})
@ComponentScan(basePackages = {"main.controller", "user.*"})
public class Chaper02MySqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chaper02MySqlApplication.class, args);
	}

}
