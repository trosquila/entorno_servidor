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
           "c.alumno.id, " +
           "c.alumno.nombre, " +
           "c.importe ) " +
           "FROM com.adrian.colegio.entities.CajaEntity c " +
           "WHERE (:id IS NULL OR CAST(c.id AS string) LIKE CONCAT('%', :id, '%')) " +
           "AND (:idAlumno IS NULL OR CAST(c.alumno.id AS string) LIKE CONCAT('%', :idAlumno, '%')) " +
           "AND (:nombreAlumno IS NULL OR c.alumno.nombre LIKE CONCAT('%', :nombreAlumno, '%')) " +
           "AND (:importe IS NULL OR CAST(c.importe AS string) LIKE CONCAT('%', :importe, '%'))")
    ArrayList<CajaDTO> buscaCajaAvanzada(
            @Param("id") Integer id,
            @Param("idAlumno") Integer idAlumno,
            @Param("nombreAlumno") String nombreAlumno,
            @Param("importe") Integer importe
    );
}
