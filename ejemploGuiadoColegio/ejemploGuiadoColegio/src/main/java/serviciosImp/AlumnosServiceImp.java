package serviciosImp;

import java.sql.SQLException;
import java.util.ArrayList;

import DTO.AlumnoDTO;
import dao.IAlumnosDAO;
import daolmp.AlumnosDAOImpl;
import servicios.IAlumnosService;

public class AlumnosServiceImp implements IAlumnosService {

	@Override
	public ArrayList<AlumnoDTO> obtenerAlumnos() throws SQLException {
		IAlumnosDAO alumnos = new AlumnosDAOImpl();
		return alumnos.obtenerTodosAlumnos();
	}

	@Override
	public ArrayList<AlumnoDTO> obtenerAlumnosPorIdNombreApellido(String id, String nombre, String apellido, String familiaNumerosa, String activo) {
		IAlumnosDAO alumnos = new AlumnosDAOImpl();
		return alumnos.obtenerAlumnosPorIdNombreApellido(id, nombre, apellido);
	}

}
