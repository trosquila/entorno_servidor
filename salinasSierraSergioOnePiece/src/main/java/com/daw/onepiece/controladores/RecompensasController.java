package com.daw.onepiece.controladores;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daw.onepiece.dao.interfaces.IDesplegablesDAO;
import com.daw.onepiece.dtos.DesplegableDTO;
import com.daw.onepiece.dtos.PirataDTO;
import com.daw.onepiece.dtos.RecompensaDTO;
import com.daw.onepiece.servicio.interfaces.IPirataService;
import com.daw.onepiece.servicio.interfaces.IRecompensaService;

@Controller
@RequestMapping("/recompensas")
public class RecompensasController {

	@Autowired
	IRecompensaService recompensaService;

	@Autowired
	IPirataService pirataService;

	@Autowired
	IDesplegablesDAO desplegables;

	@GetMapping("/listadoRecompensas")
	public String formularioListarRecompensas(ModelMap model) {
		ArrayList<DesplegableDTO> tripulacion = desplegables.desplegableTripulacion();
		model.addAttribute("tripulacionesActivas", tripulacion);

		return "recompensas/listadoRecompensas";
	}

	@PostMapping("/listadoRecompensas")
	public String listarRecompensas(@RequestParam(value = "nombrePirata", required = false) String nombrePirata,
			@RequestParam(value = "idTripulacion", required = false) Integer idTripulacion,
			@RequestParam(value = "cantidad", required = false) Long cantidad,
			@RequestParam(value = "estaVigente", required = false) Integer vigenteForm, ModelMap model) {

		Integer vigente = (vigenteForm != null && vigenteForm == 1) ? 1 : 0;

		ArrayList<DesplegableDTO> tripulacion = desplegables.desplegableTripulacion();
		ArrayList<RecompensaDTO> recompensa = recompensaService.BuscarRecompensaPorFiltro(null, nombrePirata,
				idTripulacion, cantidad, vigente);
		model.addAttribute("tripulacionesActivas", tripulacion);
		model.addAttribute("lista", recompensa);

		return "recompensas/listadoRecompensas";
	}

	@GetMapping("/emitirRecompensa")
	public String formularioEmitirRecompensa(ModelMap model) {
		ArrayList<PirataDTO> listaPiratas = pirataService.BuscarPirataPorFiltro(null, null, null, true);
		model.addAttribute("piratasActivos", listaPiratas);
		return "recompensas/emitirRecompensa";
	}

	@PostMapping("/emitirRecompensa")
	public String emitirRecompensa(@RequestParam(value = "idPirata", required = false) Integer idPirata,
			@RequestParam(value = "cantidad", required = false) BigDecimal cantidad, ModelMap model) {
		Integer result = recompensaService.emitirRecompensa(idPirata, cantidad);
		return "recompensas/emitirRecompensa";
	}

	@GetMapping("/formularioActualizarRecompensas")
	public String formularioActualizarRecompensa(ModelMap model) {
		return "recompensas/actualizarRecompensas";
	}

	@PostMapping("/formularioActualizarRecompensas")
	public String formularioMostrarActualizarRecompensa(
			@RequestParam(value = "id", required = false) Integer idRecompensa,
			@RequestParam(value = "nombrePirata", required = false) String nombrePirata, ModelMap model) {
		ArrayList<RecompensaDTO> recompensa = recompensaService.BuscarRecompensaPorFiltro(idRecompensa, nombrePirata,
				null, null, null);
		ArrayList<PirataDTO> listaPiratas = pirataService.BuscarPirataPorFiltro(null, null, null, true);
		model.addAttribute("piratasActivos", listaPiratas);
		model.addAttribute("lista", recompensa);
		return "recompensas/actualizarRecompensas";
	}

	@PostMapping("/actualizarRecompensa")
	public String actualizarRecompensa(@RequestParam("id") Integer idRecompensa,
			@RequestParam("idPirata") Integer idPirata, @RequestParam("cantidad") BigDecimal cantidad,
			@RequestParam(value = "estaVigente", required = false) Integer estaVigente, ModelMap model) {

		Boolean vigente = (estaVigente != null && estaVigente == 1);

		Integer result = recompensaService.actualizarRecompensa(idRecompensa, idPirata, cantidad, vigente);

		return "recompensas/actualizarRecompensas";
	}

	@GetMapping("/formularioBorrarRecompensas")
	public String formularioEliminarRecompensa(ModelMap model) {
		return "recompensas/borrarRecompensas";
	}

	@PostMapping("/formularioBorrarRecompensas")
	public String formularioListarEliminarRecompensa(@RequestParam(value = "id", required = false) Integer idRecompensa,
			@RequestParam(value = "nombrePirata", required = false) String nombrePirata, ModelMap model) {

		ArrayList<RecompensaDTO> recompensa = recompensaService.BuscarRecompensaPorFiltro(idRecompensa, nombrePirata, null, null, 1);
		model.addAttribute("lista", recompensa);
		return "recompensas/borrarRecompensas";
	}
	
	@PostMapping("/borrarRecompensa")
	public String eliminarRecompensa(@RequestParam(value = "id", required = false) Integer idRecompensa,  ModelMap model) {
		Integer result = recompensaService.eliminarRecompensa(idRecompensa);
		return "recompensas/borrarRecompensas";
	}
}
