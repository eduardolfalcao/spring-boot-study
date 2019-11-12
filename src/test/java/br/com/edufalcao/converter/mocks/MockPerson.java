package br.com.edufalcao.converter.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.edufalcao.data.model.Person;
import br.com.edufalcao.data.vo.v1.PersonVO;

public class MockPerson {
	
	public Person mockEntity() {
		return mockEntity(0);
	}
	
	public PersonVO mockVO() {
		return mockV0(0);
	}
	
	public List<Person> mockEntityList() {
		List<Person> persons = new ArrayList<Person>();
		for(int i = 0; i < 10; i++) {
			persons.add(mockEntity(i));
		}
		return persons;
	}
	
	public List<PersonVO> mockVOList() {
		List<PersonVO> persons = new ArrayList<PersonVO>();
		for(int i = 0; i < 10; i++) {
			persons.add(mockV0(i));
		}
		return persons;
	}
	
	private Person mockEntity(long id) {
		Person p = new Person();
		p.setAddress("Fifth Avenue, "+id);
		p.setFirstName("Fisrt name test "+id);
		p.setFirstName("Last name test "+id);
		p.setId(id);
		return p;
	}
	
	private PersonVO mockV0(long id) {
		PersonVO p = new PersonVO();
		p.setAddress("Fifth Avenue, "+id);
		p.setFirstName("Fisrt name test "+id);
		p.setFirstName("Last name test "+id);
		p.setKey(id);
		return p;
	}

}
