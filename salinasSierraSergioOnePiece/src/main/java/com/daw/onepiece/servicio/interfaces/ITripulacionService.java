package com.daw.onepiece.servicio.interfaces;

import java.util.ArrayList;

import com.daw.onepiece.dtos.TripulacionDTO;

public interface ITripulacionService {

	ArrayList<TripulacionDTO> BuscarTripulacionPorFiltros(Integer id, String nombre, String nombreBarco, Boolean activo);

	Integer modificarTripulacionEnDetalles(Integer idTripulacion, Integer idPirata, String rol);

	Integer eliminarMiembroTripulacion(Integer idPirata, Integer idTripulacion);

	Integer guardarNuevaTripulacion(String nombreTripulacion, String nombreBarco, Boolean activa);

	Integer borrarTripulacion(Integer idTripulacion);

}
