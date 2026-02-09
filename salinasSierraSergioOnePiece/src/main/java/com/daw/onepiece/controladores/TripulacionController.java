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
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "barco", required = false) String nombreBarco,
			@RequestParam(value = "estaActiva", required = false) Integer activoForm, ModelMap model) {
		
		Boolean activo = (activoForm != null) ? (activoForm == 1) : null;
		
		ArrayList<TripulacionDTO> listaTripulacion = tripulacionService.BuscarTripulacionPorFiltros(null, nombre, nombreBarco, activo);
		model.addAttribute("lista", listaTripulacion);
		return "tripulaciones/listadoTripulaciones";
	}
	
	//mas info en listar (el comentario no es de chati es para no liarme)
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
	
	//fin de más detalles

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
	
	
	@PostMapping("/actualizarTripulacion")
	public String actualizarTripulacion(
	        @RequestParam("id") Integer idTripulacion,
	        @RequestParam("nombre") String nombre,
	        @RequestParam("barco") String barco,
	        @RequestParam(value = "estaActiva", required = false) Integer activaForm,
	        ModelMap model
	) {
	    Boolean activa = (activaForm != null && activaForm == 1);

	    Integer resultado = tripulacionService.actualizarTripulacion(idTripulacion, nombre, barco, activa);

	    model.addAttribute("resultado", resultado);

	    ArrayList<TripulacionDTO> lista = tripulacionService.BuscarTripulacionPorFiltros(null, null, null, true);
	    model.addAttribute("lista", lista);

	    return "tripulaciones/actualizarTripulaciones";
	}

	@GetMapping("/insertarTripulacion")
	public String insertarTripulacion() {
		
		return "tripulaciones/insertarTripulacion";
	}
	
	@PostMapping("/insertarTripulacion")
	public String insertarTripulacionPost(
			@RequestParam(value = "nombre", required = false) String nombreTripulacion,
			@RequestParam(value = "barco", required = false) String nombreBarco,
			@RequestParam(value = "estaActiva", required = false) Boolean activa,
			ModelMap model
			) {
			Integer result = tripulacionService.guardarNuevaTripulacion(nombreTripulacion, nombreBarco, activa);
		return "tripulaciones/insertarTripulacion";
	}
	
	
	@GetMapping("/formularioBorrarTripulaciones")
	public String apartadoBorrar() {
		
		return "tripulaciones/borrarTripulaciones";
	}
	
	@PostMapping("/formularioBorrarTripulaciones")
	public String listarBorrar(
			@RequestParam(value = "id", required = false) Integer idTripulacion,
			@RequestParam(value = "nombre", required = false) String nombreTripulacion,
			ModelMap model
			) {
		
		
		ArrayList<TripulacionDTO> listaTripulacion = tripulacionService.BuscarTripulacionPorFiltros(idTripulacion, nombreTripulacion, null, true);
		model.addAttribute("lista", listaTripulacion);
		return "tripulaciones/borrarTripulaciones";
	}
	
	@PostMapping("/borrarTripulacion")
	public String borrarTripulacion(
			@RequestParam(value = "id", required = false) Integer idTripulacion,
			ModelMap model
			) {
		
		
		Integer result = tripulacionService.borrarTripulacion(idTripulacion);
		return "tripulaciones/borrarTripulaciones";
	}
}