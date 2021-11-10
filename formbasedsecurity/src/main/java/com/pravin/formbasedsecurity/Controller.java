package com.pravin.formbasedsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/sayHello")
	public String hello() {
		return "saying, hello";
	}

	@GetMapping("/sayBye")
	public String sayBye() {
		return "saying, Bye";
	}
}
