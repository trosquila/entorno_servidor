package com.adrian.colegio.dtos;

public class NotaDTO {

    private Integer id;
    private Integer idAlumno;
    private Integer idAsignatura;
    private String nombreAlumno;
    private String nombreAsignatura;
    private Integer nota;  
    private String fecha;

    public NotaDTO(Integer id, Integer idAlumno, Integer idAsignatura,
                   String nombreAlumno, String nombreAsignatura,
                   Integer nota, String fecha) {

        this.id = id;
        this.idAlumno = idAlumno;
        this.idAsignatura = idAsignatura;
        this.nombreAlumno = nombreAlumno;
        this.nombreAsignatura = nombreAsignatura;
        this.nota = nota;
        this.fecha = fecha;
    }

    public NotaDTO() {
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

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}