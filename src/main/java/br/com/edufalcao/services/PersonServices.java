package br.com.edufalcao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.edufalcao.data.model.Person;
import br.com.edufalcao.repository.PersonRepository;

@Service
public class PersonServices {

	@Autowired
	PersonRepository repository;
	
	public Person create(Person p) {		
		return repository.saveAndFlush(p);
	}
	
	public List<Person> findAll(){
		return repository.findAll();
	}
	
	public Person findById(long id) {
		Optional<Person> p = repository.findById(id);
		return p.orElseThrow(() -> new ResourceNotFoundException("No records found for this id: "+ id));
	}
	
	public void delete(long id) {
		Person p = repository.findById(id).orElseThrow(() 
				-> new ResourceNotFoundException("No records found for this id: "+ id));
		repository.delete(p);		
	}
	
	public Person update(Person p) {
		Person updated = repository.findById(p.getId()).orElseThrow(() 
				-> new ResourceNotFoundException("No records found for this id: "+ p.getId()));
		updated.setFirstName(p.getFirstName());
		updated.setLastName(p.getLastName());
		updated.setBirth(p.getBirth());
		updated.setAddress(p.getAddress());
		repository.save(updated);
		return updated;
	}
	
}
