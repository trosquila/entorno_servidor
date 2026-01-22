package com.adrian.colegio.dtos;


public class CajaDTO {
    private Integer id;
    private Integer idAlumno;
    private String nombreAlumno;
    private Integer importe;


    public CajaDTO(Integer id, Integer idAlumno, String nombreAlumno, Integer importe) {
        this.id = id;
        this.idAlumno = idAlumno;
        this.nombreAlumno = nombreAlumno;
        this.importe = importe;
    }

	public CajaDTO() {
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

	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public Integer getImporte() {
		return importe;
	}

	public void setImporte(Integer importe) {
		this.importe = importe;
	}
}
