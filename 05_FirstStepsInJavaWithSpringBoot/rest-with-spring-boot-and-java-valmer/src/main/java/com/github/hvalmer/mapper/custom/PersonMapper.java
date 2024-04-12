package com.github.hvalmer.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.github.hvalmer.data.vo.v2.PersonVOV2;
import com.github.hvalmer.model.Person;

@Service
public class PersonMapper {

	public PersonVOV2 convertEntityToVo(Person person) {
		//criando uma instancia de VO
		PersonVOV2 vo = new PersonVOV2();
		vo.setId(person.getId());
		vo.setAddress(person.getAddress());
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		vo.setBirthDay(new Date());
		vo.setGender(person.getGender());
		return vo;
	}
	
	//convertendo PersonVO para entidades
	public Person convertVoToEntity(PersonVOV2 person) {
		//criando uma instancia de VO
		Person entity = new Person();
		entity.setId(person.getId());
		entity.setAddress(person.getAddress());
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		//vo.setBirthDay(new Date());
		entity.setGender(person.getGender());
		return entity;
	}
	
}
