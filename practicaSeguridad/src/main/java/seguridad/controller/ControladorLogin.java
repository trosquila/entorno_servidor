package seguridad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class ControladorLogin {
	@GetMapping("/")
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam("usuario") String usuario, @RequestParam("password") String password, Model model) {
// Validación simple (NO USAR EN PRODUCCIÓN)
		if ("admin".equals(usuario) && "contraseña1234".equals(password)) {
			model.addAttribute("correcto", "¡Login exitoso! Bienvenido " + usuario);
			return "login";
		} else {
			model.addAttribute("error", "Credenciales inválidas");
			return "login";
		}
	}
}
