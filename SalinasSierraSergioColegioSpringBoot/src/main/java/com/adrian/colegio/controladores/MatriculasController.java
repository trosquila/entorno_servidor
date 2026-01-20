package com.adrian.colegio.controladores;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.adrian.colegio.dao.interfaces.IDesplegablesDAO;
import com.adrian.colegio.dao.interfaces.IMatriculasDAO;
import com.adrian.colegio.dtos.MatriculaDTO;
import com.adrian.colegio.servicio.interfaces.IMatriculasService;

@Controller
@RequestMapping("/matriculaciones")
public class MatriculasController {

	@Autowired
	IDesplegablesDAO desplegables;
	
	@Autowired
	IMatriculasDAO matriculas;
	
	@Autowired
	IMatriculasService matriculaService;
	
	@GetMapping("/listadoMatriculaciones")
	public String formularioListarMatricula(ModelMap model) {

		return "matriculaciones/listadoMatriculaciones";
	}
	
	@PostMapping("/listadoMatriculaciones")
	public String formularioListarMatriculaRespuesta(
			@RequestParam(value = "nombreAsignatura", required = false) String nombreAsignatura,
			@RequestParam(value = "nombreAlumno", required = false) String nombreAlumno,
			@RequestParam(value = "fecha", required = false) String fecha,
			@RequestParam(value = "fecha", required = false) Integer activo,
			 ModelMap model) {
		ArrayList<MatriculaDTO> listaMatriculas = matriculaService.BuscarMatriculaPorFiltro(nombreAsignatura, nombreAlumno, fecha, activo);
		return "matriculaciones/listadoMatriculaciones";
	}
}
