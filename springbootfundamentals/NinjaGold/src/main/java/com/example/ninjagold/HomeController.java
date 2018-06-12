package com.example.ninjagold;

import java.util.ArrayList;
import java.util.Random;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		
		//Initialize session if needed.
		if (session.getAttribute("messages") == null) {
			ArrayList<String> messages = new ArrayList<String>();
			session.setAttribute("messages", messages);
			session.setAttribute("gold", 0);
		}
		
		//Get current values.
		ArrayList<String> currentList = (ArrayList<String>) session.getAttribute("messages");
		int currentAmount = (int) session.getAttribute("gold");
		
		model.addAttribute("messages", currentList);
		model.addAttribute("gold", currentAmount);
		
		return "index.jsp";
	}
	
	@RequestMapping("/calculate")
	public String calculate(@RequestParam("location") String location, Model model, HttpSession session) {
		
		//Get current values.
		ArrayList<String> currentList = (ArrayList<String>) session.getAttribute("messages");
		int currentAmount = (int) session.getAttribute("gold");
		
		Random random = new Random();
		
		if (location.equals("farm")) {
			int amount = random.nextInt(10) + 10;
			String message = "Wahoo! Dug up " + amount + " gold from the ground!";
			currentAmount += amount;
			currentList.add(0, message);
		}
		if (location.equals("cave")) {
			int amount = random.nextInt(5) + 5;
			String message = "Wahoo! Found " + amount + " gold in the depths of the cave!";
			currentList.add(0, message);
			currentAmount += amount;
		}
		if (location.equals("house")) {
			int amount = random.nextInt(3) + 2;
			String message = "Wahoo! Grandma gave you " + amount + " gold!";
			currentList.add(0, message);
			currentAmount += amount;
		}
		if (location.equals("casino")) {
			int rand1 = random.nextInt(50) * -1;
			int rand2 = random.nextInt(50);
			int amount = rand1 + rand2;
			if (amount >= 0) {
				String message = "Lucky you! " + amount + " gold... be careful...";
				currentList.add(0, message);
				currentAmount += amount;
				
			} else {
				String message = "Hmm... lost " + amount + " gold... maybe you can win it back!";
				currentList.add(0, message);
				currentAmount += amount;
			}
		}
		session.setAttribute("gold", currentAmount);
		session.setAttribute("messages", currentList);
		
		return "redirect:/";
	}
}
