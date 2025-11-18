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
	public ArrayList<AlumnoDTO> obtenerAlumnosPorIdNombreApellido(String id, String nombre, String apellido, int familiaNumerosa, int activo) {
	    System.out.println("Parámetros recibidos:");
	    System.out.println("ID: " + id);
	    System.out.println("Nombre: " + nombre);
	    System.out.println("Apellido: " + apellido);
	    System.out.println("Familia Numerosa: " + familiaNumerosa);
	    System.out.println("Activo: " + activo);

	    IAlumnosDAO alumnos = new AlumnosDAOImpl();
	    return alumnos.obtenerAlumnosPorIdNombreApellido(id, nombre, apellido, familiaNumerosa, activo);
	}

	@Override
	public int insertarAlumno(String id, String nombre, String apellido, String idMunicipio, int familiaNumerosa, int activo) {
		IAlumnosDAO alumnos = new AlumnosDAOImpl();
		return alumnos.insertarAlumno(id, nombre, apellido, idMunicipio,
		familiaNumerosa, activo);

	
	}
	

}
