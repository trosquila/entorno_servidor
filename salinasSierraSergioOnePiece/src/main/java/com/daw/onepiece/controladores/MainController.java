package com.daw.onepiece.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String home() {
		return "login";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/home")
	public String homeL() {
		return "index";
	}

	@GetMapping("/accesoDenegado")
	public String accessDenied() {
		return "accesoDenegado";
	}
}
