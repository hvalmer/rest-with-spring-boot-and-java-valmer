package com.github.hvalmer.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.github.hvalmer.model.Person;

@Service
public class PersonServices  {


	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public List<Person> findAll() {
		
		//implementando mensagem no log 
		logger.info("Finding all people!");
		
		//declarando uma listagem de pessoas
		List<Person> persons = new ArrayList<>();
		//iterando num array de 0-8 e mockando cada pessoa dessa lista
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			//adicionando a pessoa na listagem
			persons.add(person);
		}
		return persons ;
	}
		
	
	public Person findById(String id) {
		
		//implementando mensagem no log 
		logger.info("Finding one person!");
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Harlan");
		person.setLastName("Goyana");
		person.setAddress("Belém - Pará - Brasil");
		person.setGender("Male");
		
		return person;
	}
	
	public Person create(Person person) {
		
		//implementando mensagem no log 
		logger.info("Creating one person!");
		
		return person;
	}
	
	public Person update(Person person) {
		
		//implementando mensagem no log 
		logger.info("Updating one person!");
		
		return person;
	}
	
	public void delete(String id) {
		
		//implementando mensagem no log 
		logger.info("Deleting one person!");
	}
	
		private Person mockPerson(int i) {
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name " + i);
		person.setLastName("Last name " + i);
		person.setAddress("Some address in Brasil " + i);
		person.setGender("Male");
		
		return person;
	}
	
}
