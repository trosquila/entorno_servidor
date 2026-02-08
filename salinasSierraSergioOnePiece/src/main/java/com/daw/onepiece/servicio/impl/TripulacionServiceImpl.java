package com.daw.onepiece.servicio.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.onepiece.dao.interfaces.ITripulacionDAO;
import com.daw.onepiece.dtos.TripulacionDTO;
import com.daw.onepiece.repositorios.TripulacionRepository;
import com.daw.onepiece.servicio.interfaces.ITripulacionService;

@Service
public class TripulacionServiceImpl implements ITripulacionService{
	@Autowired
	private TripulacionRepository tripulacionRepository;
	@Autowired
	private ITripulacionDAO tripulacionDAO;
	
	@Override
	public ArrayList<TripulacionDTO> BuscarTripulacionPorFiltros(Integer id, String nombre, String nombreBarco,
			Boolean activo) {
		return tripulacionRepository.listarTripulacionPorFiltros(id, nombre, nombreBarco, activo);
	}

	@Override
	public Integer modificarTripulacionEnDetalles(Integer idTripulacion, Integer idPirata, String rol) {
		return tripulacionDAO.modificarTripulacionEnDetalles(idTripulacion, idPirata, rol);
	}

	@Override
	public Integer eliminarMiembroTripulacion(Integer idPirata, Integer idTripulacion) {
		return tripulacionDAO.eliminarMiembroTripulacion(idPirata, idTripulacion);
	}

	@Override
	public Integer guardarNuevaTripulacion(String nombreTripulacion, String nombreBarco, Boolean activa) {
		return tripulacionDAO.guardarNuevaTripulacion(nombreTripulacion, nombreBarco, activa);
	}

	@Override
	public Integer borrarTripulacion(Integer idTripulacion) {
		return tripulacionDAO.borrarTripulacion(idTripulacion);
	}

	@Override
	public Integer actualizarTripulacion(Integer idTripulacion, String nombre, String barco, Boolean activa) {
		return tripulacionDAO.actualizarTripulacion(idTripulacion, nombre,barco, activa);
	}

}