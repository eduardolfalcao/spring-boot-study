package br.com.edufalcao.converter.custom;

import br.com.edufalcao.data.model.Person;
import br.com.edufalcao.data.vo.v2.PersonVOV2;

public class PersonConverter {
	
	public static PersonVOV2 convertEntityToVO(Person p) {		
		PersonVOV2 vo = new PersonVOV2();
		vo.setAddress(p.getAddress());
		vo.setBirth(p.getBirth());
		vo.setName(p.getFirstName()+" "+p.getLastName());
		return vo;
	}
	
	public static Person convertVoToEntity(PersonVOV2 pvo) {		
		Person p = new Person();
		p.setAddress(pvo.getAddress());
		p.setBirth(pvo.getBirth());
		String[] names = pvo.getName().split(" ");
		if(names!=null && names.length>0) {
			p.setFirstName(names[0]);
			String lastName = "";
			for(int i = 1; i < names.length; i++) {
				lastName += " " + names[i];
			}
			p.setLastName(lastName);
		}
		return p;
	}

}
