package com.shahan.dojooverview.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shahan.dojooverview.models.Answer;
import com.shahan.dojooverview.models.Question;
import com.shahan.dojooverview.services.AnswerService;
import com.shahan.dojooverview.services.QuestionService;

@Controller
public class AnswerController {
	private final AnswerService answerService;
	private final QuestionService questionService;
	
	public AnswerController(AnswerService answerService, QuestionService questionService) {
		this.answerService = answerService;
		this.questionService = questionService;
	}
	
	@RequestMapping(value="/answer/new/{id}", method=RequestMethod.POST)
	public String addAnswer(@Valid @ModelAttribute("answerToAdd") Answer answer, BindingResult result, @PathVariable("id") Long id) {
		Question question = questionService.findById(id);
		answer.setQuestion(question);
		answerService.createAnswer(answer);
		return "redirect:/questions/" + id;
	}

}
