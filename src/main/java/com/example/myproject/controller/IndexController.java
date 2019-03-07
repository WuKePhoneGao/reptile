package com.example.myproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class IndexController {
	/*
	@RequestMapping("/")
	String get() {
		return "Hello from get";
	}
	*/
	@RequestMapping("/index")
	String index() {
		return "Hello from index";
	}
	
	@RequestMapping(value={"","/page","page*","view/*,**/msg"})
	String indexMultipleMapping() {
		return "Hello from index multiple mapping!";
	}
}
