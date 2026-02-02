package com.daw.onepiece.repositorios;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.daw.onepiece.entities.ReclutamientoEntity;

import jakarta.transaction.Transactional;

public interface ReclutamientoRepository extends CrudRepository<ReclutamientoEntity, Integer> {

    @Query("SELECT r FROM ReclutamientoEntity r")
    ArrayList<ReclutamientoEntity> obtenerTodosLosReclutamientos();
    
    @Modifying
    @Transactional
    @Query("UPDATE com.daw.onepiece.entities.ReclutamientoEntity r "
    + "SET r.esMiembroActual = false "
    + "WHERE r.pirata.id = :idPirata "
    + "AND r.esMiembroActual = true")
    void desactivarReclutamientosDelPirata(@Param("idPirata") Integer idPirata);

}