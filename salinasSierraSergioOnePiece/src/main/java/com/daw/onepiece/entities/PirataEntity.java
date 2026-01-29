package com.daw.onepiece.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "pirata")
public class PirataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "frutadeldiablo")
    private String frutaDelDiablo;

    @Column(name = "fechanacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "estaactivo")
    private Boolean activo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "isla_id")
    private IslaEntity isla;
    
    @OneToMany(mappedBy = "pirata", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReclutamientoEntity> reclutamientos = new ArrayList<>();
    
    public PirataEntity() {}

	public PirataEntity(Integer id, String nombre, String frutaDelDiablo, LocalDate fechaNacimiento, Boolean activo,
			IslaEntity isla, List<ReclutamientoEntity> reclutamientos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.frutaDelDiablo = frutaDelDiablo;
		this.fechaNacimiento = fechaNacimiento;
		this.activo = activo;
		this.isla = isla;
		this.reclutamientos = reclutamientos;
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

	public String getFrutaDelDiablo() {
		return frutaDelDiablo;
	}

	public void setFrutaDelDiablo(String frutaDelDiablo) {
		this.frutaDelDiablo = frutaDelDiablo;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public IslaEntity getIsla() {
		return isla;
	}

	public void setIsla(IslaEntity isla) {
		this.isla = isla;
	}

	public List<ReclutamientoEntity> getReclutamientos() {
		return reclutamientos;
	}

	public void setReclutamientos(List<ReclutamientoEntity> reclutamientos) {
		this.reclutamientos = reclutamientos;
	}

    
}
