package com.shahan.dojooverview.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shahan.dojooverview.models.Tag;
import com.shahan.dojooverview.repositories.TagRepository;

@Service 
public class TagService {
	private final TagRepository tagRepository;
	
	public TagService(TagRepository tagRepository) {
		this.tagRepository = tagRepository;
	}
	
	public List<Tag> allTags(){
		return this.tagRepository.findAll();
	}
	
	public Tag createTag(Tag tag) {
		return this.tagRepository.save(tag);
	}
	
	public Tag getTagWithName(String name) {
		return this.tagRepository.findBysubject(name);
	}

}
