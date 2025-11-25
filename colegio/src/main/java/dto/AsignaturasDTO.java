package dto;

public class AsignaturasDTO {
	private int id;
	private String nombre;
	private int curso;
	private int tasa;
	private int activo;
	
	public AsignaturasDTO(int id, String nombre, int curso, int tasa, int activo) {
		this.id = id;
		this.nombre = nombre;
		this.curso = curso;
		this.tasa = tasa;
		this.activo = activo;
	}
	public AsignaturasDTO(String nombre) {
		this.nombre = nombre;

	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}

	public int getTasa() {
		return tasa;
	}

	public void setTasa(int tasa) {
		this.tasa = tasa;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "AsignaturasDTO [id=" + id + ", nombre=" + nombre + ", curso=" + curso + ", tasa=" + tasa + ", activo="
				+ activo + "]";
	}
	
	
}
