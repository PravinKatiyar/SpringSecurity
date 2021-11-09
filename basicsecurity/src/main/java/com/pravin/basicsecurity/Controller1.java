package com.pravin.basicsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller1 {

	@GetMapping("/sayHello")
	public String hello() {
		return "saying, hello";
	}

}
