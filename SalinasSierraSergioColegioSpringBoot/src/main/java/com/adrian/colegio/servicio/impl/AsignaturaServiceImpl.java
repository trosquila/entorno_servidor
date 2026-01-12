package com.adrian.colegio.servicio.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrian.colegio.dao.interfaces.IAsignaturasDAO;
import com.adrian.colegio.dtos.AsignaturaDTO;
import com.adrian.colegio.servicio.interfaces.IAsignaturaService;

@Service
public class AsignaturaServiceImpl implements IAsignaturaService{
	@Autowired
	IAsignaturasDAO asignaturasDAO;
	
	@Override
	public ArrayList<AsignaturaDTO> obtenerAsignaturas() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AsignaturaDTO> obtenerAsignaturasPorFiltros(String id, String nombre, String curso, String tasa,
			int activo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertarAsignatura(int id, String nombre, int curso, int tasa, int activo) {
		return asignaturasDAO.insertarAsignatura(id, nombre, curso, tasa, activo);
	}

	@Override
	public int actualizarAsignatura(String id, String nombre, String curso, String tasa, int activo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int borrarAsignatura(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
