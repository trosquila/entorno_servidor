package com.adrian.colegio.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "caja")
public class CajaEntity {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@OneToOne
	@JoinColumn(name = "idmatricula")
	private MatriculaEntity matricula;
	
	@Column(name = "importe")
	private int importe;

	public CajaEntity(int id, MatriculaEntity matricula, int importe) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.importe = importe;
	}
	public CajaEntity(MatriculaEntity matricula, int importe) {
		this.matricula = matricula;
		this.importe = importe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MatriculaEntity getMatricula() {
		return matricula;
	}

	public void setMatricula(MatriculaEntity matricula) {
		this.matricula = matricula;
	}

	public int getImporte() {
		return importe;
	}

	public void setImporte(int importe) {
		this.importe = importe;
	}
	
	
}
