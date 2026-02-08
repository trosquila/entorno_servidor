package com.daw.onepiece.repositorios;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.daw.onepiece.dtos.RecompensaDTO;
import com.daw.onepiece.entities.RecompensaEntity;

public interface RecompensaRepository extends CrudRepository<RecompensaEntity, Integer> {

    @Query("""
          SELECT new com.daw.onepiece.dtos.RecompensaDTO(
            r.id,
            r.pirata.id,
            r.cantidad,
            r.estaVigente
          )
          FROM RecompensaEntity r
          WHERE (:idRecompensa IS NULL OR :idRecompensa = 0 OR r.id = :idRecompensa)
            AND (:pirataId IS NULL OR :pirataId = 0 OR r.pirata.id = :pirataId)
            AND (:estaVigente IS NULL OR r.estaVigente = :estaVigente)
            AND (:cantidadMinima IS NULL OR r.cantidad >= :cantidadMinima)
            AND (:cantidadMaxima IS NULL OR r.cantidad <= :cantidadMaxima)
          ORDER BY r.cantidad DESC, r.id
        """)
    ArrayList<RecompensaDTO> listarRecompensasPorFiltros(
      @Param("idRecompensa") Integer idRecompensa,
      @Param("pirataId") Integer pirataId,
      @Param("estaVigente") Boolean estaVigente,
      @Param("cantidadMinima") Double cantidadMinima,
      @Param("cantidadMaxima") Double cantidadMaxima
    );

    @Query("""
    	    SELECT new com.daw.onepiece.dtos.RecompensaDTO(
    	        r.id,
    	        p.id,
    	        p.nombre,
    	        t.nombre,
    	        r.cantidad,
    	        r.estaVigente
    	    )
    	    FROM RecompensaEntity r
    	    JOIN r.pirata p
    	    LEFT JOIN ReclutamientoEntity rec
    	           ON rec.pirata.id = p.id AND rec.esMiembroActual = true
    	    LEFT JOIN rec.tripulacion t
    	    WHERE (:nombrePirata IS NULL OR :nombrePirata = ''
    	           OR LOWER(p.nombre) LIKE LOWER(CONCAT('%', :nombrePirata, '%')))
    	      AND (:idTripulacion IS NULL OR :idTripulacion = 0 OR t.id = :idTripulacion)
    	      AND (:cantidad IS NULL OR r.cantidad >= :cantidad)
    	      AND (:vigente IS NULL OR r.estaVigente = CASE WHEN :vigente = 1 THEN true ELSE false END)
    	    ORDER BY r.cantidad DESC, r.id
    	""")
    	ArrayList<RecompensaDTO> listaRecompensaFiltroPrincipal(
    	    @Param("nombrePirata") String nombrePirata,
    	    @Param("idTripulacion") Integer idTripulacion,
    	    @Param("cantidad") Long cantidad,
    	    @Param("vigente") Integer vigente
    	);

}	