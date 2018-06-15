package com.shahan.productscategories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shahan.productscategories.models.CategoryProduct;
import com.shahan.productscategories.repositories.MixRepository;

@Service
public class MixService {
	private final MixRepository mixRepository;
	
	public MixService(MixRepository mixRepository) {
		this.mixRepository = mixRepository;
	}
	
	public List<CategoryProduct> getAssociatedProducts(Long id) {
		return this.mixRepository.findAllByproduct_id(id);
	}

	public void save(CategoryProduct product) {
		this.mixRepository.save(product);
	}
	
	

	
}
