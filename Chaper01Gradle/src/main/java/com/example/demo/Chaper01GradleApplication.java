package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo.controller", "board.controller"})//어노테이션이 있다라는걸 알려주기
public class Chaper01GradleApplication {

	public static void main(String[] args) {
		//SpringApplication.run(Chaper01GradleApplication.class, args);
		
		SpringApplication springApplication = new SpringApplication(Chaper01GradleApplication.class);
		springApplication.setWebApplicationType(WebApplicationType.NONE);
		springApplication.run(args); 
	}

}
