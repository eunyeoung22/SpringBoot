package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chaper01GradleApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chaper01GradleApplication.class, args);
		
		SpringApplication springApplication = new SpringApplication(Chaper01GradleApplication.class);
		springApplication.setWebApplicationType(WebApplicationType.NONE);
		springApplication.run(args);
	}

}
