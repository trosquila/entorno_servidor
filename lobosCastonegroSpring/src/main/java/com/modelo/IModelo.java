package com.modelo;

import java.io.IOException;
import java.util.List;

public interface IModelo {

	List<String> sacarJugadoresArchivo() throws IOException;

	List<String> sacarRolesArchivo() throws IOException;

}
