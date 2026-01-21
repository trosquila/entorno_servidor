package com.adrian.colegio.repositorios;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.adrian.colegio.dtos.MatriculaDTO;
import com.adrian.colegio.entities.MatriculaEntity;

public interface MatriculaRepository extends CrudRepository<MatriculaEntity, Integer> {

    @Query("select new com.adrian.colegio.dtos.MatriculaDTO ( " +
           "m.id, " +
           "m.alumno.id, " +
           "m.asignatura.id, " +
           "m.alumno.nombre, " +
           "m.asignatura.nombre, " +
           "m.fecha, " +
           "m.caja.importe, " +
           "m.activo ) " +
           "FROM com.adrian.colegio.entities.MatriculaEntity m " +
           "WHERE "+
           " (:nombreAlumno IS NULL OR m.alumno.nombre LIKE CONCAT('%', :nombreAlumno, '%')) " +
           "AND (:nombreAsignatura IS NULL OR m.asignatura.nombre LIKE CONCAT('%', :nombreAsignatura, '%')) " +
           "AND (:fecha IS NULL OR m.fecha = :fecha) " +
           "AND m.activo = :activo ")
    ArrayList<MatriculaDTO> buscaMatriculaAvanzada(
            @Param("nombreAlumno") String nombreAlumno,
            @Param("nombreAsignatura") String nombreAsignatura,
            @Param("fecha") String fecha,
            @Param("activo") Integer activo
    );
}
