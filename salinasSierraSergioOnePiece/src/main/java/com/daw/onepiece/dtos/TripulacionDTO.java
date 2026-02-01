package com.daw.onepiece.dtos;

public class TripulacionDTO {
	private Integer id;
	private String nombre;
	private String barco;
	private Boolean estaActiva;

	public TripulacionDTO() {
	}

	public TripulacionDTO(Integer id, String nombre, String barco, Boolean estaActiva) {
		this.id = id;
		this.nombre = nombre;
		this.barco = barco;
		this.estaActiva = estaActiva;
	}
	
	public TripulacionDTO(Integer id, String nombre) {
	    this.id = id;
	    this.nombre = nombre;
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

	public String getBarco() {
		return barco;
	}

	public void setBarco(String barco) {
		this.barco = barco;
	}

	public Boolean getEstaActiva() {
		return estaActiva;
	}

	public void setEstaActiva(Boolean estaActiva) {
		this.estaActiva = estaActiva;
	}
}
