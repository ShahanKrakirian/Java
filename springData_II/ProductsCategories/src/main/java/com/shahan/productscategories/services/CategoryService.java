package com.shahan.productscategories.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shahan.productscategories.models.Category;
import com.shahan.productscategories.models.Product;
import com.shahan.productscategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public Category createCategory(Category category) {
		return this.categoryRepository.save(category);
	}

	public Category findById(Long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if(optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            return null;
        }
		
	}

	public List<Category> findAll() {
		return this.categoryRepository.findAll();
	}
	
	public List<Category> findOthers(List<String> names){
		return this.categoryRepository.findAllByNameNotIn(names);
	}

}
