package com.shahan.relationships.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shahan.relationships.models.License;
import com.shahan.relationships.models.Person;
import com.shahan.relationships.services.LicenseService;
import com.shahan.relationships.services.PersonService;

@Controller
@RequestMapping("/licenses")
public class LicenseController {
	private final LicenseService licenseService;
	private final PersonService personService;
	
	public LicenseController(LicenseService licenseService, PersonService personService) {
		this.licenseService = licenseService;
		this.personService = personService;
	}
	
	@RequestMapping("/new")
	public String createLicense(@ModelAttribute("licenseToAdd") License license, Model model) {
		List<Person> people = personService.allPeople();
		model.addAttribute("people", people);
		return "/relationships/newLicense.jsp";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String createLicenseProcess(@Valid @ModelAttribute("licenseToAdd") License license, BindingResult result, @RequestParam("date") String something) {
		if (result.hasErrors()){
			return "/relationships/newLicense.jsp";
		} else {
			if (licenseService.latestLicense() == null) {
				license.setNumber("1");
			} else {
				License latest = licenseService.latestLicense();
				String str = latest.getNumber();
				System.out.println(str);
				Integer num = Integer.parseInt(str);
				System.out.println(num);
				num = num + 1;
				String newNum = Integer.toString(num);
				license.setNumber(newNum);
			}
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
			Date dateToAdd;
			try {
				dateToAdd = df.parse(something);
			    license.setExpiration_date(dateToAdd);
			    licenseService.createLicense(license);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return "redirect:/licenses/new";
		}
	}

}
