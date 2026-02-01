package com.daw.onepiece.servicio.impl;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.onepiece.dao.interfaces.IPiratasDAO;
import com.daw.onepiece.dtos.PirataDTO;
import com.daw.onepiece.servicio.interfaces.IPirataService;
@Service
public class PiratasServiceImpl implements IPirataService{
	@Autowired
	private IPiratasDAO pirataDAO;
	
	@Override
	public ArrayList<PirataDTO> BuscarPirataPorFiltro(Integer idPirata, String nombrePirata, String frutaDiablo, Boolean activo) {
		return pirataDAO.recogerPiratasPorFiltro(idPirata, nombrePirata, frutaDiablo, activo);
	}

	@Override
	public Integer guardarNuevoNakama(String nombre, String frutaDiablo, LocalDate fechaNacimiento, boolean activo, Integer islaId) {
		
		return pirataDAO.guardarNuevoNakama(nombre, frutaDiablo, fechaNacimiento, activo, islaId);
	}

	@Override
	public Integer ModificarPirata(Integer idPirata, String nombrePirata, String frutaDiablo, String fechaNacimiento,
			Integer idIsla, Boolean activo) {
		return pirataDAO.modificarNakama( idPirata, nombrePirata, frutaDiablo, fechaNacimiento, idIsla,  activo);
	}

	@Override
	public Integer borrarPirata(Integer idPirata) {
		return pirataDAO.borrarNakama(idPirata);
	}

}
