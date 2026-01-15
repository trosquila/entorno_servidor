package com.adrian.colegio.dao.interfaces;

import java.util.ArrayList;
import com.adrian.colegio.dtos.NotaDTO;

public interface INotasDAO {
	
	ArrayList<NotaDTO> obtenerNotasPorFiltros(Integer idNota, Integer idAlumno, Integer idAsignatura);

	ArrayList<NotaDTO> buscarNotas(Integer idAlumno, String nombreAlumno, String asignatura, String nota, String fecha);

	int insertarNota(Integer idAlumno, Integer idAsignatura, String nota, String fecha);

	int actualizarNota(Integer id, Integer idAlumno, Integer idAsignatura, String nota, String fecha);

	int borrarNota(Integer id);
}