package com.adrian.colegio.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "caja")
public class CajaEntity {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_alumno")
	private AlumnoEntity alumno;
	
	@Column(name = "importe")
	private int importe;

	public CajaEntity(int id, AlumnoEntity alumno, int importe) {
		super();
		this.id = id;
		this.alumno = alumno;
		this.importe = importe;
	}

	public CajaEntity() {
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

	public int getImporte() {
		return importe;
	}

	public void setImporte(int importe) {
		this.importe = importe;
	}
	
	
	
}
