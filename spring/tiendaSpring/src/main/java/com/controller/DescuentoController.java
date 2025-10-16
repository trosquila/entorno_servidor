package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DescuentoController {
	@RequestMapping(value="/descuentoController")
	public String descuentoController(Model model){
		HoraYdescuento gestor = new HoraYdescuento();
		String texto = gestor.horaActual()+" y el descuento es del "+gestor.porcentaje()+"%";
		model.addAttribute("texto", texto);
	return "descuentoView";
	}
}
