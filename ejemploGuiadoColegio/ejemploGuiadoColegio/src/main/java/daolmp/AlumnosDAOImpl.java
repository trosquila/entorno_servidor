package daolmp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import DTO.AlumnoDTO;
import Utils.BDUtils;
import dao.IAlumnosDAO;

public class AlumnosDAOImpl implements IAlumnosDAO{
	private static Logger logger = LoggerFactory.getLogger(AlumnosDAOImpl.class);
	@Override
	public ArrayList<AlumnoDTO> obtenerTodosAlumnos() {
		Connection connection = BDUtils.conexion();
		ResultSet alumnos = null;
		ArrayList<AlumnoDTO> listaAlumnos = new ArrayList<>();
		Statement statement;
		try {
			statement = connection.createStatement();
			alumnos = statement.executeQuery("SELECT * FROM alumnos");
			while(alumnos.next()) {
				AlumnoDTO a = new AlumnoDTO(alumnos.getInt(1),
				alumnos.getString(2), alumnos.getString(3));
				logger.debug("Contenido de alumno " + a.getNombre() + "" + a.getId());
				listaAlumnos.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				return listaAlumnos;
	}
	@Override
	public ArrayList<AlumnoDTO> obtenerAlumnosPorIdNombreApellido(String id, String nombre, String apellido, int familiaNumerosa, int activo) {
			String sql = "SELECT a.id, a.nombre, a.apellidos, m.nombre,m.id_municipio " +
			"FROM alumnos a, municipios m WHERE a.id_municipio = m.id_municipio AND a.id LIKE ? AND a.nombre LIKE ? AND a.apellidos LIKE ? AND a.familia_numerosa = ? AND a.activo = ?";
			ResultSet alumnoResultSet = null;
			Connection connection = BDUtils.conexion();
			ArrayList<AlumnoDTO> listaAlumnos = new ArrayList<>();
			try {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, "%" + id + "%");
				ps.setString(2, "%" + nombre + "%");
				ps.setString(3, "%" + apellido + "%");
				ps.setInt(4,familiaNumerosa);
				ps.setInt(5,activo);
				logger.debug("Query a ejecutar: " + ps);
				alumnoResultSet = ps.executeQuery();
				while (alumnoResultSet.next()) {
					AlumnoDTO a = new AlumnoDTO(alumnoResultSet.getInt(1),
					alumnoResultSet.getString(2),
					alumnoResultSet.getString(3),
					alumnoResultSet.getString(4));
					listaAlumnos.add(a);
				}
			} catch (SQLException e) {
				e.printStackTrace();	
			}
			System.out.println(listaAlumnos);
			return listaAlumnos;
		}
	@Override
	public int insertarAlumno(String id, String nombre, String apellido, String idMunicipio, int familiaNumerosa, int activo) {
		String sql = "INSERT INTO alumnos (id, nombre, apellidos, id_municipio, familia_numerosa, activo) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		int resultado = 0;
		try {
			Connection connection = BDUtils.conexion();
			ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, nombre);
			ps.setString(3, apellido);
			ps.setString(4, idMunicipio);
			ps.setInt(5, familiaNumerosa);
			ps.setInt(6, activo);
			resultado = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
				}
		return resultado;
	}
}
