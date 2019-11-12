package br.com.edufalcao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edufalcao.data.vo.v1.PersonVO;
import br.com.edufalcao.data.vo.v2.PersonVOV2;
import br.com.edufalcao.services.PersonServices;

@RestController
@RequestMapping("/api/person")
public class PersonController {

	@Autowired
	private PersonServices services;
	
	@PostMapping("/v1")
	public PersonVO create(@RequestBody PersonVO p) {
		return services.create(p);
	}
	
	@PostMapping("/v2")
	public PersonVOV2 createV2(@RequestBody PersonVOV2 p) {
		return services.create(p);
	}
	
	@PutMapping("/v1")
	public PersonVO update(@RequestBody PersonVO p) {
		return services.update(p);
	}
	
	@GetMapping("/v1")
	public List<PersonVO> findAll() {
		return services.findAll();
	}
	
	@GetMapping("/v1/{id}")
	public PersonVO findById(@PathVariable("id") Long id) {
		return services.findById(id);
	}
	
	@DeleteMapping("/v1/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		services.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
