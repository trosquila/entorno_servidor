package com.adrian.colegio.dtos;

public class NotaDTO {

	private Integer idAlumno;
	private String nombreAlumno;
	private String nombreAsignatura;
	private String nota;
	private String fecha;

	public NotaDTO(Integer idAlumno, String nombreAlumno, String nombreAsignatura, String nota, String fecha) {
		this.idAlumno = idAlumno;
		this.nombreAlumno = nombreAlumno;
		this.nombreAsignatura = nombreAsignatura;
		this.nota = nota;
		this.fecha = fecha;
	}

	public NotaDTO() {
	}

	public Integer getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
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

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
