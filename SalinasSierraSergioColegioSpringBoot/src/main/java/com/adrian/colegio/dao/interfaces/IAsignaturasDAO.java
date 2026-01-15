package com.adrian.colegio.dao.interfaces;

import java.util.ArrayList;

import com.adrian.colegio.dtos.AsignaturaDTO;

public interface IAsignaturasDAO {
	 ArrayList<AsignaturaDTO> obtenerAsignaturasPorFiltros(Integer id, String nombre, Integer curso, Integer tasa, Integer activo);

	    int insertarAsignatura(int id, String nombre, int curso, int tasa, int activo);

	    int actualizarAsignatura(Integer id, String nombre, Integer curso, Integer tasa, Integer activo);

	    int borrarAsignatura(Integer id);
	    
	    double obtenerTasaAsignatura(String idAsignatura);

}
