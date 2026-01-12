package com.adrian.colegio.dao.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adrian.colegio.dao.interfaces.IAsignaturasDAO;
import com.adrian.colegio.dtos.AsignaturaDTO;
import com.adrian.colegio.entities.AsignaturaEntity;
import com.adrian.colegio.repositorios.AsignaturaRepository;
@Repository
public class AsignaturasDAOImpl implements IAsignaturasDAO{
	@Autowired
	AsignaturaRepository asignaturaRepository;
	@Override
	public ArrayList<AsignaturaDTO> obtenerAsignaturasPorFiltros(int id, String nombre, int curso, int tasa, int activo) {
		return asignaturaRepository.buscaAsignaturaporIDyNombre(id, nombre, curso, tasa, activo);
	}

	@Override
	public int insertarAsignatura(int id, String nombre, int curso, int tasa, int activo) {
		AsignaturaEntity asigntura = new AsignaturaEntity(id, nombre, curso, tasa, activo);
		asignaturaRepository.save(asigntura);
		return asigntura.getId();
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

	@Override
	public double obtenerTasaAsignatura(String idAsignatura) {
		// TODO Auto-generated method stub
		return 0;
	}

}
