package com.shahan.relationships.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shahan.relationships.models.License;
import com.shahan.relationships.models.Person;
import com.shahan.relationships.services.LicenseService;
import com.shahan.relationships.services.PersonService;

@Controller
@RequestMapping("/persons")
public class PersonController {
	private final PersonService personService;
	private final LicenseService licenseService;
	
	public PersonController(PersonService personService, LicenseService licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}

	@RequestMapping("/new")
	public String newPerson(@ModelAttribute("personToAdd") Person person) {
		return "/relationships/newPerson.jsp";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String newPersonProcess(@Valid @ModelAttribute("personToAdd") Person person, BindingResult result) {
		if (result.hasErrors()){
			return "/persons/newPerson.jsp";
		} else {
			personService.createPerson(person);
			return "redirect:/persons/new";
		}
	}
	
	@RequestMapping("/{id}")
	public String showPerson(@PathVariable("id") Long id, Model model) {
		
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		
		Person currPerson = personService.findPerson(id);
		License license = currPerson.getLicense();
		Date date = license.getExpiration_date();
		String expireDate = df.format(date);
		
		model.addAttribute("expireDate", expireDate);
		model.addAttribute("license", license);
		model.addAttribute("person", currPerson);
		return "/relationships/showPerson.jsp";
	}
}
