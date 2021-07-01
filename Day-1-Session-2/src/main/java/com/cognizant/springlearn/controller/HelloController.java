package com.cognizant.springlearn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	/*
	 * @URL: http://localhost:8080/hello
	 */
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World";
	}
}
