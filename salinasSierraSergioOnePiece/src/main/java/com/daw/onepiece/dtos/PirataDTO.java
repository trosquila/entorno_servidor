package com.daw.onepiece.dtos;

import java.time.LocalDate;

public class PirataDTO {
	private Integer id;
	private String nombre;
	private String frutaDelDiablo;
	private LocalDate fechaNacimiento;
	private Boolean activo;
	private Integer islaId;
	private String islaNombre;
	private String tripulacion;
	private String rol;

	public PirataDTO() {
	}

	public PirataDTO(Integer id, String nombre, String frutaDelDiablo, LocalDate fechaNacimiento, Boolean activo,
			Integer islaId) {
		this.id = id;
		this.nombre = nombre;
		this.frutaDelDiablo = frutaDelDiablo;
		this.fechaNacimiento = fechaNacimiento;
		this.activo = activo;
		this.islaId = islaId;
	}


	public PirataDTO(Integer id, String nombre, String frutaDelDiablo, LocalDate fechaNacimiento, Boolean activo,
			String tripulacion, String rol, String islaNombre) {
		this.id = id;
		this.nombre = nombre;
		this.frutaDelDiablo = frutaDelDiablo;
		this.fechaNacimiento = fechaNacimiento;
		this.activo = activo;
		this.tripulacion = tripulacion;
		this.rol = rol;
		this.islaNombre = islaNombre;
	}
	public PirataDTO(Integer id, String nombre, String frutaDelDiablo, LocalDate fechaNacimiento, Boolean activo,
            Integer islaId, String islaNombre, String tripulacion, String rol) {
this.id = id;
this.nombre = nombre;
this.frutaDelDiablo = frutaDelDiablo;
this.fechaNacimiento = fechaNacimiento;
this.activo = activo;
this.islaId = islaId;
this.islaNombre = islaNombre;
this.tripulacion = tripulacion;
this.rol = rol;
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

	public Integer getIslaId() {
		return islaId;
	}

	public void setIslaId(Integer islaId) {
		this.islaId = islaId;
	}

	public String getIslaNombre() {
		return islaNombre;
	}

	public void setIslaNombre(String islaNombre) {
		this.islaNombre = islaNombre;
	}

	public String getTripulacion() {
	    return tripulacion;
	}

	public void setTripulacion(String tripulacion) {
	    this.tripulacion = tripulacion;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
}
