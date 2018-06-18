package com.shahan.dojooverview.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shahan.dojooverview.models.Question;
import com.shahan.dojooverview.repositories.QuestionRepository;

@Service
public class QuestionService {
	private final QuestionRepository questionRepository;
	
	public QuestionService(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}
	
	public Question createQuestion(Question question) {
		return this.questionRepository.save(question);
	}
	
	public List<Question> findAll(){
		return this.questionRepository.findAll();
	}
	
	public Question findById(Long id) {
		Optional<Question> optionalQuestion = questionRepository.findById(id);
        if(optionalQuestion.isPresent()) {
            return optionalQuestion.get();
        } else {
            return null;
        }
	}

}
