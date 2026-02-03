package com.daw.onepiece.servicio.interfaces;

import java.time.LocalDate;
import java.util.ArrayList;

import com.daw.onepiece.dtos.PirataDTO;

public interface IPirataService {

	ArrayList<PirataDTO> BuscarPirataPorFiltro(Integer idPirata, String nombrePirata, String frutaDiablo, Boolean activo);

	Integer guardarNuevoNakama(String nombre, String frutaDiablo, LocalDate fechaNacimiento, boolean activo, Integer islaId);

	Integer ModificarPirata(Integer idPirata, String nombrePirata, String frutaDiablo, String fechaNacimiento,
			Integer idIsla, Boolean activo);

	Integer borrarPirata(Integer idPirata);

	ArrayList<PirataDTO> BuscarTripulacionBarco(Integer idTripulacion, String nombrePirata, Boolean activo);

}
