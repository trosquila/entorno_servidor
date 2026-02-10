package com.daw.onepiece.dtos;

import java.math.BigDecimal;

public class RecompensaDTO {
	private Integer id;
	private Integer pirataId;
	private BigDecimal cantidad;
	private Boolean estaVigente;

	private String nombrePirata;
	private String tripulacion;

	public RecompensaDTO() {
	}

	public RecompensaDTO(Integer id, Integer pirataId, BigDecimal cantidad, Boolean estaVigente) {
		this.id = id;
		this.pirataId = pirataId;
		this.cantidad = cantidad;
		this.estaVigente = estaVigente;
	}

	public RecompensaDTO(Integer id, Integer pirataId, String nombrePirata, String tripulacion, BigDecimal cantidad,
			Boolean estaVigente) {
		this.id = id;
		this.pirataId = pirataId;
		this.nombrePirata = nombrePirata;
		this.tripulacion = tripulacion;
		this.cantidad = cantidad;
		this.estaVigente = estaVigente;
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

	public BigDecimal getCantidad() {
		return cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public Boolean getEstaVigente() {
		return estaVigente;
	}

	public void setEstaVigente(Boolean estaVigente) {
		this.estaVigente = estaVigente;
	}

	public String getNombrePirata() {
		return nombrePirata;
	}

	public void setNombrePirata(String nombrePirata) {
		this.nombrePirata = nombrePirata;
	}

	public String getTripulacion() {
		return tripulacion;
	}

	public void setTripulacion(String tripulacion) {
		this.tripulacion = tripulacion;
	}
}
