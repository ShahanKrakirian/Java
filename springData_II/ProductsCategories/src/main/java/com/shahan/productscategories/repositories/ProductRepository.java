package com.shahan.productscategories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shahan.productscategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	
	List<Product> findAll();
	
	Optional<Product> findById(Long id);
		
	void deleteById(Long id);
	
	List<Product> findAllByNameNotIn(List<String> names);

}
