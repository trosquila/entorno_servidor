package com.daw.onepiece.repositorios;

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
}	