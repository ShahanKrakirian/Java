package com.shahan.productscategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shahan.productscategories.models.Product;
import com.shahan.productscategories.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public Product createProduct(Product product) {
		return this.productRepository.save(product);
	}

	public List<Product> findAll() {
		return this.productRepository.findAll();
	}

	public Product findById(Long id) {
		Optional<Product> optionalProduct = this.productRepository.findById(id);
		if(optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            return null;
        }
	}
	
	public List<Product> findOthers(List<String> names){
		return this.productRepository.findAllByNameNotIn(names);
	}

}
