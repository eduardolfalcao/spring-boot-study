package br.com.edufalcao.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.edufalcao.model.Person;

@Service
public class PersonServices {

	private final AtomicLong counter = new AtomicLong();
	
	public Person create(Person p) {
		//insert person into database
		return p;
	}
	
	public Person update(Person p) {
		//update person in database
		return p;
	}
	
	public void delete(String id) {
		// removes from database
	}
	
	public Person findById(String id) {
		Person p = new Person();
		p.setId(counter.incrementAndGet());
		p.setFirstName("Eduardo");
		p.setLastName("Falcao");
		Calendar cal = Calendar.getInstance();
		cal.set(1989, 8, 4);
		p.setBirth(cal.getTime());
		p.setAddress("Catolé, Campina Grande");
		return p;
	}
	
	public List<Person> findAll(){
		List<Person> persons = new ArrayList<Person>();
		for(int i = 0; i < 10; i++) {
			Person p = findById("");
			persons.add(p);
		}
		return persons;
	}
	
}
