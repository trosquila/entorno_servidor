package com.adrian.colegio.dao.impl;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.adrian.colegio.dao.interfaces.IDesplegablesDAO;
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

import jakarta.transaction.Transactional;
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
	    
	    @Autowired
	    IDesplegablesDAO desplegables;

	@Override
	public ArrayList<MatriculaDTO> obtenerMatriculasPorFiltros(String nombreAsignatura, String nombreAlumno,
			String fecha, Integer activo) {
		 return matriculaRepository.buscaMatriculaAvanzada(nombreAlumno,   nombreAsignatura,  fecha,  activo);
	}

	@Override
	@Transactional
	public Integer insertarMatricula(Integer idAlumno, Integer idAsignatura, Integer tasa, String fecha) {
		if (fecha == null || fecha.isEmpty()) {
            fecha = LocalDate.now().toString();
        }
		
		
		AlumnoEntity alumno = alumnoRepository.findById(idAlumno).get();
        AsignaturaEntity asignatura = asignaturaRepository.findById(idAsignatura).get();
        
        MatriculaEntity matriculaEntity = new MatriculaEntity(alumno, asignatura, fecha, 1);
        MatriculaEntity matriculaGuardada = matriculaRepository.save(matriculaEntity);
        
        int importe = tasa;
        CajaEntity cajaEntity = new CajaEntity();
        cajaEntity.setMatricula(matriculaGuardada);
        cajaEntity.setImporte(importe);
        cajaRepository.save(cajaEntity);
        
		return cajaEntity.getId();
	}

	


	@Override
	public Integer modificarMatricula(Integer idMatricula, Integer idAlumno, Integer idAsignatura, String fecha, Integer tasa, Integer activo) {
		AlumnoEntity alumno = alumnoRepository.findById(idAlumno).get();
        AsignaturaEntity asignatura = asignaturaRepository.findById(idAsignatura).get();
        
        MatriculaEntity matriculaEntity = matriculaRepository.findById(idMatricula).get();
        matriculaEntity.setAlumno(alumno);
        matriculaEntity.setAsignatura(asignatura);
        matriculaEntity.setFecha(fecha);
        
       matriculaRepository.save(matriculaEntity);
        
        int importe = tasa;
        CajaEntity cajaEntity = matriculaEntity.getCaja();
        cajaEntity.setImporte(importe);
        cajaRepository.save(cajaEntity);
        
		return cajaEntity.getId();
	}

	@Override
	public Integer borrarMatricula(Integer idMatricula) {
		 MatriculaEntity matriculaEntity = matriculaRepository.findById(idMatricula).get();
		 matriculaEntity.setActivo(0);
		 matriculaRepository.save(matriculaEntity);
		return matriculaEntity.getId();
	}
}
