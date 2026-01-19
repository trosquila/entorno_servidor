package com.adrian.colegio.repositorios;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.adrian.colegio.dtos.NotaDTO;
import com.adrian.colegio.entities.NotaEntity;

public interface NotaRepository extends CrudRepository<NotaEntity, Integer> {

	@Query("SELECT new com.adrian.colegio.dtos.NotaDTO( " +
		       "n.id, " +
		       "n.alumno.id, " +
		       "n.asignatura.id, " +
		       "n.alumno.nombre, " +
		       "n.asignatura.nombre, " +
		       "n.nota, " +
		       "n.fecha ) " +
		       "FROM NotaEntity n " +
		       "WHERE (:idAlumno IS NULL OR n.alumno.id = :idAlumno) " +
		       "AND (:nombreAlumno IS NULL OR LOWER(n.alumno.nombre) LIKE LOWER(CONCAT('%', :nombreAlumno, '%'))) " +
		       "AND (:asignatura IS NULL OR LOWER(n.asignatura.nombre) LIKE LOWER(CONCAT('%', :asignatura, '%'))) " +
		       "AND (:nota IS NULL OR n.nota = :nota) " +
		       "AND (:fecha IS NULL OR n.fecha = :fecha) " +
		       "AND (:activo IS NULL OR n.alumno.activo = :activo)")
	ArrayList<NotaDTO> buscarNotasAvanzado(
	        @Param("idAlumno") Integer idAlumno,
	        @Param("nombreAlumno") String nombreAlumno,
	        @Param("asignatura") String asignatura,
	        @Param("nota") Integer nota,
	        @Param("fecha") String fecha,
	        @Param("activo") Integer activo
	);


}