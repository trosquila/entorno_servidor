package com.daw.onepiece.servicio.impl;

import java.math.BigDecimal;
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
	public ArrayList<RecompensaDTO> BuscarRecompensaPorFiltro(Integer idRecompensa, String nombrePirata, Integer idTripulacion,
			Long cantidad, Integer vigente) {
		// TODO Auto-generated method stub
		return recompensaDAO.recogerRecompensaPorFiltro(idRecompensa, nombrePirata, idTripulacion, cantidad, vigente);
	}

	@Override
	public Integer emitirRecompensa(Integer idPirata, BigDecimal cantidad) {
		return recompensaDAO.emitirRecompensa( idPirata, cantidad);
	}

	@Override
	public Integer actualizarRecompensa(Integer idRecompensa, Integer idPirata, BigDecimal cantidad, Boolean vigente) {
		// TODO Auto-generated method stub
		return recompensaDAO.actualizarRecompensa( idRecompensa,  idPirata,  cantidad,  vigente);
	}

	@Override
	public Integer eliminarRecompensa(Integer idRecompensa) {
		// TODO Auto-generated method stub
		return recompensaDAO.eliminarRecompensa(idRecompensa);
	}

}
