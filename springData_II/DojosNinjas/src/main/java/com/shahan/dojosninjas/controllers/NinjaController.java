package com.shahan.dojosninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shahan.dojosninjas.models.Dojo;
import com.shahan.dojosninjas.models.Ninja;
import com.shahan.dojosninjas.services.DojoService;
import com.shahan.dojosninjas.services.NinjaService;

@Controller
public class NinjaController {
	private final NinjaService ninjaService;
	private final DojoService dojoService;
	
	public NinjaController(NinjaService ninjaService, DojoService dojoService) {
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
	}
	
	@RequestMapping("/ninjas/new")
	public String home(@ModelAttribute("ninjaToAdd") Ninja ninja, Model model) {
		List<Dojo> dojos = dojoService.findAll();
		System.out.println(dojos);
		model.addAttribute("dojos", dojos);
		return "/dojosninjas/newNinja.jsp";
	}
	
	@RequestMapping(value="/ninjas/new", method=RequestMethod.POST)
	public String createNinjaProcess(@Valid @ModelAttribute("ninjaToAdd") Ninja ninja, BindingResult result) {
		if (result.hasErrors()){
			return "/dojosninjas/newNinja.jsp";
		} else {
			ninjaService.createNinja(ninja);
			return "redirect:/ninjas/new";
		}
	}

}
