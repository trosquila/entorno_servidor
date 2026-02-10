package com.adrian.colegio.dtos;

public class AsignaturaDTO {
	private Integer id;
	private String nombre;
	private Integer curso;
	private double tasa;
	private Integer activo;
	
	public AsignaturaDTO(Integer id, String nombre, Integer curso, double tasa, int activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.curso = curso;
		this.tasa = tasa;
		this.activo = activo;
	}
	
	public AsignaturaDTO(Integer id, String nombre, Integer curso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.curso = curso;
	}
	
	public AsignaturaDTO(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public AsignaturaDTO() {

	}
	
	//Getters, setters...

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

	public Integer getCurso() {
		return curso;
	}

	public void setCurso(Integer curso) {
		this.curso = curso;
	}

	public double getTasa() {
		return tasa;
	}

	public void setTasa(double tasa) {
		this.tasa = tasa;
	}

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}
}
