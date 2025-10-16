package com.controller;

import java.util.ArrayList;
import java.util.List;

public class ProductoRandom {
	public String producto() {
		int num = numAleatorio();
		 List<String> nombresProductos = new ArrayList<>();
	        nombresProductos.add("Camiseta");
	        nombresProductos.add("Pantalón");
	        nombresProductos.add("Zapatos");
	        nombresProductos.add("Gorra");
	        nombresProductos.add("Chaqueta");
	        nombresProductos.add("Bufanda");
	        nombresProductos.add("Calcetines");
	        nombresProductos.add("Sudadera");
	        nombresProductos.add("Reloj");
	        nombresProductos.add("Mochila");
	        nombresProductos.add("Gafas de sol");
	        nombresProductos.add("Guantes");
	        nombresProductos.add("Botas");
	        nombresProductos.add("Cinturón");
	        nombresProductos.add("Sombrero");
		return nombresProductos.get(num);
		
	}
	public int numAleatorio() {
		return  (int) (Math.random() * 15) + 1;
		
	}
}
