package com.daw.onepiece.dao.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daw.onepiece.dao.interfaces.IRecompensaDAO;
import com.daw.onepiece.dtos.RecompensaDTO;
import com.daw.onepiece.repositorios.RecompensaRepository;

@Repository
public class RecompensaDAOImpl implements IRecompensaDAO{
	@Autowired
	private RecompensaRepository recompensaRepository;
	@Override
	public ArrayList<RecompensaDTO> recogerRecompensaPorFiltro(String nombrePirata, Integer idTripulacion,
			Long cantidad, Integer vigente) {
		return recompensaRepository.listaRecompensaFiltroPrincipal(nombrePirata, idTripulacion, cantidad, vigente);
	}

}
