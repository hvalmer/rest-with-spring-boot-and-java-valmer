package com.github.hvalmer.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.hvalmer.data.vo.v1.PersonVO;
import com.github.hvalmer.data.vo.v2.PersonVOV2;
import com.github.hvalmer.exceptions.ResourceNotFoundException;
import com.github.hvalmer.mapper.DozerMapper;
import com.github.hvalmer.mapper.custom.PersonMapper;
import com.github.hvalmer.model.Person;
import com.github.hvalmer.repositories.PersonRepository;

@Service
public class PersonServices  {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;

	@Autowired
	PersonMapper mapper;
	
	public List<PersonVO> findAll() {
		
		//implementando mensagem no log 
		logger.info("Finding all people!");
				
		return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class)  ;
	}
		
	
	public PersonVO findById(Long id) {
		
		//implementando mensagem no log 
		logger.info("Finding one person!");
						
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found this ID"));
		//convertendo para VO
		return DozerMapper.parseObject(entity, PersonVO.class);
	}
	
	/*recebe um VO, 
	 *converte para uma entidade do tipo person,
	 *salva no BD,
	 *pega o resultado, passando para um objeto vo*/
	public PersonVO create(PersonVO person) {
		
		//implementando mensagem no log 
		logger.info("Creating one person!");
		var entity = DozerMapper.parseObject(person, Person.class);
		//retornando VO novamente
		var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	/*recebe um VO, 
	 *converte para uma entidade do tipo person,
	 *salva no BD,
	 *pega o resultado, passando para um objeto vo*/
	public PersonVOV2 createV2(PersonVOV2 person) {
		
		//implementando mensagem no log 
		logger.info("Creating one person with V2!");
		var entity = mapper.convertVoToEntity(person);
		//retornando VO novamente
		var vo = mapper.convertEntityToVo(repository.save(entity));
		return vo;
	}
	
	public PersonVO update(PersonVO person) {
		
		//implementando mensagem no log 
		logger.info("Updating one person!");
		
		var entity =repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found this ID"));
	
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		
		//implementando mensagem no log 
		logger.info("Deleting one person!");
		
		var entity =repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found this ID"));
		repository.delete(entity);
	}
	
}
