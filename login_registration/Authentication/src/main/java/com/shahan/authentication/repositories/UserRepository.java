package com.shahan.authentication.repositories;

import org.springframework.data.repository.CrudRepository;

import com.shahan.authentication.models.User;

public interface UserRepository extends CrudRepository<User, Long>{
	User findByEmail(String email);
}
