package daoImp;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.INotasDAO;
import dto.AsignaturasDTO;
import dto.NotasDTO;
import utils.DBUtils;


public class NotasDAOImpl implements INotasDAO {
	private static Logger logger = LoggerFactory.getLogger(AlumnosDAOImpl.class);

	@Override
	public ArrayList<NotasDTO> obtenerTodasNotas(String id, String idAlumno, String idAsignatura, String nota,
			String fecha, String activo) {
		String sql = "SELECT notas.id, alumnos.nombre, asginaturas.nombre, notas.nota"
				+ "INNER JOIN alumnos on alumnos.id = notas.id_alumnos "
				+ "INNER JOIN asignaturas on asignaturas.id = notas.id_asignaturas "
				+ "FROM asignaturas WHERE id LIKE ? "
				+ "AND notas.nombre LIKE ? "
				+ "AND notas.notas.id_alumnos LIKE ? "
				+ "AND notas.id_asignaturas LIKE ? "
				+ "AND notas.nota LIKE ? "
				+ "AND notas.fecha LIKE ?"
				+ "and alumno.activo LIKE ?";
		
		ResultSet notasResultSet = null;
		Connection connection = DBUtils.conexion();
		ArrayList<NotasDTO> listaNotas = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, "%" + id + "%");
			ps.setString(1, "%" + idAlumno + "%");
			ps.setString(1, "%" + idAsignatura + "%");
			ps.setString(1, "%" + nota + "%");
			ps.setString(1, "%" + id + "%");


			logger.debug("Query a ejecutar: " + ps);

			asignaturaResultSet = ps.executeQuery();

			while (asignaturaResultSet.next()) {
				AsignaturasDTO a = new AsignaturasDTO(asignaturaResultSet.getInt(1), asignaturaResultSet.getString(2), asignaturaResultSet.getInt(3), asignaturaResultSet.getInt(4), asignaturaResultSet.getInt(5));
				listaAsignaturas.add(a);
			}
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaAsignaturas;
	}
	
}
 