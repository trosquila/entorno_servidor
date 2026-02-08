package com.daw.onepiece.servicio.interfaces;

import java.util.ArrayList;

import com.daw.onepiece.dtos.RecompensaDTO;

public interface IRecompensaService {

	ArrayList<RecompensaDTO> BuscarRecompensaPorFiltro(String nombrePirata, Integer idTripulacion, Long cantidad,
			Integer vigente);

}
