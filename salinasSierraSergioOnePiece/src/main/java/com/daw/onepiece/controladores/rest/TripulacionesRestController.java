package com.daw.onepiece.controladores.rest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daw.onepiece.dtos.TripulacionDTO;
import com.daw.onepiece.servicio.interfaces.ITripulacionService;



@RestController
@RequestMapping("/v1")
public class TripulacionesRestController {
	@Autowired
	private ITripulacionService tripulacionesService;

	// Obtener todas las triopulaciones
	@GetMapping("/tripulaciones")
	public Iterable<TripulacionDTO> listarTodasTripulaciones() {
		return tripulacionesService.BuscarTripulacionPorFiltros(null, null, null, null);
	}
}
