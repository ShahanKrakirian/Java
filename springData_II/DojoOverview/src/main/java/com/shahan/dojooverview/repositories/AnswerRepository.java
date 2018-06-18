package com.shahan.dojooverview.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shahan.dojooverview.models.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long>{

}
