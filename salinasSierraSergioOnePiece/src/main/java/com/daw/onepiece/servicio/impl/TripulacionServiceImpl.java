package com.daw.onepiece.servicio.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.onepiece.dtos.TripulacionDTO;
import com.daw.onepiece.repositorios.TripulacionRepository;
import com.daw.onepiece.servicio.interfaces.ITripulacionService;

@Service
public class TripulacionServiceImpl implements ITripulacionService{
	@Autowired
	private TripulacionRepository tripulacionRepository;
	
	@Override
	public ArrayList<TripulacionDTO> BuscarTripulacionPorFiltros(Integer id, String nombre, String nombreBarco,
			Boolean activo) {
		return tripulacionRepository.listarTripulacionPorFiltros(id, nombre, nombreBarco, activo);
	}

}
