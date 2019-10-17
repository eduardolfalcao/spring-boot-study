package br.com.edufalcao;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Calculator {
	
	/*@RequestMapping("/sum")
	public int sum(@RequestParam(value="v1") int v1, @RequestParam(value="v2") int v2) {
		return v1+v2;
	}
	
	@RequestMapping("/sub")
	public int sub(@RequestParam(value="v1") int v1, @RequestParam(value="v2") int v2) {
		return v1-v2;
	}
	
	@RequestMapping("/mult")
	public int mult(@RequestParam(value="v1") int v1, @RequestParam(value="v2") int v2) {
		return v1*v2;
	}
	
	@RequestMapping("/div")
	public float div(@RequestParam(value="v1") float v1, @RequestParam(value="v2") float v2) {
		return v1/v2;
	}*/
	
	@RequestMapping(value="/sum/{v1}/{v2}", method=RequestMethod.GET)
	public int sum(@PathVariable("v1") int v1, @PathVariable("v2") int v2) {
		return v1+v2;
	}
	
	@RequestMapping(value="/sub/{v1}/{v2}", method=RequestMethod.GET)
	public int sub(@PathVariable("v1") int v1, @PathVariable("v2") int v2) {
		return v1-v2;
	}
	
	@RequestMapping(value="/mult/{v1}/{v2}", method=RequestMethod.GET)
	public int mult(@PathVariable("v1") int v1, @PathVariable("v2") int v2) {
		return v1*v2;
	}
	
	@RequestMapping(value="/div/{v1}/{v2}", method=RequestMethod.GET)
	public float div(@PathVariable("v1") float v1, @PathVariable("v2") float v2) {
		return v1/v2;
	}

}

