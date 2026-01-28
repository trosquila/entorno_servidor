package com.daw.onepiece.dtos;


public class RecompensaDTO {
	private Integer id;
	private Integer pirataId;
	private Double cantidad;
	private Boolean estaVigente;

	public RecompensaDTO() {
	}

	public RecompensaDTO(Integer id, Integer pirataId, Double cantidad, Boolean estaVigente) {
		this.id = id;
		this.pirataId = pirataId;
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

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public Boolean getEstaVigente() {
		return estaVigente;
	}

	public void setEstaVigente(Boolean estaVigente) {
		this.estaVigente = estaVigente;
	}
}
