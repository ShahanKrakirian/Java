package com.shahan.productscategories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shahan.productscategories.models.Category;
import com.shahan.productscategories.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
	
	List<Category> findAll();
	
	Optional<Category> findById(Long id);
		
	void deleteById(Long id);

	List<Category> findAllByNameNotIn(List<String> names);

}
