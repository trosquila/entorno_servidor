package com.adrian.colegio.repositorios;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.adrian.colegio.dtos.AsignaturaDTO;
import com.adrian.colegio.entities.AsignaturaEntity;

public interface AsignaturaRepository extends CrudRepository<AsignaturaEntity, Integer>{
	@Query("select new com.adrian.colegio.dtos.AsignaturaDTO (a.id,a.nombre,a.curso,a.tasa,a.activo) "
			+ "FROM com.adrian.colegio.entities.AsignaturaEntity a "
			+ "WHERE (:id IS NULL OR CAST(a.id AS string) LIKE CONCAT('%', :id, '%')) "
			+ "AND (:nombre IS NULL OR a.nombre LIKE CONCAT('%', :nombre, '%')) "  
			+ "AND (:curso IS NULL OR CAST(a.curso AS string) LIKE CONCAT('%', :curso, '%')) "
			+ "AND (:tasa IS NULL OR CAST(a.tasa AS string) LIKE CONCAT('%', :tasa, '%')) "
			+ "AND a.activo = :activo ")
			ArrayList<AsignaturaDTO>buscaAsignaturaporIDyNombre(@Param("id") Integer id,
			@Param("nombre") String nombre,
			@Param("curso") Integer curso,
			@Param("tasa") Integer tasa,
			@Param("activo") Integer activo);

}

