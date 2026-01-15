package com.adrian.colegio.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "notas")
public class NotaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_alumnos")
    private AlumnoEntity alumno;

    @ManyToOne
    @JoinColumn(name = "id_asignaturas")
    private AsignaturaEntity asignatura;

    @Column(name = "nota")
    private String nota;

    @Column(name = "fecha")
    private String fecha;

    public NotaEntity() {
        super();
    }

    public NotaEntity(Integer id, AlumnoEntity alumno, AsignaturaEntity asignatura, String nota, String fecha) {
        super();
        this.id = id;
        this.alumno = alumno;
        this.asignatura = asignatura;
        this.nota = nota;
        this.fecha = fecha;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
