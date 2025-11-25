package dto;

public class NotasDTO {
	private int id;
	private int idAlumno;
	private int idAsignatura;
	private int nota;
	private String fecha;
	AlumnoDTO alumnoDTO;
	AsignaturasDTO asignaturaDTO;
	
	public NotasDTO(int id, int idAlumno, int idAsignatura, int nota, String fecha) {
		this.id = id;
		this.idAlumno = idAlumno;
		this.idAsignatura = idAsignatura;
		this.nota = nota;
		this.fecha = fecha;
	}
	
	public NotasDTO(int id, AlumnoDTO alumnoDTO ,AsignaturasDTO asignaturaDTO, int nota, String fecha) {
		this.id = id;
		this.alumnoDTO = alumnoDTO;
		this.asignaturaDTO = asignaturaDTO;
		this.nota = nota;
		this.fecha = fecha;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public int getIdAsignatura() {
		return idAsignatura;
	}

	public void setIdAsignatura(int idAsignatura) {
		this.idAsignatura = idAsignatura;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	
}
