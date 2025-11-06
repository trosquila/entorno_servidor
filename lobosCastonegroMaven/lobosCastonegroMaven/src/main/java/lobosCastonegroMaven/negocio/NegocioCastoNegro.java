package lobosCastonegroMaven.negocio;

import java.io.IOException;
import java.util.List;

import lobosCastonegroMaven.modelo.Jugadores;
import lobosCastonegroMaven.modelo.LectorArchivos;

public class NegocioCastoNegro {

	public List <Jugadores> buscarJugadores() throws NumberFormatException, IOException{
		LectorArchivos modelo = new LectorArchivos();
		List <Jugadores> listaJugadores = modelo.sacarJugadores();
		return listaJugadores;
	}

	public String obtenerRol() throws IOException {
		LectorArchivos modelo = new LectorArchivos();
		List<String> listaRoles =  modelo.Roles();
		int numero = (int) (Math.random() * listaRoles.size());
		System.out.println(numero);
		System.out.println(listaRoles);
		return listaRoles.get(numero);
	}
}
