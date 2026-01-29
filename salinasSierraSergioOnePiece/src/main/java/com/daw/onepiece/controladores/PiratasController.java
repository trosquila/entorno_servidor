package com.daw.onepiece.controladores;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daw.onepiece.dao.interfaces.IPiratasDAO;
import com.daw.onepiece.dtos.PirataDTO;
import com.daw.onepiece.servicio.interfaces.IPirataService;

@Controller
@RequestMapping("/piratas")
public class PiratasController {
	
	@Autowired
	IPiratasDAO pirata;
	
	@Autowired
	IPirataService pirataService;
	
	@GetMapping("/listadoPiratas")
	public String formularioListarPiratas(ModelMap model) {
		
		return "piratas/listadoPiratas";
	}
	
	@PostMapping("/listadoPiratas")
	public String formularioListarPiratasRespueta(
			@RequestParam(value = "id", required = false) Integer idPirata,
			@RequestParam(value = "nombre", required = false) String nombrePirata,
			@RequestParam(value = "frutaDiablo", required = false) String frutaDiablo,
			@RequestParam(value = "activo", required = false) Integer activoForm, ModelMap model) {

		Boolean activo = (activoForm != null) ? (activoForm == 1) : null;
		ArrayList<PirataDTO> listaPiratas = pirataService.BuscarPirataPorFiltro(idPirata, nombrePirata, frutaDiablo, activo);
		System.out.println(listaPiratas);
		model.addAttribute("lista", listaPiratas);
		return "piratas/listadoPiratas";
	}
	
	@GetMapping("/insertarPirata")
	public String formularioInsertarPiratas(ModelMap model) {
		
		return "piratas/insertarPirata";
	}
}