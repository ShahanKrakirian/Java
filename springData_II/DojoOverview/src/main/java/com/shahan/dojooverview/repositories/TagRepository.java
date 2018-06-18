package com.shahan.dojooverview.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shahan.dojooverview.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long>{
	
	List<Tag> findAll();

	Tag findBysubject(String name);

}
