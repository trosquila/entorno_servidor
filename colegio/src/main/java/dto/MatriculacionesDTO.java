package dto;

public class MatriculacionesDTO {
	private int id;
	private int id_asignatura;
	private int id_alumno;
	private String fecha;
	private int activo;
	private CajaDTO cajaDTO;
	private AsignaturasDTO asignaturasDTO;
	private AlumnoDTO alumnoDTO;
	
	public MatriculacionesDTO(int id, int id_asignatura, int id_alumno, String fecha, int activo) {
		super();
		this.id = id;
		this.id_asignatura = id_asignatura;
		this.id_alumno = id_alumno;
		this.fecha = fecha;
		this.activo = activo;
	}
	
	public MatriculacionesDTO(int id, AsignaturasDTO asignaturasDTO, AlumnoDTO alumnoDTO, String fecha, int activo, CajaDTO cajaDTO) {
		this.id = id;
		this.asignaturasDTO = asignaturasDTO;
		this.alumnoDTO = alumnoDTO;
		this.fecha = fecha;
		this.activo = activo;
		this.cajaDTO = cajaDTO;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_asignatura() {
		return id_asignatura;
	}

	public void setId_asignatura(int id_asignatura) {
		this.id_asignatura = id_asignatura;
	}

	public int getId_alumno() {
		return id_alumno;
	}

	public void setId_alumno(int id_alumno) {
		this.id_alumno = id_alumno;
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

	public CajaDTO getCajaDTO() {
		return cajaDTO;
	}

	public void setCajaDTO(CajaDTO cajaDTO) {
		this.cajaDTO = cajaDTO;
	}

	public AsignaturasDTO getAsignaturasDTO() {
		return asignaturasDTO;
	}

	public void setAsignaturasDTO(AsignaturasDTO asignaturasDTO) {
		this.asignaturasDTO = asignaturasDTO;
	}

	public AlumnoDTO getAlumnoDTO() {
		return alumnoDTO;
	}

	public void setAlumnoDTO(AlumnoDTO alumnoDTO) {
		this.alumnoDTO = alumnoDTO;
	}
	
	
	
}
