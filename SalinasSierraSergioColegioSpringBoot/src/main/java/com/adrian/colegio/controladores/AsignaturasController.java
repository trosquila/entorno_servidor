package com.adrian.colegio.controladores;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.adrian.colegio.dao.interfaces.IDesplegablesDAO;
import com.adrian.colegio.dtos.AsignaturaDTO;
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
	public String insertarAlumno(@RequestParam("id") int id,
								@RequestParam("nombre") String nombre,
								@RequestParam("curso") int curso,
								@RequestParam("tasa") int tasa,
								ModelMap model
			) {
		
		ArrayList<DesplegableDTO> listaAsignaturas = desplegables.desplegableAsignaturas();
		
		Integer resultado = asignaturaService.insertarAsignatura(id, nombre, curso, tasa, 1);
		model.addAttribute("resultado", resultado);
		return "asignaturas/insertarAsignatura";
		
	}
	
	@GetMapping("/listadoAsignaturas")
	public String formularioListarAsignatura(ModelMap model) {
		ArrayList<DesplegableDTO> listaAsignaturas =
				desplegables.desplegableAsignaturas();
		model.addAttribute("desplegableMunicipios", listaAsignaturas);

		return "asignaturas/listadoAsignaturas";
	}
	
	@PostMapping("/listadoAsignaturas")
	public String listadoAlumnos(
			  @RequestParam(value = "id", required = false) Integer id,
			    @RequestParam(value = "nombre", required = false) String nombre,
			    @RequestParam(value = "curso", required = false) Integer curso,
			    @RequestParam(value = "tasa", required = false) Integer tasa,
			    @RequestParam(value = "activo", required = false) Integer activo,
			    ModelMap model) {

		ArrayList<AsignaturaDTO> listaAsignaturas = asignaturaService.obtenerAsignaturasPorFiltros(id, nombre, curso, tasa, activo);
		model.addAttribute("lista", listaAsignaturas);
		return "asignaturas/listadoAsignaturas";
	}

	@GetMapping(value = "/formularioActualizarAsignaturas")
	public String formularioModificarAsignaturas(ModelMap model) {
		return "asignaturas/actualizarAsignaturas";
	}
	
	@PostMapping(value = "/formularioActualizarAsignaturas")
	public String formularioModificarAsignaturas(
			@RequestParam(value = "id", required = false) Integer id,
		    @RequestParam(value = "nombre", required = false) String nombre,
		    @RequestParam(value = "curso", required = false) Integer curso,
		    @RequestParam(value = "tasa", required = false) Integer tasa,
		    @RequestParam(value = "activo", required = false) Integer activo,
		    ModelMap model) throws SQLException {
		ArrayList<AsignaturaDTO> listaAsignaturas = asignaturaService.obtenerAsignaturasPorFiltros(id, nombre, curso, tasa, activo);
		model.addAttribute("lista", listaAsignaturas);
		return "asignaturas/actualizarAsignaturas";
	}

	@PostMapping(value = "/actualizarAsignatura")
	public String modificarAsignatura(
				@RequestParam(value = "id", required = false) Integer id,
			    @RequestParam(value = "nombre", required = false) String nombre,
			    @RequestParam(value = "curso", required = false) Integer curso,
			    @RequestParam(value = "tasa", required = false) Integer tasa,
			    ModelMap model
			) {
		
		Integer resultado = asignaturaService.actualizarAsignatura(id, nombre, curso, tasa, 1);
		model.addAttribute("resultado", resultado);
		
		return "asignaturas/actualizarAsignaturas";
		
	}
	
	@GetMapping(value = "/formularioBorrarAsignaturas")
	public String getFormularioEliminarAlumnos() {
		return "asignaturas/borrarAsignaturas";
	}
	
	@PostMapping(value = "/formularioBorrarAsignaturas")
	public String formularioEliminarAlumnos(
		@RequestParam(value = "id", required = false) Integer id,
		@RequestParam(value = "nombre", required = false) String nombre,
		@RequestParam(value = "curso", required = false) Integer curso,
		@RequestParam(value = "tasa", required = false) Integer tasa,
		@RequestParam(value = "activo", required = false) Integer activo, 
		ModelMap model) {
	
		ArrayList<AsignaturaDTO> listaAsignaturas = asignaturaService.obtenerAsignaturasPorFiltros(id, nombre, curso, tasa, activo);
		model.addAttribute("lista", listaAsignaturas);
			return "asignaturas/borrarAsignaturas";
		}
	
		@PostMapping(value = "/borrarAsignatura")
		public String eliminarAlumnos(@RequestParam("id") Integer id, ModelMap model) {
			
			Integer resultado = asignaturaService.borrarAsignatura(id);
			model.addAttribute("resultado", resultado);
			return "asignaturas/borrarAsignaturas";
	}

}
