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

}
