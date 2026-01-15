package com.adrian.colegio.dao.impl;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adrian.colegio.dao.interfaces.INotasDAO;
import com.adrian.colegio.dtos.NotaDTO;
import com.adrian.colegio.entities.AlumnoEntity;
import com.adrian.colegio.entities.AsignaturaEntity;
import com.adrian.colegio.entities.NotaEntity;
import com.adrian.colegio.repositorios.AlumnoRepository;
import com.adrian.colegio.repositorios.AsignaturaRepository;
import com.adrian.colegio.repositorios.NotaRepository;

@Repository
public class NotasDAOImpl implements INotasDAO {

    @Autowired
    NotaRepository notaRepository;

    @Autowired
    AlumnoRepository alumnoRepository;

    @Autowired
    AsignaturaRepository asignaturaRepository;

    @Override
    public ArrayList<NotaDTO> obtenerNotasPorFiltros(Integer idNota, Integer idAlumno, Integer idAsignatura) {
        return notaRepository.buscarNotas(idNota, idAlumno, idAsignatura);
    }

    @Override
    public int insertarNota(Integer idAlumno, Integer idAsignatura, String nota, String fecha) {

        AlumnoEntity alumno = alumnoRepository.findById(idAlumno).get();
        AsignaturaEntity asignatura = asignaturaRepository.findById(idAsignatura).get();

        if (fecha == null || fecha.isEmpty()) {
            fecha = LocalDate.now().toString();
        }

        NotaEntity notaEntity = new NotaEntity(null, alumno, asignatura, nota, fecha);
        notaRepository.save(notaEntity);
        return notaEntity.getId();
    }

    @Override
    public int actualizarNota(Integer id, Integer idAlumno, Integer idAsignatura, String nota, String fecha) {

        AlumnoEntity alumno = alumnoRepository.findById(idAlumno).get();
        AsignaturaEntity asignatura = asignaturaRepository.findById(idAsignatura).get();

        NotaEntity notaEntity = new NotaEntity(id, alumno, asignatura, nota, fecha);
        notaRepository.save(notaEntity);
        return notaEntity.getId();
    }

    @Override
    public int borrarNota(Integer id) {
        notaRepository.deleteById(id);
        return id;
    }

	@Override
	public ArrayList<NotaDTO> buscarNotas(Integer idAlumno, String nombreAlumno, String asignatura, String nota,
			String fecha) {
		// TODO Auto-generated method stub
		return null;
	}
}
