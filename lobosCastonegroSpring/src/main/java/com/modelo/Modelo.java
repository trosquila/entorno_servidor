package com.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;



@Service
public class Modelo implements IModelo{

	@Override
	public List<String> sacarJugadoresArchivo() throws IOException {
		String path = Thread.currentThread().getContextClassLoader().getResource("jugadores.txt").getPath();
		
		File file = new File(path);
		FileReader fileReader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(fileReader);
		String linea;
		List <String> listaJugadores = new ArrayList<String>();
		while((linea = buffer.readLine()) != null) {
			String[] arrayNombres = linea.split("-");
			listaJugadores.add(arrayNombres[1]);
			
		}
		buffer.close();
		return listaJugadores; 
	}

	@Override
	public List<String> sacarRolesArchivo() throws IOException {
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
