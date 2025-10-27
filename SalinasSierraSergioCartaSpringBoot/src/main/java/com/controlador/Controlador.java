package com.controlador;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.negocio.ContarCartas;



@Controller
public class Controlador {
	@PostMapping("/poderCarta")
	public String ObtenerIndicePoder(@RequestParam("nombre") String nombre, Model model) throws IOException {
		ContarCartas cantidadCartas = new ContarCartas();
		int cantidadCartasUser = cantidadCartas.cantidadCartas(nombre);
		model.addAttribute("indice", cantidadCartasUser);
		model.addAttribute("nombre", nombre);
		return "resultado";
		
	}
}
