package lobosCastonegroMaven.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorArchivos {

	public List <Jugadores> sacarJugadores() throws NumberFormatException, IOException{
		String path = Thread.currentThread().getContextClassLoader().getResource("jugadores.txt").getPath();
		
		
		File file = new File(path);
		FileReader fileReader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(fileReader);
		String linea;
		List <Jugadores> listaJugadores = new ArrayList<Jugadores>();
		while((linea = buffer.readLine()) != null) {
			String[] arrayNombres = linea.split("-");
			Jugadores jugador = new Jugadores(Integer.parseInt(arrayNombres[0]), arrayNombres[1]);
			listaJugadores.add(jugador);
			
		}
		buffer.close();
		return listaJugadores; 
		
	}
	
	public List <String> Roles() throws IOException{
		String path = Thread.currentThread().getContextClassLoader().getResource("roles.txt").getPath();
		
		
		File file = new File(path);
		FileReader fileReader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(fileReader);
		String linea;
		List <String> listaRoles = new ArrayList<String>();
		while((linea = buffer.readLine()) != null) {
			listaRoles.add(linea);
		}
		buffer.close();
		return listaRoles; 
		
	}
}
