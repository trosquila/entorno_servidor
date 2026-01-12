package com.adrian.colegio.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "asignaturas")

public class AsignaturaEntity {
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "curso")
	private int curso;

	@Column(name = "tasa")
	private int tasa;

	@Column(name = "activo")
	private int activo;

	public AsignaturaEntity(int id, String nombre, int curso, int tasa, int activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.curso = curso;
		this.tasa = tasa;
		this.activo = activo;
	}
	
	public AsignaturaEntity() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}

	public int getTasa() {
		return tasa;
	}

	public void setTasa(int tasa) {
		this.tasa = tasa;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}
	
	
}
