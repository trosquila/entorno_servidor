package com.daw.onepiece.dao.interfaces;

import java.time.LocalDate;
import java.util.ArrayList;

import com.daw.onepiece.dtos.PirataDTO;

public interface IPiratasDAO {

	ArrayList<PirataDTO> recogerPiratasPorFiltro(Integer idPirata, String nombrePirata, String frutaDiablo, Boolean activo);

	Integer guardarNuevoNakama(String nombre, String frutaDiablo, LocalDate fechaNacimiento, boolean activo, Integer islaId);

	Integer modificarNakama(Integer idPirata, String nombrePirata, String frutaDiablo, String fechaNacimiento, Integer idIsla, Boolean activo);

}
