package com.daw.onepiece.dao.interfaces;

import java.util.ArrayList;

import com.daw.onepiece.dtos.PirataDTO;

public interface IPiratasDAO {

	ArrayList<PirataDTO> recogerPiratasPorFiltro(Integer idPirata, String nombrePirata, String frutaDiablo, Boolean activo);

}
