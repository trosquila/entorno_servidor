package com.negocio;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modelo.IModelo;

@Service
public class Negocio implements INegocio{
	 @Autowired
	 private IModelo modelo;
	@Override
	public List<String> obtenerListaJugadores() throws IOException {
		List<String> listaJugadores = modelo.sacarJugadoresArchivo();
		return listaJugadores;
	}
	@Override
	public String obtenerRol() throws IOException {
		List<String> listaRoles = modelo.sacarRolesArchivo();
		int numero = (int) (Math.random() * listaRoles.size());
		
		return listaRoles.get(numero);
	}

}
