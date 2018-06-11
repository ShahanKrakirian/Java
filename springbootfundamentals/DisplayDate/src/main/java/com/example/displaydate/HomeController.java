package com.example.displaydate;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		Date today = new java.util.Date();
		model.addAttribute("date", today);
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		Date today = new java.util.Date();
		model.addAttribute("time", today);
		return "time.jsp";
	}
}
