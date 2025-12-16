package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
@Table(name = "caja")
public class CajaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name="idmatricula")
	private MatriculasEntity matricula;

	private double importe;
	
	public CajaEntity() {
	}

	public CajaEntity(int id, MatriculasEntity matricula, double importe) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.importe = importe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MatriculasEntity getMatricula() {
		return matricula;
	}

	public void setMatricula(MatriculasEntity matricula) {
		this.matricula = matricula;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

		

    
}
