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
}
