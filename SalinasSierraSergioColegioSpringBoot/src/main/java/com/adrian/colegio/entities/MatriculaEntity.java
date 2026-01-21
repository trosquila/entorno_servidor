package com.adrian.colegio.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "matriculaciones")
public class MatriculaEntity {
	@Id
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_alumno")
	private AlumnoEntity alumno;

	@ManyToOne
	@JoinColumn(name = "id_asignatura")
	private AsignaturaEntity asignatura;

	@Column(name = "fecha")
	private String fecha;
	
	@Column(name = "activo")
	private int activo;

	public MatriculaEntity(int id, AlumnoEntity alumno, AsignaturaEntity asignatura, String fecha, int activo) {
		super();
		this.id = id;
		this.alumno = alumno;
		this.asignatura = asignatura;
		this.fecha = fecha;
		this.activo = activo;
	}

	public MatriculaEntity() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AlumnoEntity getAlumno() {
		return alumno;
	}

	public void setAlumno(AlumnoEntity alumno) {
		this.alumno = alumno;
	}

	public AsignaturaEntity getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(AsignaturaEntity asignatura) {
		this.asignatura = asignatura;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}
	
	
	
	
}
