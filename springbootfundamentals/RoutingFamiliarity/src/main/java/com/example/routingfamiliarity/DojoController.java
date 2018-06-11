package com.example.routingfamiliarity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	
	@RequestMapping("{dojo}")
	public String awesome(@PathVariable("dojo") String thing) {
		return "The " + thing + " is awesome!";
	}
	
	@RequestMapping("{burbank}-dojo/")
	public String place(@PathVariable("burbank") String location) {
		return location + " dojo is located in Southern California";
	}
	
	@RequestMapping("{san}-jose/")
	public String headquarters(@PathVariable("san") String san) {
		return "SJ dojo is the headquarters.";
	}
}
