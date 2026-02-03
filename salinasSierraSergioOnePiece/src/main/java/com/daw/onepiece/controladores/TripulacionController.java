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
import com.daw.onepiece.dtos.DesplegableDTO;
import com.daw.onepiece.dtos.PirataDTO;
import com.daw.onepiece.dtos.TripulacionDTO;
import com.daw.onepiece.servicio.interfaces.IPirataService;
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
	
	@Autowired
	IPirataService pirataService;
	
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
	
	@GetMapping("/detallesTripulacion")
	public String verDetalles(@RequestParam Integer id, ModelMap model) {

	    ArrayList<TripulacionDTO> lista = tripulacionService.BuscarTripulacionPorFiltros(id, null, null, null);
	    TripulacionDTO tripulacion = (lista != null && !lista.isEmpty()) ? lista.get(0) : null;

	    ArrayList<PirataDTO> miembros = pirataService.BuscarTripulacionBarco(id, null, null);

	    ArrayList<DesplegableDTO> listaIslas = desplegables.desplegablePiratas();

	    model.addAttribute("miembros", miembros != null ? miembros : new ArrayList<>());
	    model.addAttribute("piratasActivos", listaIslas);
	    model.addAttribute("tripulacion", tripulacion);

	    return "tripulaciones/detallesTripulacion";
	}
	
	
	//eliminarPiratas en detalles
	@PostMapping("/agregarMiembro")
	public String modificarEnDetalles(
			@RequestParam(value = "idTripulacion", required = false) Integer idTripulacion,
			@RequestParam(value = "idPirata", required = false) Integer idPirata,
			@RequestParam(value = "rol", required = false) String rol,
			ModelMap model) {

		Integer result = tripulacionService.modificarTripulacionEnDetalles(idTripulacion, idPirata, rol);
		
	    ArrayList<TripulacionDTO> lista = tripulacionService.BuscarTripulacionPorFiltros(idTripulacion, null, null, null);
	    TripulacionDTO tripulacion = (lista != null && !lista.isEmpty()) ? lista.get(0) : null;

	    ArrayList<PirataDTO> miembros = pirataService.BuscarTripulacionBarco(idTripulacion, null, null);

	    ArrayList<DesplegableDTO> listaIslas = desplegables.desplegablePiratas();

	    model.addAttribute("miembros", miembros != null ? miembros : new ArrayList<>());
	    model.addAttribute("piratasActivos", listaIslas);
	    model.addAttribute("tripulacion", tripulacion);
	    return "tripulaciones/detallesTripulacion";
	}
	
	@PostMapping("/eliminarMiembro")
	public String borrarTripulacionDetalles(
			@RequestParam(value = "idPirata", required = false) Integer idPirata,
			@RequestParam(value = "idTripulacion", required = false) Integer idTripulacion,
			ModelMap model) {
		
		Integer result = tripulacionService.eliminarMiembroTripulacion(idPirata,idTripulacion);

	    ArrayList<TripulacionDTO> lista = tripulacionService.BuscarTripulacionPorFiltros(idTripulacion, null, null, null);
	    TripulacionDTO tripulacion = (lista != null && !lista.isEmpty()) ? lista.get(0) : null;

	    ArrayList<PirataDTO> miembros = pirataService.BuscarTripulacionBarco(idTripulacion, null, null);

	    ArrayList<DesplegableDTO> listaIslas = desplegables.desplegablePiratas();

	    model.addAttribute("miembros", miembros != null ? miembros : new ArrayList<>());
	    model.addAttribute("piratasActivos", listaIslas);
	    model.addAttribute("tripulacion", tripulacion);
		return "tripulaciones/detallesTripulacion";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/formularioActualizarTripulaciones")
	public String formularioActualizarTripulaciones() {
		
		return "tripulaciones/actualizarTripulaciones";
	}
	
	@PostMapping("/formularioActualizarTripulaciones")
	public String formularioActualizarTripulacionesListar(
			@RequestParam(value = "id", required = false) Integer idTripulacion,
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "estaActiva", required = false) Boolean activa,
			ModelMap model) {

	    ArrayList<TripulacionDTO> lista = tripulacionService.BuscarTripulacionPorFiltros(idTripulacion, nombre, null, activa);
		model.addAttribute("lista", lista);
		return "tripulaciones/actualizarTripulaciones";
	}
	
}