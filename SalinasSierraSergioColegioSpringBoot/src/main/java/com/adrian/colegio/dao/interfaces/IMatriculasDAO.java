package com.adrian.colegio.dao.interfaces;

import java.util.ArrayList;

import com.adrian.colegio.dtos.MatriculaDTO;

public interface IMatriculasDAO {

	ArrayList<MatriculaDTO> obtenerMatriculasPorFiltros(String nombreAsignatura, String nombreAlumno, String fecha,
			Integer activo);

}
