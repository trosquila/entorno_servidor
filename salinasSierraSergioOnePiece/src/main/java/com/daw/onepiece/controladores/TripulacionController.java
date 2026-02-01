package com.daw.onepiece.controladores;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daw.onepiece.dao.interfaces.IDesplegablesDAO;
import com.daw.onepiece.dao.interfaces.ITripulacionDAO;
import com.daw.onepiece.dtos.TripulacionDTO;
import com.daw.onepiece.servicio.interfaces.ITripulacionService;

@Controller
@RequestMapping("/tripulaciones")
public class TripulacionController {
	@Autowired
	ITripulacionService tripulacionService;
	
	@Autowired
	ITripulacionDAO tripulacionDTO;
	
	@Autowired
	IDesplegablesDAO desplegables;

	@GetMapping("/listadoTripulaciones")
	public String listadoTripulacion() {
		return "tripulaciones/listadoTripulaciones";
	}
	
	@PostMapping("/listadoTripulaciones")
	public String listadoTripulacionMostrars(
			@RequestParam(value = "id", required = false) String nombre,
			@RequestParam(value = "nombre", required = false) String nombreBarco,
			@RequestParam(value = "activo", required = false) Integer activoForm, ModelMap model) {
		
		Boolean activo = (activoForm != null) ? (activoForm == 1) : null;
		
		ArrayList<TripulacionDTO> listaTripulacion = tripulacionService.BuscarTripulacionPorFiltros(null, nombre, nombreBarco, activo);
		model.addAttribute("lista", listaTripulacion);
		return "tripulaciones/listadoTripulaciones";
	}

}
