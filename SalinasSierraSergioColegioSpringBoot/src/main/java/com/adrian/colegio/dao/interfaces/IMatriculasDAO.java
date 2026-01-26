package com.adrian.colegio.dao.interfaces;

import java.util.ArrayList;

import com.adrian.colegio.dtos.MatriculaDTO;

public interface IMatriculasDAO {

	ArrayList<MatriculaDTO> obtenerMatriculasPorFiltros(String nombreAsignatura, String nombreAlumno, String fecha,
			Integer activo);

	Integer insertarMatricula(Integer idAlumno, Integer idAsignatura, Integer tasa, String fecha);

	Integer modificarMatricula(Integer idMatricula, Integer idAlumno, Integer idAsignatura, String fecha, Integer tasa,
			Integer activo);

	Integer borrarMatricula(Integer idMatricula);

	

}
