package br.com.edufalcao.converter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.edufalcao.converter.mocks.MockPerson;
import br.com.edufalcao.data.model.Person;
import br.com.edufalcao.data.vo.PersonVO;

public class DozerConverterTest {
	
	MockPerson mock;
	
	@Before
	public void setup() {
		mock = new MockPerson();
	}
	
	@Test
	public void parseEntityToVOTest() {
		Person p = mock.mockEntity();
		PersonVO pVO = DozerConverter.parseObject(p, PersonVO.class);
		Assert.assertEquals(pVO.getId(),0);
		//verify other attributes
	}
	
	//create test for VO list

}
