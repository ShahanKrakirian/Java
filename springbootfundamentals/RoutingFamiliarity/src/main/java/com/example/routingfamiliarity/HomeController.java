package com.example.routingfamiliarity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coding")
public class HomeController {

	@RequestMapping("")
	public String welcome() {
		return "Hello coding dojo!";
	}
	
	@RequestMapping("/python")
	public String python() {
		return "Python/Django was sweeeeeet.";
	}
	@RequestMapping("/java")
	public String java() {
		return "Java/Spring is better!";
	}

}
