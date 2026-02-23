package com.daw.onepiece.controladores;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String homeL(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		model.addAttribute("usuario", userDetails.getUsername());
		model.addAttribute("rol", userDetails.getAuthorities());
		return "index";
	}

	@GetMapping("/accesoDenegado")
	public String accessDenied() {
		return "accesoDenegado";
	}
}
