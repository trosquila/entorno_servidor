package com.daw.onepiece.repositorios;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.daw.onepiece.dtos.PirataDTO;
import com.daw.onepiece.entities.PirataEntity;


public interface PiratasRepository extends CrudRepository<PirataEntity, Integer> {
	
	@Query("SELECT new com.daw.onepiece.dtos.PiratasDTO() FROM PirataEntity p " +
	           "WHERE (:idPirata IS NULL OR p.id = :idPirata) " +
	           "AND (:nombrePirata IS NULL OR p.nombre LIKE %:nombrePirata%) " +
	           "AND (:frutaDiablo IS NULL OR p.frutaDelDiablo = :frutaDiablo) " +
	           "AND (:activo IS NULL OR p.activo = :activo)")
	    ArrayList<PirataDTO> listarPiratasPorFiltros(
	            @Param("idPirata") Integer idPirata,
	            @Param("nombrePirata") String nombrePirata,
	            @Param("frutaDiablo") String frutaDiablo,
	            @Param("activo") Boolean activo
	    );
}
