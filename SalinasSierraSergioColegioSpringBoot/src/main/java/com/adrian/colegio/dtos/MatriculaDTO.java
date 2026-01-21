package com.adrian.colegio.dtos;

public class MatriculaDTO {

	private Integer id;
	private Integer idAlumno;
	private Integer idAsignatura;
	private String nombreAlumno;
	private String nombreAsignatura;
	private String fecha;
	private Integer tasa;
	private Integer activo;



	public MatriculaDTO(Integer id, Integer idAlumno, Integer idAsignatura, String nombreAlumno,
			String nombreAsignatura, String fecha, Integer tasa, Integer activo) {
		super();
		this.id = id;
		this.idAlumno = idAlumno;
		this.idAsignatura = idAsignatura;
		this.nombreAlumno = nombreAlumno;
		this.nombreAsignatura = nombreAsignatura;
		this.fecha = fecha;
		this.tasa = tasa;
		this.activo = activo;
	}



	public MatriculaDTO() {
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getIdAlumno() {
		return idAlumno;
	}



	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}



	public Integer getIdAsignatura() {
		return idAsignatura;
	}



	public void setIdAsignatura(Integer idAsignatura) {
		this.idAsignatura = idAsignatura;
	}



	public String getNombreAlumno() {
		return nombreAlumno;
	}



	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}



	public String getNombreAsignatura() {
		return nombreAsignatura;
	}



	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}



	public String getFecha() {
		return fecha;
	}



	public void setFecha(String fecha) {
		this.fecha = fecha;
	}



	public Integer getTasa() {
		return tasa;
	}



	public void setTasa(Integer tasa) {
		this.tasa = tasa;
	}



	public Integer getActivo() {
		return activo;
	}



	public void setActivo(Integer activo) {
		this.activo = activo;
	}
	

	
}
