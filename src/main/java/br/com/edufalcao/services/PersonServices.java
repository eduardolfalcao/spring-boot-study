package br.com.edufalcao.services;

import java.util.Calendar;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.edufalcao.model.Person;

@Service
public class PersonServices {

	private final AtomicLong counter = new AtomicLong();
	
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
	
}
