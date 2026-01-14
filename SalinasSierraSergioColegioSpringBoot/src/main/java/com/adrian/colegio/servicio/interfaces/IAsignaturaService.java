package com.adrian.colegio.servicio.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import com.adrian.colegio.dtos.AsignaturaDTO;


public interface IAsignaturaService {
    public ArrayList<AsignaturaDTO> obtenerAsignaturas() throws SQLException;

    public ArrayList<AsignaturaDTO> obtenerAsignaturasPorFiltros(Integer id, String nombre, Integer curso, Integer tasa, Integer activo);

    public int insertarAsignatura(int id, String nombre, int curso, int tasa, int activo);

    public int actualizarAsignatura(Integer id, String nombre, Integer curso, Integer tasa, Integer activo);

    public int borrarAsignatura(String id);
}
