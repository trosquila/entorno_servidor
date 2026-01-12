package com.adrian.colegio.servicio.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import com.adrian.colegio.dtos.AsignaturaDTO;


public interface IAsignaturaService {
    public ArrayList<AsignaturaDTO> obtenerAsignaturas() throws SQLException;

    public ArrayList<AsignaturaDTO> obtenerAsignaturasPorFiltros(String id, String nombre, String curso, String tasa,
            int activo);

    public int insertarAsignatura(int id, String nombre, int curso, int tasa, int activo);

    public int actualizarAsignatura(String id, String nombre, String curso, String tasa, int activo);

    public int borrarAsignatura(String id);
}
