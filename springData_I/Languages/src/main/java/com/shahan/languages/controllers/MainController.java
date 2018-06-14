package com.shahan.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shahan.languages.models.Language;
import com.shahan.languages.services.LanguageService;

@Controller
public class MainController {
	private final LanguageService languageService;
	
	public MainController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("/languages")
	public String index(@ModelAttribute("languageToAdd") Language language, Model model) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		return "/languages/index.jsp";
	}
	
	@RequestMapping(value="/languages", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("languageToAdd") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/languages";
		} else {
        languageService.createLanguage(language);
        return "redirect:/languages";
		}
	}
	
	@RequestMapping("/languages/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";
	}
	
	@RequestMapping("/languages/edit/{id}")
	public String edit(@ModelAttribute("languageToEdit") Language language, @PathVariable("id") Long id, Model model) {
		Language currLang = languageService.findLanguage(id);
		model.addAttribute("id", id);
		model.addAttribute("name", currLang.getName());
		model.addAttribute("creator", currLang.getCreator());
		model.addAttribute("currentVersion", currLang.getCurrentVersion());
		return "/languages/edit.jsp";
	}
	
	@RequestMapping(value="/languages/edit/{id}", method=RequestMethod.POST)
	public String editProcess(@Valid @ModelAttribute("languageToEdit") Language language, BindingResult result, @PathVariable("id") Long id) {
		if (result.hasErrors()) {
			return "redirect:/languages/edit/"+id;
		} else {
			String name = language.getName();
			String creator = language.getCreator();
			String currentVersion = language.getCurrentVersion();
			languageService.updateLanguage(id, name, creator, currentVersion);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping("/languages/{id}")
	public String language(@PathVariable("id") Long id, Model model) {
		Language currLang = languageService.findLanguage(id);
		model.addAttribute("id", id);
		model.addAttribute("name", currLang.getName());
		model.addAttribute("creator", currLang.getCreator());
		model.addAttribute("currentVersion", currLang.getCurrentVersion());
		return "/languages/language.jsp";
	}
    

}
