package com.shahan.dojooverview.services;

import org.springframework.stereotype.Service;

import com.shahan.dojooverview.models.Answer;
import com.shahan.dojooverview.repositories.AnswerRepository;

@Service
public class AnswerService {
	private final AnswerRepository answerRepository;
	
	public AnswerService(AnswerRepository answerRepository) {
		this.answerRepository = answerRepository;
	}
	
	public void createAnswer(Answer answer) {
		this.answerRepository.save(answer);
	}

}
