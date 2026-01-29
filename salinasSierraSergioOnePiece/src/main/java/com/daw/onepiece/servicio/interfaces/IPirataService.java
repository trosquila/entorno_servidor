package com.daw.onepiece.servicio.interfaces;

import java.util.ArrayList;

import com.daw.onepiece.dtos.PirataDTO;

public interface IPirataService {

	ArrayList<PirataDTO> BuscarPirataPorFiltro(Integer idPirata, String nombrePirata, String frutaDiablo, Boolean activo);

}
