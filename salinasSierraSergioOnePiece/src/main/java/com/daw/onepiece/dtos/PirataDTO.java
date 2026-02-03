package com.daw.onepiece.dtos;

import java.time.LocalDate;

public class PirataDTO {
	private Integer id;
	private String nombre;
	private String frutaDelDiablo;
	private LocalDate fechaNacimiento;
	private Boolean activo;
	private String rol;
	private IslaDTO isla;

	private TripulacionDTO tripulacion;
	private  ReclutamientoDTO reclutamiento;

	public PirataDTO() {
	}

	public PirataDTO(Integer id, String nombre, String frutaDelDiablo, LocalDate fechaNacimiento, Boolean activo,
			IslaDTO isla, TripulacionDTO tripulacion, ReclutamientoDTO reclutamiento) {
		this.id = id;
		this.nombre = nombre;
		this.frutaDelDiablo = frutaDelDiablo;
		this.fechaNacimiento = fechaNacimiento;
		this.activo = activo;
		this.isla = isla;
		this.tripulacion = tripulacion;
		this.reclutamiento = reclutamiento;
	}
	public PirataDTO(Integer id, String nombre, String frutaDelDiablo, LocalDate fechaNacimiento, Boolean activo, String rol, IslaDTO isla, TripulacionDTO tripulacion, ReclutamientoDTO reclutamiento) {
		this.id = id;
		this.nombre = nombre;
		this.frutaDelDiablo = frutaDelDiablo;
		this.fechaNacimiento = fechaNacimiento;
		this.activo = activo;
		this.isla = isla;
		this.rol = rol;
		this.tripulacion = tripulacion;
		this.reclutamiento = reclutamiento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFrutaDelDiablo() {
		return frutaDelDiablo;
	}

	public void setFrutaDelDiablo(String frutaDelDiablo) {
		this.frutaDelDiablo = frutaDelDiablo;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public IslaDTO getIsla() {
		return isla;
	}

	public void setIsla(IslaDTO isla) {
		this.isla = isla;
	}

	public TripulacionDTO getTripulacion() {
		return tripulacion;
	}

	public void setTripulacion(TripulacionDTO tripulacion) {
		this.tripulacion = tripulacion;
	}

	public ReclutamientoDTO getReclutamiento() {
		return reclutamiento;
	}

	public void setReclutamiento(ReclutamientoDTO reclutamiento) {
		this.reclutamiento = reclutamiento;
	}



}
