package com.daw.onepiece.dao.interfaces;

public interface ITripulacionDAO {

	Integer modificarTripulacionEnDetalles(Integer idTripulacion, Integer idPirata, String rol);

	Integer eliminarMiembroTripulacion(Integer idPirata, Integer idTripulacion);

	Integer guardarNuevaTripulacion(String nombreTripulacion, String nombreBarco, Boolean activa);

	Integer borrarTripulacion(Integer idTripulacion);

}
