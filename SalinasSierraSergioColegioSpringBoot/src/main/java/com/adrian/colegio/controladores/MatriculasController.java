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
import com.adrian.colegio.dtos.DesplegableDTO;
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
			@RequestParam(value = "activo", required = false) Integer activo,
			 ModelMap model) {
		if (fecha != null && fecha.isBlank()) fecha = null;

		ArrayList<MatriculaDTO> listaMatriculas = matriculaService.BuscarMatriculaPorFiltro(nombreAsignatura, nombreAlumno, fecha, activo);
		model.addAttribute("lista", listaMatriculas);
		return "matriculaciones/listadoMatriculaciones";
	}
	
	@GetMapping("/insertarMatriculacion")
	public String formularioInsertarMatricula(ModelMap model) {
		ArrayList<DesplegableDTO> listaAsignaturas = desplegables.desplegableAsignaturas();
		model.addAttribute("desplegableAsignaturas", listaAsignaturas);

		ArrayList<DesplegableDTO> listaAlumnos = desplegables.desplegableAlumnos();
		model.addAttribute("desplegableAlumnos", listaAlumnos);
		
		return "matriculaciones/insertarMatriculacion";
	}

	@PostMapping("/insertarMatriculacion")
	public String insertarNota(@RequestParam("alumno") Integer idAlumno,
			@RequestParam("asignatura") Integer idAsignatura,
			@RequestParam("tasa") Integer tasa,
			@RequestParam(value = "fecha", required = false) String fecha, ModelMap model) {
			
		Integer resultado = matriculaService.insertarMatricula(idAlumno, idAsignatura, tasa, fecha);
		model.addAttribute("resultado", resultado);
			
		
		return "matriculaciones/insertarMatriculacion";
	}
}
