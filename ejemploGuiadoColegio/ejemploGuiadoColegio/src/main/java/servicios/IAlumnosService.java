package servicios;

import java.sql.SQLException;
import java.util.ArrayList;

import DTO.AlumnoDTO;

public interface IAlumnosService {
	public ArrayList<AlumnoDTO> obtenerAlumnos() throws SQLException;
	public ArrayList<AlumnoDTO> obtenerAlumnosPorIdNombreApellido(String id, String nombre, String apellido);
}
