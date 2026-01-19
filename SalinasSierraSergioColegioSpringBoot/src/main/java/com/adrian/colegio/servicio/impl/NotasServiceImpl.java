package com.adrian.colegio.servicio.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrian.colegio.dao.interfaces.INotasDAO;
import com.adrian.colegio.dtos.NotaDTO;
import com.adrian.colegio.servicio.interfaces.INotasService;
@Service
public class NotasServiceImpl implements INotasService {
	@Autowired
	INotasDAO notasDAO;

	@Override
	public ArrayList<NotaDTO> obtenerNotasPorFiltros(Integer idNota, Integer idAlumno, Integer idAsignatura) {
		return notasDAO.obtenerNotasPorFiltros(idNota, idAlumno, idAsignatura);
	}

	@Override
	public int insertarNota(Integer idAlumno, Integer idAsignatura, Integer nota, String fecha) {
		return notasDAO.insertarNota(idAlumno, idAsignatura, nota, fecha);
	}

	@Override
	public int actualizarNota(Integer id, Integer idAlumno, Integer idAsignatura, Integer nota, String fecha) {
		return notasDAO.actualizarNota(id, idAlumno, idAsignatura, nota, fecha);
	}

	@Override
	public int borrarNota(Integer id) {
		return notasDAO.borrarNota(id);
	}

	@Override
	public ArrayList<NotaDTO> buscarNotas(Integer idAlumno, String nombreAlumno, String asignatura, Integer nota, String fecha) {
		return notasDAO.buscarNotas(idAlumno, nombreAlumno, asignatura, nota, fecha);
	}
}
