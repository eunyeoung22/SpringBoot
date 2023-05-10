package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"user.controller", "user.service"})
@EntityScan("user.bean")
@EnableJpaRepositories("user.dao")
public class Chapter04JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chapter04JpaApplication.class, args);
	}

}
