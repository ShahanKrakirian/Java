package com.shahan.dojooverview.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shahan.dojooverview.models.Answer;
import com.shahan.dojooverview.models.Question;
import com.shahan.dojooverview.models.Tag;
import com.shahan.dojooverview.services.QuestionService;
import com.shahan.dojooverview.services.TagService;

@Controller
@RequestMapping("/questions")
public class QuestionController {
	private final QuestionService questionService;
	private final TagService tagService;
	
	public QuestionController(QuestionService questionService, TagService tagService) {
		this.questionService = questionService;
		this.tagService = tagService;
	}
	
	@RequestMapping
	public String index(Model model) {
		
		//Get all question objects.
		List<Question> allQuestions = questionService.findAll();
		ArrayList<ArrayList<String>> tagLists = new ArrayList<ArrayList<String>>();
		
		//For each question...
		for (int i=0; i<allQuestions.size(); i++) {
			
			//Get its tag list
			List<Tag> tags = allQuestions.get(i).getTags();
			ArrayList<String> stringList = new ArrayList<String>();
			String stringToAdd;
			String addMe;			
						
			//Then put those tags into a string and add it to "tag lists"
			for (int j=0; j<tags.size(); j++) {
				stringToAdd = "";
				addMe = tags.get(j).getSubject();
				stringToAdd = stringToAdd + addMe;
				stringList.add(stringToAdd);
			}
			tagLists.add(stringList);
		}
		
		model.addAttribute("questions", allQuestions);
		model.addAttribute("tagLists", tagLists);
		
		return "/dojooverview/index.jsp";
	}
	
	@RequestMapping("/new")
	public String newQuestion(@ModelAttribute("questionToAdd") Question question) {
		return "/dojooverview/newQuestion.jsp";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String newQuestionProcess(@Valid @ModelAttribute("questionToAdd") Question question, BindingResult result, @RequestParam("tagss") String tags, Model model) {
		//If errors
		if (result.hasErrors()) {
			return "/dojooverview/newQuestion.jsp";
		} else {
			
			//Create question and add it to an array list
			Question questionToAdd = questionService.createQuestion(question);
			ArrayList<Question> addToTag = new ArrayList<Question>();
			addToTag.add(questionToAdd);
			
			
			//See if tag list is longer than 3. If so, show error.
			List<String> submittedTags = (List<String>) Arrays.asList(tags.split(","));
			if (submittedTags.size()>3) {
				model.addAttribute("errors", "Please enter no more than 3 tags.");
				return "/dojooverview/newQuestion.jsp";
				
			} else {
				if (submittedTags.size() != 0) {
	
					//Create list of all tag names
					List<Tag> allTags = tagService.allTags();
					ArrayList<String> allTagNames = new ArrayList<String>();
					for (int i=0; i<allTags.size(); i++) {
						allTagNames.add(allTags.get(i).getSubject());
					}
					
					ArrayList<Tag> tagsToAddToQuestion = new ArrayList<Tag>();
					
					//Now, check against submitted tags.
					for (int j=0; j<submittedTags.size(); j++) {
						
						//If the submitted tag doesn't exist, create it with the subject and question.
						if (!allTagNames.contains(submittedTags.get(j))) {
							Tag tag = new Tag(submittedTags.get(j), addToTag);
							Tag tagToAdd = tagService.createTag(tag);
							tagsToAddToQuestion.add(tagToAdd);
						} else {
							Tag sometag = tagService.getTagWithName(submittedTags.get(j));
							tagsToAddToQuestion.add(sometag);
						}
						questionToAdd.setTags(tagsToAddToQuestion);
						questionService.createQuestion(questionToAdd);
					}
					return "redirect:/questions";
				}
				return "redirect:/questions";
			}
		}
	}
	
	@RequestMapping("/{id}")
	public String question(@ModelAttribute("answerToAdd") Answer answer, @PathVariable("id") Long id, Model model) {
		
		//Get question.
		Question currQuestion = questionService.findById(id);
		
		//Get tags.
		List<Tag> tags = currQuestion.getTags();
		ArrayList<String> tagString = new ArrayList<String>();
		
		for (int i=0; i<tags.size(); i++) {
			tagString.add(String.join(" ", tags.get(i).getSubject()));
		}
		
		List<Answer> answers = currQuestion.getAnswers();
		
		model.addAttribute("answers", answers); //Change this
		model.addAttribute("tags", tagString);
		model.addAttribute("currQuestion", currQuestion);
		return "/dojooverview/question.jsp";
	}

}
