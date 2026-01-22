package com.adrian.colegio.repositorios;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.adrian.colegio.dtos.CajaDTO;
import com.adrian.colegio.entities.CajaEntity;

public interface CajaRepository extends CrudRepository<CajaEntity, Integer> {

	@Query("select new com.adrian.colegio.dtos.CajaDTO ( " +
		       "c.id, " +
		       "c.matricula.alumno.id, " +       
		       "c.matricula.alumno.nombre, " +   
		       "c.importe ) " +
		       "FROM CajaEntity c " +
		       "WHERE (:id IS NULL OR CAST(c.id AS string) LIKE CONCAT('%', :id, '%')) " +
		       "AND (:idAlumno IS NULL OR CAST(c.matricula.alumno.id AS string) LIKE CONCAT('%', :idAlumno, '%')) " + // Corregido
		       "AND (:nombreAlumno IS NULL OR c.matricula.alumno.nombre LIKE CONCAT('%', :nombreAlumno, '%')) " +       // Corregido
		       "AND (:importe IS NULL OR CAST(c.importe AS string) LIKE CONCAT('%', :importe, '%'))")
		ArrayList<CajaDTO> buscaCajaAvanzada(
		        @Param("id") Integer id,
		        @Param("idAlumno") Integer idAlumno,
		        @Param("nombreAlumno") String nombreAlumno,
		        @Param("importe") Integer importe
		);
}
