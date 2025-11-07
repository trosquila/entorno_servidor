package com.controlador;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlador{
	@GetMapping("/sacarLista")
	public String ObtenerJugadores(Model model) {
		List<String> listaJugadores;
		model.addAttribute("jugadores",);
		return "programa";
	}
}
