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
			+ "WHERE CAST (a.id AS STRING) LIKE CONCAT ('%',:id,'%') "
			+ "AND a.nombre LIKE CONCAT ('%',:nombre,'%') "
			+ "AND CAST (a.curso AS STRING) LIKE CONCAT ('%',:curso,'%') "
			+ "AND CAST (a.tasa AS STRING) LIKE CONCAT ('%',:tasa,'%') "
			+ "AND a.activo = :activo ")
			ArrayList<AsignaturaDTO>buscaAsignaturaporIDyNombre(@Param("id") Integer id,
			@Param("nombre") String nombre,
			@Param("curso") int curso,
			@Param("tasa") int tasa,
			@Param("activo") int activo);

}

