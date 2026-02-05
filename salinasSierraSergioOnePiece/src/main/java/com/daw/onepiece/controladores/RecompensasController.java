package com.daw.onepiece.controladores;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daw.onepiece.dao.interfaces.IDesplegablesDAO;
import com.daw.onepiece.dtos.DesplegableDTO;
import com.daw.onepiece.servicio.interfaces.IRecompensaService;

@Controller
@RequestMapping("/recompensas")
public class RecompensasController {
	
	@Autowired
	IRecompensaService recompensaService;
	@Autowired
	IDesplegablesDAO desplegables;
	
	@GetMapping("/listadoRecompensas")
	public String formularioListarRecompensas(ModelMap model) {
		ArrayList<DesplegableDTO> tripulacion = desplegables.desplegableTripulacion();
		return "recompensas/listadoRecompensas";
	}
	@PostMapping("listadoRecompensas")
	public String listarRecompensas(ModelMap model) {
		
		return "recompensas/listadoRecompensas";
	}
	
	
	@GetMapping("/actualizarRecompensas")
	public String formularioActualizarRecompensas(ModelMap model) {
		return "recompensas/actualizarRecompensas";
	}
}
