package com.shahan.dojooverview.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shahan.dojooverview.models.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long>{
	
	List<Question> findAll();

}
