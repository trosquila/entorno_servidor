package fuerzaCartas.negocio;

import java.io.IOException;

import fuerzaCartas.modelo.Carta;
import fuerzaCartas.modelo.RecogerDatos;



public class CalculoFuerza {
	public Carta buscarCarta(String nombre) throws IOException {
		RecogerDatos recogerCarta = new RecogerDatos();
		Carta carta = recogerCarta.cantidadCartas(nombre);
		
		return carta;
		
	}

	public int indiceFuerza(Carta carta) {
		// TODO Auto-generated method stub
		return ((carta.getDamange() * carta.getHp())/carta.getCoste());
	}
}
