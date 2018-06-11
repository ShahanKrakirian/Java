package com.example.thecode;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/code")
	public String correct() {
		return "correct.jsp";
	}
	
	@RequestMapping("/Whoops")
	public String error(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("error", "Nope!");
		return "redirect:/";
	}
	
	@RequestMapping(value="/check", method=RequestMethod.POST)
	public String test(@RequestParam(value="guess") String guess, Model model) {
		if (guess.equals("bushido")) {
			return "redirect:/code";
		}
		model.addAttribute("problem", "Nope!");
		return "redirect:/Whoops";
	}
	
}
