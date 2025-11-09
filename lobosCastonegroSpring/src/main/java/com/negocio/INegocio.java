package com.negocio;

import java.io.IOException;
import java.util.List;

public interface INegocio {

	List<String> obtenerListaJugadores() throws IOException;

	String obtenerRol() throws IOException;

}
