package com.daw.onepiece.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daw.onepiece.dao.interfaces.ITripulacionDAO;
import com.daw.onepiece.entities.PirataEntity;
import com.daw.onepiece.entities.ReclutamientoEntity;
import com.daw.onepiece.entities.TripulacionEntity;
import com.daw.onepiece.repositorios.PiratasRepository;
import com.daw.onepiece.repositorios.ReclutamientoRepository;
import com.daw.onepiece.repositorios.TripulacionRepository;

@Repository
public class TripulacionDAOImpl  implements ITripulacionDAO{
	  @Autowired
	    private PiratasRepository piratasRepository;
	  
	  @Autowired
	    private ReclutamientoRepository reclutamientoRepository;
	  
	  @Autowired
	    private TripulacionRepository tripulacionRepository;
	@Override
	public Integer modificarTripulacionEnDetalles(Integer idTripulacion, Integer idPirata, String rol) {
		TripulacionEntity tripulacion = tripulacionRepository.findById(idTripulacion).get();
		reclutamientoRepository.desactivarReclutamientosDelPirata(idPirata);
		
		PirataEntity pirata = piratasRepository.findById(idPirata).get();
		
		ReclutamientoEntity reclutamiento = new ReclutamientoEntity(pirata, tripulacion, rol, true);
		reclutamientoRepository.save(reclutamiento);
		return reclutamiento.getId();
	}

}
