package com.shahan.dojosninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shahan.dojosninjas.models.Dojo;
import com.shahan.dojosninjas.models.Ninja;
import com.shahan.dojosninjas.services.DojoService;

@Controller
public class DojoController {
	private final DojoService dojoService;
	
	public DojoController(DojoService dojoService) {
		this.dojoService = dojoService;
	}
	
	@RequestMapping("/dojos/new")
	public String home(@ModelAttribute("dojoToAdd") Dojo dojo) {
		return "/dojosninjas/newDojo.jsp";
	}
	
	@RequestMapping(value="/dojos/new", method=RequestMethod.POST)
	public String createDojoProcess(@Valid @ModelAttribute("dojoToAdd") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "/dojosninjas/newDojo.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/dojos/new";
		}
	}
	
	@RequestMapping("/dojos/{id}")
	public String dojoDetails(@PathVariable("id") Long id, Model model) {
		Dojo currDojo = dojoService.findDojo(id);
		List<Ninja> ninjas = currDojo.getNinjas();
		model.addAttribute("ninjas", ninjas);
		model.addAttribute("dojo", currDojo);
		return "/dojosninjas/showDojo.jsp";
	}
	
	

}
