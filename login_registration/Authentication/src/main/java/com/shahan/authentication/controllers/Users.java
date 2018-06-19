package com.shahan.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shahan.authentication.models.User;
import com.shahan.authentication.services.UserService;

//imports removed for brevity
@Controller
public class Users {
	private final UserService userService;
 
	 public Users(UserService userService) {
	     this.userService = userService;
	 }
	 
	 @RequestMapping("/registration")
	 public String registerForm(@ModelAttribute("user") User user) {
	     return "/authentication/registrationPage.jsp";
	 }
	 @RequestMapping("/login")
	 public String login() {
	     return "/authentication/loginPage.jsp";
	 }
	 
	 @RequestMapping(value="/registration", method=RequestMethod.POST)
	 public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		 if (result.hasErrors()) {
			 return "/authentication/registrationPage.jsp";
		 } else {
			 userService.registerUser(user);
			 Long id = user.getId();
			 session.setAttribute("id", id);
			 return "redirect:/home";
		 }
	 }
	 
	 @RequestMapping(value="/login", method=RequestMethod.POST)
	 public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
		 if (userService.authenticateUser(email, password) == true) {
			 User currUser = userService.findByEmail(email);
			 Long id = currUser.getId();
			 session.setAttribute("id", id);
			 return "redirect:/home";
		 } else {
			 model.addAttribute("error", "Make sure you have the correct email and password!");
			 return "/authentication/loginPage.jsp";
		 }
	 }
	 
	 @RequestMapping("/home")
	 public String home(HttpSession session, Model model) {
		 Long id = (Long) session.getAttribute("id");
		 User currUser = userService.findUserById(id);
		 model.addAttribute("user", currUser);
		 return "/authentication/homePage.jsp";
	 }
	 @RequestMapping("/logout")
	 public String logout(HttpSession session) {
	     session.invalidate();
	     return "redirect:/login";
	 }
}