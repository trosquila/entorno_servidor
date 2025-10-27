package clashRoyale.negocio;

import java.io.IOException;

import clashRoyale.modelo.Carta;
import clashRoyale.modelo.RecogerDatos;

public class CalculoIndiceFuerza {
	
	public int indiceFuerza(Carta carta) {
		
		return ((carta.getDamange() * carta.getHp())/carta.getCoste());
		
	}
	
	public Carta buscarCarta(String nombre) throws IOException {
		RecogerDatos recogerCarta = new RecogerDatos();
		Carta carta = recogerCarta.cantidadCartas(nombre);
		
		return carta;
		
	}
}
