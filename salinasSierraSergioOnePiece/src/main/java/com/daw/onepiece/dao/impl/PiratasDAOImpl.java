package com.daw.onepiece.dao.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daw.onepiece.dao.interfaces.IPiratasDAO;
import com.daw.onepiece.dtos.PirataDTO;
import com.daw.onepiece.repositorios.PiratasRepository;

@Repository
public class PiratasDAOImpl implements IPiratasDAO{
	  @Autowired
	    private PiratasRepository piratasRepository;
	@Override
	public ArrayList<PirataDTO> recogerPiratasPorFiltro(Integer idPirata, String nombrePirata, String frutaDiablo, Boolean activo) {
		return piratasRepository.listarPiratasPorFiltros(idPirata, nombrePirata, frutaDiablo, activo);
	}

}
