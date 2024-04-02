package com.github.hvalmer.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.hvalmer.exceptions.ResourceNotFoundException;
import com.github.hvalmer.model.Person;
import com.github.hvalmer.repositories.PersonRepository;

@Service
public class PersonServices  {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	public List<Person> findAll() {
		
		//implementando mensagem no log 
		logger.info("Finding all people!");
				
		return repository.findAll() ;
	}
		
	
	public Person findById(Long id) {
		
		//implementando mensagem no log 
		logger.info("Finding one person!");
						
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found this ID"));
	}
	
	public Person create(Person person) {
		
		//implementando mensagem no log 
		logger.info("Creating one person!");
		
		return repository.save(person);
	}
	
	public Person update(Person person) {
		
		//implementando mensagem no log 
		logger.info("Updating one person!");
		
		var entity =repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found this ID"));
	
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repository.save(person);
	}
	
	public void delete(Long id) {
		
		//implementando mensagem no log 
		logger.info("Deleting one person!");
		
		var entity =repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found this ID"));
		repository.delete(entity);
	}
	
}
