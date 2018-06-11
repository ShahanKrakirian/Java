package com.example.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@RequestMapping("/")
	public String welcome(@RequestParam(value="name", required=false) String name) {
		if (name == null) {
			return "<h1>Hello Human!</h1>Welcome to SpringBoot!";
		} else {
			return "<h1>Hello " + name + "!</h1>Welcome to SpringBoot!";
		}
	}
}
