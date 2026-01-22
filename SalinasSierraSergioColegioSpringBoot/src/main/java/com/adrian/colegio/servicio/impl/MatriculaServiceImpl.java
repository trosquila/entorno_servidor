package com.adrian.colegio.servicio.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrian.colegio.dao.interfaces.IMatriculasDAO;
import com.adrian.colegio.dtos.MatriculaDTO;
import com.adrian.colegio.servicio.interfaces.IMatriculasService;
@Service
public class MatriculaServiceImpl implements IMatriculasService{
	@Autowired
	IMatriculasDAO matriculasDAO;
	
	@Override
	public ArrayList<MatriculaDTO> BuscarMatriculaPorFiltro(String nombreAsignatura, String nombreAlumno, String fecha,
			Integer activo) {
		return matriculasDAO.obtenerMatriculasPorFiltros( nombreAsignatura,  nombreAlumno,  fecha, activo);
	}

	@Override
	public Integer insertarMatricula(Integer idAlumno, Integer idAsignatura, Integer tasa, String fecha) {
		return matriculasDAO.insertarMatricula( idAlumno,  idAsignatura,  tasa, fecha);
	}

}