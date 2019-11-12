package br.com.edufalcao.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Person endpoint", description="Description for Person", tags= {"person-endpoint"})
@RestController
@RequestMapping("/api/person")
public class PersonController {

	@Autowired
	private PersonServices services;
	
	@PostMapping("/v1")
	public PersonVO create(@RequestBody PersonVO p) {
		PersonVO pVO = services.create(p);
		pVO.add(linkTo(methodOn(PersonController.class).create(p)).withSelfRel());
		return pVO;
	}
	
	@PostMapping("/v2")
	public PersonVOV2 createV2(@RequestBody PersonVOV2 p) {
		PersonVOV2 pVOV2 = services.create(p);
		pVOV2.add(linkTo(methodOn(PersonController.class).createV2(pVOV2)).withSelfRel());
		return pVOV2;
	}
	
	@PutMapping("/v1")
	public PersonVO update(@RequestBody PersonVO p) {
		PersonVO pVO = services.update(p);
		pVO.add(linkTo(methodOn(PersonController.class).create(p)).withSelfRel());
		return pVO;
	}
	
	@ApiOperation(value="Find all people")
	@GetMapping("/v1")
	public List<PersonVO> findAll() {		
		List<PersonVO> pVOList = services.findAll();
		pVOList.stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()));
		return pVOList;
	}
	
	@GetMapping("/v1/{id}")
	public PersonVO findById(@PathVariable("id") Long id) {
		PersonVO pVO = services.findById(id);
		pVO.add(linkTo(methodOn(PersonController.class).findById(pVO.getKey())).withSelfRel());
		return pVO;
	}
	
	@DeleteMapping("/v1/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		services.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
