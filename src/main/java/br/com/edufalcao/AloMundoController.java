package br.com.edufalcao;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AloMundoController {
	
	private long id = 0;
	
	@RequestMapping("/aloMundo")
	public AloMundo exibeMensagem(@RequestParam(value="msg", defaultValue="Ola mundo!") String msg) {
		return new AloMundo(++id, msg);
	}

}
