package com.adrian.colegio.dao.impl;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adrian.colegio.dao.interfaces.IMatriculasDAO;
import com.adrian.colegio.dtos.MatriculaDTO;
import com.adrian.colegio.entities.AlumnoEntity;
import com.adrian.colegio.entities.AsignaturaEntity;
import com.adrian.colegio.entities.CajaEntity;
import com.adrian.colegio.entities.MatriculaEntity;
import com.adrian.colegio.repositorios.AlumnoRepository;
import com.adrian.colegio.repositorios.AsignaturaRepository;
import com.adrian.colegio.repositorios.CajaRepository;
import com.adrian.colegio.repositorios.MatriculaRepository;
@Repository
public class MatriculasDAOImpl implements IMatriculasDAO{
	  @Autowired
	   MatriculaRepository matriculaRepository;
	  
	  @Autowired
	  CajaRepository cajaRepository;
	  
	  @Autowired
	    AlumnoRepository alumnoRepository;

	    @Autowired
	    AsignaturaRepository asignaturaRepository;

	@Override
	public ArrayList<MatriculaDTO> obtenerMatriculasPorFiltros(String nombreAsignatura, String nombreAlumno,
			String fecha, Integer activo) {
		 return matriculaRepository.buscaMatriculaAvanzada(nombreAlumno,   nombreAsignatura,  fecha,  activo);
	}

	@Override
	public Integer insertarMatricula(Integer idAlumno, Integer idAsignatura, Integer tasa, String fecha) {
		AlumnoEntity alumno = alumnoRepository.findById(idAlumno).get();
        AsignaturaEntity asignatura = asignaturaRepository.findById(idAsignatura).get();
        CajaEntity cajaEntity = new CajaEntity();
		if (fecha == null || fecha.isEmpty()) {
            fecha = LocalDate.now().toString();
        }
		MatriculaEntity matriculaEntity = new MatriculaEntity(null, alumno, asignatura, fecha, 1);
		return 0;
	}

}
