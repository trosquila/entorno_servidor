package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 @Controller
public class ProductoController {
	@RequestMapping(value="/productoController")
	public String productoController(Model model) {
		ProductoRandom producto = new ProductoRandom();
		String productoCesta = producto.producto();
		model.addAttribute("productoCesta", productoCesta);

	return "productoView";
	}
}
