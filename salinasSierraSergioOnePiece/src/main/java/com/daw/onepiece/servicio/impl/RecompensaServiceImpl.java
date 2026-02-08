package com.daw.onepiece.servicio.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.onepiece.dao.interfaces.IRecompensaDAO;
import com.daw.onepiece.dtos.RecompensaDTO;
import com.daw.onepiece.servicio.interfaces.IRecompensaService;
@Service
public class RecompensaServiceImpl implements IRecompensaService{
	@Autowired
	IRecompensaDAO recompensaDAO;
	
	@Override
	public ArrayList<RecompensaDTO> BuscarRecompensaPorFiltro(String nombrePirata, Integer idTripulacion,
			Long cantidad, Integer vigente) {
		// TODO Auto-generated method stub
		return recompensaDAO.recogerRecompensaPorFiltro( nombrePirata, idTripulacion, cantidad, vigente);
	}

}
