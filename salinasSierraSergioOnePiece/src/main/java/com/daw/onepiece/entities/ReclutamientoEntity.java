package com.daw.onepiece.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reclutamiento")
public class ReclutamientoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pirata_id", nullable = false)
    private PirataEntity pirata;

    @ManyToOne
    @JoinColumn(name = "tripulacion_id", nullable = false)
    private TripulacionEntity tripulacion;

    @Column(name = "rol")
    private String rol;

    @Column(name = "esmiembroactual")
    private Boolean esMiembroActual;

	public ReclutamientoEntity(Integer id, PirataEntity pirata, TripulacionEntity tripulacion, String rol,
			Boolean esMiembroActual) {
		super();
		this.id = id;
		this.pirata = pirata;
		this.tripulacion = tripulacion;
		this.rol = rol;
		this.esMiembroActual = esMiembroActual;
	}
	
	public ReclutamientoEntity(PirataEntity pirata, TripulacionEntity tripulacion, String rol,
			Boolean esMiembroActual) {
		super();
		this.pirata = pirata;
		this.tripulacion = tripulacion;
		this.rol = rol;
		this.esMiembroActual = esMiembroActual;
	}

	public ReclutamientoEntity() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PirataEntity getPirata() {
		return pirata;
	}

	public void setPirata(PirataEntity pirata) {
		this.pirata = pirata;
	}

	public TripulacionEntity getTripulacion() {
		return tripulacion;
	}

	public void setTripulacion(TripulacionEntity tripulacion) {
		this.tripulacion = tripulacion;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Boolean getEsMiembroActual() {
		return esMiembroActual;
	}

	public void setEsMiembroActual(Boolean esMiembroActual) {
		this.esMiembroActual = esMiembroActual;
	}
    
    

}
