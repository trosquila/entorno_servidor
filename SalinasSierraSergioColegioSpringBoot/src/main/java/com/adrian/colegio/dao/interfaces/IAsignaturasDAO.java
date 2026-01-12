package com.adrian.colegio.dao.interfaces;

import java.util.ArrayList;

import com.adrian.colegio.dtos.AsignaturaDTO;

public interface IAsignaturasDAO {
	 ArrayList<AsignaturaDTO> obtenerAsignaturasPorFiltros(int id, String nombre, int curso, int tasa, int activo);

	    int insertarAsignatura(int id, String nombre, int curso, int tasa, int activo);

	    int actualizarAsignatura(String id, String nombre, String curso, String tasa, int activo);

	    int borrarAsignatura(String id);
	    
	    double obtenerTasaAsignatura(String idAsignatura);

}
