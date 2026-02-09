package com.daw.onepiece.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daw.onepiece.dao.interfaces.IRecompensaDAO;
import com.daw.onepiece.dtos.RecompensaDTO;
import com.daw.onepiece.entities.PirataEntity;
import com.daw.onepiece.entities.RecompensaEntity;
import com.daw.onepiece.repositorios.PiratasRepository;
import com.daw.onepiece.repositorios.RecompensaRepository;

@Repository
public class RecompensaDAOImpl implements IRecompensaDAO{
	@Autowired
	private RecompensaRepository recompensaRepository;
	
	  @Autowired
	    private PiratasRepository piratasRepository;
	  
	
	@Override
	public ArrayList<RecompensaDTO> recogerRecompensaPorFiltro(Integer idRecompensa, String nombrePirata, Integer idTripulacion,
			Long cantidad, Integer vigente) {
		return recompensaRepository.listaRecompensaFiltroPrincipal(idRecompensa, nombrePirata, idTripulacion, cantidad, vigente);
	}
	@Override
	public Integer emitirRecompensa(Integer idPirata, BigDecimal cantidad) {
		PirataEntity pirata = piratasRepository.findById(idPirata).get();
		RecompensaEntity recompensa = new RecompensaEntity(pirata, cantidad, true);
		recompensaRepository.save(recompensa);
		return recompensa.getId();
	}
	@Override
	public Integer actualizarRecompensa(Integer idRecompensa, Integer idPirata, BigDecimal cantidad, Boolean vigente) {
		PirataEntity pirata = piratasRepository.findById(idPirata).get();
		RecompensaEntity recompensa = recompensaRepository.findById(idRecompensa).get();
		
		recompensa.setPirata(pirata);
	    recompensa.setCantidad(cantidad);
	    recompensa.setEstaVigente(vigente);
	    
	    recompensaRepository.save(recompensa);
	    
	    return recompensa.getId();
	}
	@Override
	public Integer eliminarRecompensa(Integer idRecompensa) {
		
		RecompensaEntity recompensa = recompensaRepository.findById(idRecompensa).get();
		recompensa.setEstaVigente(false);
		
		recompensaRepository.save(recompensa);
		return recompensa.getId();
	}

}
