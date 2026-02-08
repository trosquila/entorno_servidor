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
	
	@Override
	public Integer eliminarMiembroTripulacion(Integer idPirata, Integer idTripulacion) {
		
		return reclutamientoRepository.ponerMiembroActualAFalso(idPirata, idTripulacion);
	}

	@Override
	public Integer guardarNuevaTripulacion(String nombreTripulacion, String nombreBarco, Boolean activa) {
		TripulacionEntity tripulacion = new TripulacionEntity();
		tripulacion.setNombre(nombreTripulacion);
		tripulacion.setBarco(nombreBarco);
		tripulacion.setEstaactiva(activa);
		tripulacionRepository.save(tripulacion);
		return tripulacion.getId();
	}

	@Override
	public Integer borrarTripulacion(Integer idTripulacion) {
	    // Usamos orElseThrow para controlar si no existe
	    TripulacionEntity tripulacion = tripulacionRepository.findById(idTripulacion).get();
	    
	    tripulacion.setEstaactiva(false); 
	    
	    tripulacionRepository.save(tripulacion);
	    return tripulacion.getId();
	}

	@Override
	public Integer actualizarTripulacion(Integer idTripulacion, String nombre, String barco, Boolean activa) {

	    TripulacionEntity tripulacion = tripulacionRepository.findById(idTripulacion).get();

	    tripulacion.setNombre(nombre);
	    tripulacion.setBarco(barco);
	    tripulacion.setEstaactiva(activa);

	    tripulacionRepository.save(tripulacion);
	    return tripulacion.getId();
	}
}
