package com.adrian.colegio.servicio.interfaces;

import java.util.ArrayList;

import com.adrian.colegio.dtos.MatriculaDTO;

public interface IMatriculasService {

	ArrayList<MatriculaDTO> BuscarMatriculaPorFiltro(String nombreAsignatura, String nombreAlumno, String fecha, Integer activo);

	Integer insertarMatricula(Integer idAlumno, Integer idAsignatura, Integer tasa, String fecha);

	Integer actualizarMatricula(Integer idMatricula, Integer idAlumno, Integer idAsignatura, String fecha, Integer tasa,
			Integer activo);

}
