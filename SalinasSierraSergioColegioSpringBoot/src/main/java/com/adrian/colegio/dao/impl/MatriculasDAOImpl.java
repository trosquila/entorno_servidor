package com.adrian.colegio.dao.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adrian.colegio.dao.interfaces.IMatriculasDAO;
import com.adrian.colegio.dtos.MatriculaDTO;
import com.adrian.colegio.repositorios.AsignaturaRepository;
import com.adrian.colegio.repositorios.NotaRepository;
@Repository
public class MatriculasDAOImpl implements IMatriculasDAO{
	  @Autowired
	   AsignaturaRepository asignaturaRepository;

	@Override
	public ArrayList<MatriculaDTO> obtenerMatriculasPorFiltros(String nombreAsignatura, String nombreAlumno,
			String fecha, Integer activo) {
		 return asignaturaRepository.buscaMatriculaAvanzada(1, nombreAsignatura,  nombreAlumno,  fecha,  activo);
	}

}
