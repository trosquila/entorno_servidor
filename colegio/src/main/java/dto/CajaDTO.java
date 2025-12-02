package dto;

public class CajaDTO {
	private int id;
	private int idMatricula;
	private int importe;
	
	public CajaDTO(int id, int idMatricula, int importe) {
		this.id = id;
		this.idMatricula = idMatricula;
		this.importe = importe;
	}
	
	public CajaDTO(int importe) {
		
		this.importe = importe;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdMatricula() {
		return idMatricula;
	}

	public void setIdMatricula(int idMatricula) {
		this.idMatricula = idMatricula;
	}

	public int getImporte() {
		return importe;
	}

	public void setImporte(int importe) {
		this.importe = importe;
	}
	
	
}
