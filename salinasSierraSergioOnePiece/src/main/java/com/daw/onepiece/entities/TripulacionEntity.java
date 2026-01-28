package com.daw.onepiece.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tripulacion")
public class TripulacionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "barco")
	private String barco;

	@Column(name = "estaActiva")
	private Boolean estaActiva;

	@OneToMany(mappedBy = "tripulacion")
	private List<ReclutamientoEntity> reclutamientos = new ArrayList<>();

	public TripulacionEntity() {
	}

	public TripulacionEntity(Integer id, String nombre, String barco, Boolean estaActiva) {
		this.id = id;
		this.nombre = nombre;
		this.barco = barco;
		this.estaActiva = estaActiva;
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

	public List<ReclutamientoEntity> getReclutamientos() {
		return reclutamientos;
	}

	public void setReclutamientos(List<ReclutamientoEntity> reclutamientos) {
		this.reclutamientos = reclutamientos;
	}
}
