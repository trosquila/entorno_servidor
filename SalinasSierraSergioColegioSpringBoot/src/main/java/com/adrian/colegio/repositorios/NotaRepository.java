package com.adrian.colegio.repositorios;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.adrian.colegio.dtos.NotaDTO;
import com.adrian.colegio.entities.NotaEntity;

public interface NotaRepository extends CrudRepository<NotaEntity, Integer> {

	@Query("""
		    SELECT new com.adrian.colegio.dtos.NotaDTO(
		        n.alumno.id,
		        n.alumno.nombre,
		        n.asignatura.nombre,
		        n.nota,
		        n.fecha
		    )
		    FROM NotaEntity n
		    WHERE (:idNota IS NULL OR n.id = :idNota)
		      AND (:idAlumno IS NULL OR n.alumno.id = :idAlumno)
		      AND (:idAsignatura IS NULL OR n.asignatura.id = :idAsignatura)
		""")
		ArrayList<NotaDTO> buscarNotas(
		    @Param("idNota") Integer idNota,
		    @Param("idAlumno") Integer idAlumno,
		    @Param("idAsignatura") Integer idAsignatura
		);

}
