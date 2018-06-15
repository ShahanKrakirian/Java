package com.shahan.productscategories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shahan.productscategories.models.CategoryProduct;

@Repository
public interface MixRepository extends CrudRepository<CategoryProduct, Long>{
	
	List<CategoryProduct> findAll();
	
	Optional<CategoryProduct> findById(Long id);
		
	void deleteById(Long id);
	
	List<CategoryProduct> findAllByproduct_id(Long id);
	

}
