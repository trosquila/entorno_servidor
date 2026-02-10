package com.daw.onepiece.dtos;

public class TripulacionDTO {
	private Integer id;
	private String nombre;
	private String barco;
	private Long cantidadMiembros;
	private Boolean activo;

	public TripulacionDTO() {
	}

	public TripulacionDTO(Integer id, String nombre, String barco, Long cantidadMiembros , Boolean activo) {
		this.id = id;
		this.nombre = nombre;
		this.barco = barco;
		this.activo = activo;
		this.cantidadMiembros = cantidadMiembros;
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
	public Long getCantidadMiembros() {
		return cantidadMiembros;
	}

	public void setCantidadMiembros(Long cantidadMiembros) {
		this.cantidadMiembros = cantidadMiembros;
	}
	public Boolean getActivo() {
	    return activo;
	}

	public void setActivo(Boolean activo) {
	    this.activo = activo;
	}
}
