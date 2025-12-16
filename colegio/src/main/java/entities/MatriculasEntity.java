package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
@Table(name = "matriculaciones")
public class MatriculasEntity {
	
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    @ManyToOne
	    @JoinColumn(name = "id_alumno", nullable = false)
	    private AlumnoEntity alumno;
	    @ManyToOne
	    @JoinColumn(name = "id_asignatura", nullable = false)
	    private AsignaturaEntity asignatura;
	    @Column(name = "fecha")
	    private String fecha;
	    @Column(name = "activo")
	    private int activo;
	    @OneToOne(mappedBy = "matricula") 
	    private CajaEntity caja;

		public MatriculasEntity() {}
	    
	    public MatriculasEntity(AlumnoEntity alumno, AsignaturaEntity asignatura, String fecha, int activo) {
	        this.alumno = alumno;
	        this.asignatura = asignatura;
	        this.fecha = fecha;
	        this.activo = activo;
	    }

	    public int getId() {
	        return id;
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

	    public String getFecha() {
	        return fecha;
	    }

	    public void setFecha(String fecha) {
	        this.fecha = fecha;
	    }

	    public int getActivo() {
	        return activo;
	    }

	    public void setActivo(int activo) {
	        this.activo = activo;
	    }
	    
	    public CajaEntity getCaja() {
			return caja;
		}

		public void setCaja(CajaEntity caja) {
			this.caja = caja;
		}

		public void setId(int id) {
			this.id = id;
		}
		

    
}
