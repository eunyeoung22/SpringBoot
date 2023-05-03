package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Controller
public class HelloController {
	
	public HelloController() {
		System.out.println("HelloController 기본생성자");
	}
	
	@GetMapping(value="/hello")
	//@ResponseBody
	public String hello(String name) {
		
		return "안녕하세요" +  name + "님";
	}

}
