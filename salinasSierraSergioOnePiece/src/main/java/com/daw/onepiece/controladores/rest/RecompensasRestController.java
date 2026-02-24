package com.daw.onepiece.controladores.rest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daw.onepiece.dtos.RecompensaDTO;
import com.daw.onepiece.servicio.interfaces.IRecompensaService;



@RestController
@RequestMapping("/v1")
public class RecompensasRestController {
	
	@Autowired
	private IRecompensaService recompensasService;
	
	// Obtener todos las recompensas
		@GetMapping("/recompensas")
		public Iterable<RecompensaDTO> listarTodasRecompensas() {
			return recompensasService.BuscarRecompensaPorFiltro(null, null, null, null, null);
		}
		

}
