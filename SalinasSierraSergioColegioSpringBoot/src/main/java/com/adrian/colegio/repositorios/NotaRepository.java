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
           "FROM com.adrian.colegio.entities.NotaEntity n " +
           "WHERE (:idNota IS NULL OR CAST(n.id AS string) LIKE CONCAT('%', :idNota, '%')) " +
           "AND (:idAlumno IS NULL OR CAST(n.alumno.id AS string) LIKE CONCAT('%', :idAlumno, '%')) " +
           "AND (:idAsignatura IS NULL OR CAST(n.asignatura.id AS string) LIKE CONCAT('%', :idAsignatura, '%'))")
    ArrayList<NotaDTO> buscarNotas(
            @Param("idNota") Integer idNota,
            @Param("idAlumno") Integer idAlumno,
            @Param("idAsignatura") Integer idAsignatura
    );
}