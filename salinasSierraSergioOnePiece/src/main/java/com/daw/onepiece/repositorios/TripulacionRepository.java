package com.daw.onepiece.repositorios;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.daw.onepiece.dtos.TripulacionDTO;
import com.daw.onepiece.entities.TripulacionEntity;

public interface TripulacionRepository extends CrudRepository<TripulacionEntity, Integer> {

	@Query("""
			  SELECT new com.daw.onepiece.dtos.TripulacionDTO(
			    t.id,
			    t.nombre,
			    t.barco,
			    COUNT(DISTINCT r.pirata.id),
			    t.estaactiva
			  )
			  FROM TripulacionEntity t
			  LEFT JOIN t.reclutamientos r WITH r.esMiembroActual = true
			  WHERE (:id IS NULL OR :id = 0 OR t.id = :id)
			    AND (:nombre IS NULL OR :nombre = '' OR LOWER(t.nombre) LIKE LOWER(CONCAT('%', :nombre, '%')))
			    AND (:nombreBarco IS NULL OR :nombreBarco = '' OR LOWER(t.barco) LIKE LOWER(CONCAT('%', :nombreBarco, '%')))
			    AND (:activo IS NULL OR t.estaactiva = :activo)
			  GROUP BY t.id, t.nombre, t.barco, t.estaactiva
			  ORDER BY t.id
			""")
			ArrayList<TripulacionDTO> listarTripulacionPorFiltros(
			  @Param("id") Integer id,
			  @Param("nombre") String nombre,
			  @Param("nombreBarco") String nombreBarco,
			  @Param("activo") Boolean activo
			);


}
