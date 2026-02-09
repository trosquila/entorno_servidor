package com.daw.onepiece.dao.interfaces;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.daw.onepiece.dtos.RecompensaDTO;

public interface IRecompensaDAO {

	ArrayList<RecompensaDTO> recogerRecompensaPorFiltro(Integer idRecompensa, String nombrePirata, Integer idTripulacion, Long cantidad, Integer vigente);

	Integer emitirRecompensa(Integer idPirata, BigDecimal cantidad);

	Integer actualizarRecompensa(Integer idRecompensa, Integer idPirata, BigDecimal cantidad, Boolean vigente);

	Integer eliminarRecompensa(Integer idRecompensa);

}
