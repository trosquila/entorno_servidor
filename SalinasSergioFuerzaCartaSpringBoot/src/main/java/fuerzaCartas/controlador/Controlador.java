package fuerzaCartas.controlador;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fuerzaCartas.modelo.Carta;
import fuerzaCartas.negocio.CalculoFuerza;

@Controller
public class Controlador {
	@PostMapping("/poderCarta")
	public String ObtenerIndicePoder(@RequestParam("nombre") String nombre, Model model) throws IOException {
		CalculoFuerza calculo = new CalculoFuerza();
		Carta carta = calculo.buscarCarta(nombre); 
		int cantidadPoder = calculo.indiceFuerza(carta);
		model.addAttribute("indice", cantidadPoder);
		model.addAttribute("nombre", nombre);
		return "resultado";
		
	}
}
