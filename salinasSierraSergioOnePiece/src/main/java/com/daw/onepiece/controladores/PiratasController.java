package com.daw.onepiece.controladores;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daw.onepiece.dtos.PirataDTO;


@Controller
@RequestMapping("/piratas")
public class PiratasController {
	
	@GetMapping("/listadoPiratas")
	public String formularioListarPiratas(ModelMap model) {
		
		return "piratas/listadoPiratas";
	}
	
	@PostMapping("/listadoMatriculaciones")
	public String formularioListarMatriculaRespuesta(
			@RequestParam(value = "nombreAsignatura", required = false) String nombreAsignatura,
			@RequestParam(value = "nombreAlumno", required = false) String nombreAlumno,
			@RequestParam(value = "fecha", required = false) String fecha,
			@RequestParam(value = "activo", required = false) Integer activo, ModelMap model) {
		if (fecha != null && fecha.isBlank())
			fecha = null;

		ArrayList<PirataDTO> listaPiratas = matriculaService.BuscarMatriculaPorFiltro(nombreAsignatura,
				nombreAlumno, fecha, activo);
		model.addAttribute("lista", listaPiratas);
		return "matriculaciones/listadoMatriculaciones";
	}
}