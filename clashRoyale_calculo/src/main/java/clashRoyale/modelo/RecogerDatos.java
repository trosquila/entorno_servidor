package clashRoyale.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class RecogerDatos {
	
	public Carta cantidadCartas(String nombre) throws IOException{
		String path = Thread.currentThread().getContextClassLoader().getResource("Cartas.txt").getPath();
		File file = new File(path);
		FileReader fileReader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(fileReader);
		String linea;
		while((linea = buffer.readLine()) != null) {
			if (linea.contains(nombre)) {
				
				String[] arrayNombres = linea.split("-");
				Carta carta = new Carta(arrayNombres[0], Integer.parseInt(arrayNombres[1]), Integer.parseInt(arrayNombres[2]), Integer.parseInt(arrayNombres[3]));
				return carta;
				}
		}
		buffer.close();
		return null; 
		
		
	}
}
