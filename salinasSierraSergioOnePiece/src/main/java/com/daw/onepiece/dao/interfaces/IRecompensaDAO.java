package com.daw.onepiece.dao.interfaces;

import java.util.ArrayList;

import com.daw.onepiece.dtos.RecompensaDTO;

public interface IRecompensaDAO {

	ArrayList<RecompensaDTO> recogerRecompensaPorFiltro(String nombrePirata, Integer idTripulacion, Long cantidad, Integer vigente);

}
