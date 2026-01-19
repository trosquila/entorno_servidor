package com.adrian.colegio.servicio.interfaces;

import java.util.ArrayList;

import com.adrian.colegio.dtos.NotaDTO;

	
public interface INotasService {

    ArrayList<NotaDTO> obtenerNotasPorFiltros(Integer idNota, Integer idAlumno, Integer idAsignatura);

    int insertarNota(Integer idAlumno, Integer idAsignatura, Integer nota, String fecha);

    int actualizarNota(Integer id, Integer idAlumno, Integer idAsignatura, Integer nota, String fecha);

    int borrarNota(Integer id);
    
    ArrayList<NotaDTO> buscarNotas(Integer idAlumno, String nombreAlumno, String asignatura, Integer nota, String fecha, Integer activo);
}
