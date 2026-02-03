package com.daw.onepiece.dao.impl;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daw.onepiece.dao.interfaces.IPiratasDAO;
import com.daw.onepiece.dtos.PirataDTO;
import com.daw.onepiece.entities.IslaEntity;
import com.daw.onepiece.entities.PirataEntity;
import com.daw.onepiece.repositorios.IslaRepository;
import com.daw.onepiece.repositorios.PiratasRepository;

@Repository
public class PiratasDAOImpl implements IPiratasDAO{
	  @Autowired
	    private PiratasRepository piratasRepository;
	  
	  @Autowired
	    private IslaRepository islaRepository;
	@Override
	public ArrayList<PirataDTO> recogerPiratasPorFiltro(Integer idPirata, String nombrePirata, String frutaDiablo, Boolean activo) {
		return piratasRepository.listarPiratasPorFiltros(idPirata, nombrePirata, frutaDiablo, activo);
	}
	@Override
	public Integer guardarNuevoNakama(String nombre, String frutaDiablo, LocalDate fechaNacimiento, boolean activo, Integer islaId) {
		IslaEntity isla = islaRepository.findById(islaId).get();
		PirataEntity pirata = new PirataEntity(nombre, frutaDiablo, fechaNacimiento, activo, isla);
		piratasRepository.save(pirata);
		return pirata.getId();
	}
	@Override
	public Integer modificarNakama(Integer idPirata, String nombrePirata, String frutaDiablo, String fechaNacimiento,
			Integer idIsla, Boolean activo) {
		PirataEntity pirata = piratasRepository.findById(idPirata).get();
		IslaEntity isla  = islaRepository.findById(idIsla).get();
		LocalDate fecha = LocalDate.parse(fechaNacimiento);
		
		
		pirata.setNombre(nombrePirata);
		pirata.setFrutaDelDiablo(frutaDiablo);
		pirata.setFechaNacimiento(fecha);
		pirata.setIsla(isla);
		pirata.setActivo(activo);
		piratasRepository.save(pirata);
		return pirata.getId();
	}
	@Override
	public Integer borrarNakama(Integer idPirata) {
		PirataEntity pirata = piratasRepository.findById(idPirata).get();
		pirata.setActivo(false);
		piratasRepository.save(pirata);
		return pirata.getId();
	}
	@Override
	public ArrayList<PirataDTO> BuscarTripulacionBarco(Integer idTripulacion) {
		return piratasRepository.listarMiembrosPorTripulacion(idTripulacion);
	}

}
