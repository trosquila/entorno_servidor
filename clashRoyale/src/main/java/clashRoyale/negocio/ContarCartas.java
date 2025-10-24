package clashRoyale.negocio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import clashRoyale.modelo.RecogerDatos;

public class ContarCartas {

	public int cantidadCartas(String nombre) throws IOException {
		List <String> lista = new ArrayList<>();
		RecogerDatos datos = new RecogerDatos();
		lista = datos.cantidadCartas(nombre);
		int cantidad = lista.size();
		return cantidad;
	}
}
