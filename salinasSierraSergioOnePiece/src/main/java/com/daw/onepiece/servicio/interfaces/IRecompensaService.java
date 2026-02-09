package com.daw.onepiece.servicio.interfaces;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.daw.onepiece.dtos.RecompensaDTO;

public interface IRecompensaService {

	ArrayList<RecompensaDTO> BuscarRecompensaPorFiltro(Integer idRecompensa, String nombrePirata, Integer idTripulacion, Long cantidad, Integer vigente);

	Integer emitirRecompensa(Integer idPirata, BigDecimal cantidad);

	Integer actualizarRecompensa(Integer idRecompensa, Integer idPirata, BigDecimal cantidad, Boolean vigente);

	Integer eliminarRecompensa(Integer idRecompensa);

}