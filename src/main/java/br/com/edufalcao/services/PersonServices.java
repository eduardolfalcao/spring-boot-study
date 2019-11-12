package br.com.edufalcao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.edufalcao.converter.DozerConverter;
import br.com.edufalcao.converter.custom.PersonConverter;
import br.com.edufalcao.data.model.Person;
import br.com.edufalcao.data.vo.v1.PersonVO;
import br.com.edufalcao.data.vo.v2.PersonVOV2;
import br.com.edufalcao.repository.PersonRepository;

@Service
public class PersonServices {

	@Autowired
	PersonRepository repository;
		
	public PersonVO create(PersonVO pVO) {
		Person p = DozerConverter.parseObject(pVO, Person.class);
		return DozerConverter.parseObject(repository.saveAndFlush(p),PersonVO.class);
	}
	
	public PersonVOV2 create(PersonVOV2 pVOV2) {
		Person p = PersonConverter.convertVoToEntity(pVOV2);
		return PersonConverter.convertEntityToVO(repository.saveAndFlush(p));
	}
	
	public List<PersonVO> findAll(){
		return DozerConverter.parseObject(repository.findAll(),PersonVO.class);
	}
	
	public PersonVO findById(long id) {
		Person p = repository.findById(id).orElseThrow(() 
				-> new ResourceNotFoundException("No records found for this id: "+ id));
		return DozerConverter.parseObject(p,PersonVO.class);
	}
	
	public void delete(long id) {
		Person p = repository.findById(id).orElseThrow(() 
				-> new ResourceNotFoundException("No records found for this id: "+ id));
		repository.delete(p);		
	}
	
	public PersonVO update(PersonVO p) {
		Person updated = repository.findById(p.getKey()).orElseThrow(() 
				-> new ResourceNotFoundException("No records found for this id: "+ p.getKey()));
		updated.setFirstName(p.getFirstName());
		updated.setLastName(p.getLastName());
		updated.setBirth(p.getBirth());
		updated.setAddress(p.getAddress());
		return DozerConverter.parseObject(repository.save(updated),PersonVO.class);
	}
	
}
