package com.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RecogerDatos {
	public List<String> cantidadCartas(String nombre) throws IOException{
		String path = Thread.currentThread().getContextClassLoader().getResource("Cartas.txt").getPath();
		File file = new File(path);
		FileReader fileReader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(fileReader);
		String linea;
		List <String> lista = new ArrayList <>();
		while((linea = buffer.readLine()) != null) {
			if (linea.contains(nombre)) {
				
				String[] arrayNombres = linea.split("-");
				
				lista.add(arrayNombres[0]);
				}
		}
		buffer.close(); 
		return lista;
		
	}
}
