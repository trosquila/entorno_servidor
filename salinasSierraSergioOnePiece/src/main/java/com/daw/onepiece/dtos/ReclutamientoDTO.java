package com.daw.onepiece.dtos;

public class ReclutamientoDTO {
	private Integer id;
	private Integer pirataId;
	private Integer tripulacionId;
	private String rol;
	private Boolean esMiembroActual;

	public ReclutamientoDTO() {
	}

	public ReclutamientoDTO(Integer id, Integer pirataId, Integer tripulacionId, String rol, Boolean esMiembroActual) {
		this.id = id;
		this.pirataId = pirataId;
		this.tripulacionId = tripulacionId;
		this.rol = rol;
		this.esMiembroActual = esMiembroActual;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPirataId() {
		return pirataId;
	}

	public void setPirataId(Integer pirataId) {
		this.pirataId = pirataId;
	}

	public Integer getTripulacionId() {
		return tripulacionId;
	}

	public void setTripulacionId(Integer tripulacionId) {
		this.tripulacionId = tripulacionId;
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
