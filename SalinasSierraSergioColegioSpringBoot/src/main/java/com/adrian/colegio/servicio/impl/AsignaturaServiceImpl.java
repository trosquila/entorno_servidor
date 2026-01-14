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
	public ArrayList<AsignaturaDTO> obtenerAsignaturasPorFiltros(Integer id, String nombre, Integer curso, Integer tasa, Integer activo) {
			
		return asignaturasDAO.obtenerAsignaturasPorFiltros(id, nombre, curso, tasa, activo);
	}

	@Override
	public int insertarAsignatura(int id, String nombre, int curso, int tasa, int activo) {
		return asignaturasDAO.insertarAsignatura(id, nombre, curso, tasa, activo);
	}

	@Override
	public int actualizarAsignatura(Integer id, String nombre, Integer curso, Integer tasa, Integer activo) {
		// TODO Auto-generated method stub
		return asignaturasDAO.actualizarAsignatura(id, nombre, curso, tasa, activo);
	}

	@Override
	public int borrarAsignatura(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
