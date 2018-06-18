package com.shahan.dojooverview.controllers;

import org.springframework.stereotype.Controller;

import com.shahan.dojooverview.services.TagService;

@Controller
public class TagController {
	private final TagService tagService;
	
	public TagController(TagService tagService) {
		this.tagService = tagService;
	}

}
