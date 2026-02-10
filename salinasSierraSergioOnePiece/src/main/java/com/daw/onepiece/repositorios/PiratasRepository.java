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
			    p.id,
			    p.nombre,
			    p.frutaDelDiablo,
			    p.fechaNacimiento,
			    p.activo,
			    new com.daw.onepiece.dtos.IslaDTO(i.id, i.nombre),
			    new com.daw.onepiece.dtos.TripulacionDTO(t.id, t.nombre),
			    new com.daw.onepiece.dtos.ReclutamientoDTO(r.id, r.rol, r.esMiembroActual)
			  )
			  FROM PirataEntity p
			  LEFT JOIN p.isla i
			  LEFT JOIN p.reclutamientos r ON r.esMiembroActual = true
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
	
	@Query("""
		      SELECT DISTINCT new com.daw.onepiece.dtos.PirataDTO(
		        p.id,
		        p.nombre,
		        p.frutaDelDiablo,
		        p.fechaNacimiento,
		        p.activo,
		        r.rol,
		        new com.daw.onepiece.dtos.IslaDTO(i.id, i.nombre),
		        new com.daw.onepiece.dtos.TripulacionDTO(t.id, t.nombre),
		        new com.daw.onepiece.dtos.ReclutamientoDTO(r.id, r.rol, r.esMiembroActual)
		      )
		      FROM PirataEntity p
		      INNER JOIN p.reclutamientos r
		      LEFT JOIN r.tripulacion t
		      LEFT JOIN p.isla i
		      WHERE (:idTripulacion IS NULL OR :idTripulacion = 0 OR t.id = :idTripulacion)
		        AND r.esMiembroActual = true
		        AND (:nombrePirata IS NULL OR :nombrePirata = '' OR LOWER(p.nombre) LIKE LOWER(CONCAT('%', :nombrePirata, '%')))
		        AND (:activo IS NULL OR p.activo = :activo)
		      ORDER BY p.id
		    """)
		    ArrayList<PirataDTO> listarMiembrosPorTripulacion(
		      @Param("idTripulacion") Integer idTripulacion,
		      @Param("nombrePirata") String nombrePirata,
		      @Param("activo") Boolean activo
		    );
	}