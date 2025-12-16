package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(name = "notas")
public class NotasEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private int id;
	
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

	public NotasEntity(int id, AlumnoEntity alumno, AsignaturaEntity asignatura, String nota, String fecha) {
		this.id = id;
		this.alumno = alumno;
		this.asignatura = asignatura;
		this.nota = nota;
		this.fecha = fecha;
	}

	public NotasEntity() {
		// TODO Auto-generated constructor stub
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
