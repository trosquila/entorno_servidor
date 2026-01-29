package com.daw.onepiece.repositorios;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.daw.onepiece.dtos.PirataDTO;
import com.daw.onepiece.entities.PirataEntity;

public interface PiratasRepository extends CrudRepository<PirataEntity, Integer> {

	  @Query("""
	    SELECT DISTINCT new com.daw.onepiece.dtos.PirataDTO(
	      p.id, p.nombre, p.frutaDelDiablo, p.fechaNacimiento, p.activo,
	      t.nombre, r.rol, i.nombre
	    )
	    FROM PirataEntity p
	    LEFT JOIN p.isla i
	    LEFT JOIN p.reclutamientos r WITH r.esMiembroActual = true
	    LEFT JOIN r.tripulacion t
	    WHERE (:idPirata IS NULL OR :idPirata = 0 OR p.id = :idPirata)
	      AND (:nombrePirata IS NULL OR :nombrePirata = '' OR LOWER(p.nombre) LIKE LOWER(CONCAT('%', :nombrePirata, '%')))
	      AND (:frutaDiablo IS NULL OR :frutaDiablo = '' OR LOWER(p.frutaDelDiablo) LIKE LOWER(CONCAT('%', :frutaDiablo, '%')))
	      AND (:activo IS NULL OR p.activo = :activo)
	    ORDER BY p.id
	  """)
	  ArrayList<PirataDTO> listarPiratasPorFiltros(
	      @Param("idPirata") Integer idPirata,
	      @Param("nombrePirata") String nombrePirata,
	      @Param("frutaDiablo") String frutaDiablo,
	      @Param("activo") Boolean activo
	  );
	}