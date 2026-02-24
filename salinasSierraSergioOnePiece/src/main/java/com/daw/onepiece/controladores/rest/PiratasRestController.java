package com.daw.onepiece.controladores.rest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daw.onepiece.dtos.PirataDTO;
import com.daw.onepiece.servicio.interfaces.IPirataService;



@RestController
@RequestMapping("/v1")
public class PiratasRestController {
	
	@Autowired
	private IPirataService piratasService;
	
	// Obtener todos los piratas
	@GetMapping("/piratas")
	public Iterable<PirataDTO> listarTodosPiratas() {
		return piratasService.BuscarPirataPorFiltro(null, null, null, null);
	}
	
	

}
