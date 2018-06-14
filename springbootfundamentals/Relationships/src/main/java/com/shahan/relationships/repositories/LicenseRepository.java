package com.shahan.relationships.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shahan.relationships.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long>{

	List<License> findAll();
	
	Optional<License> findById(Long id);
		
	void deleteById(Long id);
	
	Optional<License> findFirstByOrderByIdDesc();
	
}
