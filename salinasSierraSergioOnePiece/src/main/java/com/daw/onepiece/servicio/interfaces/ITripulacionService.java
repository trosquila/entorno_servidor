package com.daw.onepiece.servicio.interfaces;

import java.util.ArrayList;

import com.daw.onepiece.dtos.TripulacionDTO;

public interface ITripulacionService {

	ArrayList<TripulacionDTO> BuscarTripulacionPorFiltros(Integer id, String nombre, String nombreBarco, Boolean activo);

}
