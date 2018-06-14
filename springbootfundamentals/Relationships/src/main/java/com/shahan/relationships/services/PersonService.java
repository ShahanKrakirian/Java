package com.shahan.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shahan.relationships.models.Person;
import com.shahan.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public Person createPerson(Person person) {
		return personRepository.save(person);
	}
	
	public List<Person> allPeople(){
		return personRepository.findAll();
	}
	
	public Person findPerson(Long id) {
		Optional<Person> optionalPerson = personRepository.findById(id);
		if(optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            return null;
        }
	}
}
