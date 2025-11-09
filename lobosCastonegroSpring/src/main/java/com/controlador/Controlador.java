package com.controlador;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.modelo.IModelo;
import com.negocio.INegocio;

@Controller
public class Controlador{
	
	 @Autowired
	 private INegocio negocio;
	 
	@GetMapping("/sacarLista")
	public String ObtenerJugadores(Model model) throws IOException {
		List<String> listaJugadores = negocio.obtenerListaJugadores();
		model.addAttribute("listaJugadores", listaJugadores);
		return "programa";
	}
	
	@PostMapping("/sacarRol")
	public String ObtenerDatosRepartoRoles(@RequestParam String jugadorElegido, Model model) throws IOException {
		List<String> listaJugadores = negocio.obtenerListaJugadores();
		String rolAleatorio = negocio.obtenerRol();
		model.addAttribute("listaJugadores", listaJugadores);
		model.addAttribute("jugadorElegido", jugadorElegido);
		model.addAttribute("rolAleatorio", rolAleatorio);
		return "programa";
	}
}
