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
import com.adrian.colegio.dtos.DesplegableDTO;
import com.adrian.colegio.repositorios.AsignaturaRepository;
import com.adrian.colegio.servicio.interfaces.IAsignaturaService;

@Controller
@RequestMapping("/asignaturas")
public class AsignaturasController {
	@Autowired
	IAsignaturaService asignaturaService;
	
	@Autowired
	IDesplegablesDAO desplegables;
	
	@Autowired
	AsignaturaRepository asignaturaRepository;
	
	
	@GetMapping("/insertarAsignatura")
	public String formularioInsertarAsignatura(ModelMap model) {
		ArrayList<DesplegableDTO> listaAsignaturas =
				desplegables.desplegableAsignaturas();
		model.addAttribute("desplegableMunicipios", listaAsignaturas);

		return "asignaturas/insertarAsignatura";
	}
	
	@PostMapping("/insertarAsignatura")
	public String insertarAlumno(@RequestParam("id") Integer id,
								@RequestParam("nombre") String nombre,
								@RequestParam("curso") Integer curso,
								@RequestParam("tasa") Integer tasa,
								ModelMap model
			) {
		
		ArrayList<DesplegableDTO> listaAsignaturas = desplegables.desplegableAsignaturas();
		
		Integer resultado = asignaturaService.insertarAsignatura(id, nombre, curso, tasa, 1);
		model.addAttribute("resultado", resultado);
		return "asignaturas/insertarAsignatura";
		
	}
}
