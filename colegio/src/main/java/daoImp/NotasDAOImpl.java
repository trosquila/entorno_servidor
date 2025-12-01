package daoImp;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.INotasDAO;
import dto.AlumnoDTO;
import dto.AsignaturasDTO;
import dto.NotasDTO;
import utils.DBUtils;


public class NotasDAOImpl implements INotasDAO {
	private static Logger logger = LoggerFactory.getLogger(AlumnosDAOImpl.class);

	@Override
	public ArrayList<NotasDTO> obtenerTodasNotas(String id, String idAlumno, String idAsignatura, String nota,
			String fecha, String activo) {
		String sql = "SELECT notas.id, alumnos.nombre, asignaturas.nombre, notas.nota, notas.fecha "
				+ "FROM notas "
				+ "INNER JOIN alumnos on alumnos.id = notas.id_alumnos "
				+ "INNER JOIN asignaturas on asignaturas.id = notas.id_asignaturas "
				+ "WHERE notas.id LIKE ? "
				+ "AND notas.id_alumnos LIKE ? "
				+ "AND notas.id_asignaturas LIKE ? "
				+ "AND notas.nota LIKE ? "
				+ "AND alumnos.activo LIKE ? "
				+(idAsignatura != ""? "AND notas.fecha > ? ": "");
		ResultSet notasResultSet = null;
		Connection connection = DBUtils.conexion();
		ArrayList<NotasDTO> listaNotas = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, "%" + id + "%");
			ps.setString(2, "%" + idAlumno + "%");
			ps.setString(3, "%" + idAsignatura + "%");
			ps.setString(4, "%" + nota + "%");
			ps.setString(5, "%" + activo + "%");
			if(idAsignatura != "") {
				ps.setString(6, "%" + fecha + "%");
			}

			logger.debug("Query a ejecutar: " + ps);

			notasResultSet = ps.executeQuery();

			while (notasResultSet.next()) {
				AlumnoDTO nombreAlumno = new AlumnoDTO(notasResultSet.getString(2));
				AsignaturasDTO nombreAsignatura = new AsignaturasDTO(notasResultSet.getString(3));
				NotasDTO a = new NotasDTO(notasResultSet.getInt(1), nombreAlumno, nombreAsignatura, notasResultSet.getInt(4), notasResultSet.getString(5));
				listaNotas.add(a);
				System.out.println(a.toString());
			}
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaNotas;
	}

	@Override
	public Integer insertarNota(int idAlumno, int idAsignatura, int nota, String fecha) {
		String sql = "INSERT INTO notas(id_alumnos, id_asignaturas, nota, fecha) VALUES (?,?,?,?)";
		PreparedStatement ps = null;
		int resultado = 0;
		
		try {
			Connection connection = DBUtils.conexion();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, idAlumno);
			ps.setInt(2, idAsignatura);
			ps.setInt(3, nota);
			ps.setString(4, fecha);

			resultado = ps.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}

	@Override
	public ArrayList<NotasDTO> obtenerNotasModificar(String alumno, String asignatura, String fecha) {

		String sql = "SELECT notas.id, alumnos.nombre, asignaturas.nombre, notas.nota, notas.fecha "
				+ "FROM notas "
				+ "INNER JOIN alumnos on alumnos.id = notas.id_alumnos "
				+ "INNER JOIN asignaturas on asignaturas.id = notas.id_asignaturas "
				+ "AND alumnos.nombre LIKE ? "
				+ "AND asignaturas.nombre LIKE ? "
				+ "AND notas.fecha LIKE ? ";
		ResultSet notasResultSet = null;
		Connection connection = DBUtils.conexion();
		ArrayList<NotasDTO> listaNotas = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, "%" + alumno + "%");
			ps.setString(2, "%" + asignatura + "%");
			ps.setString(3, "%" + fecha + "%");

			logger.debug("Query a ejecutar: " + ps);

			notasResultSet = ps.executeQuery();

			while (notasResultSet.next()) {
				AlumnoDTO nombreAlumno = new AlumnoDTO(notasResultSet.getString(2));
				AsignaturasDTO nombreAsignatura = new AsignaturasDTO(notasResultSet.getString(3));
				NotasDTO a = new NotasDTO(notasResultSet.getInt(1), nombreAlumno, nombreAsignatura, notasResultSet.getInt(4), notasResultSet.getString(5));
				System.out.println(a);
				listaNotas.add(a);
				System.out.println(a.toString());
			}
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaNotas;
	}

	@Override
	public int obtenerNotasModificar(int id, int idAsignatura, int nota, String fecha) {
		 String sql = "UPDATE notas SET id_asignaturas = ?, nota = ?, fecha = ? WHERE id = ?";
		    int resultado = 0;

		    try {
		        Connection connection = DBUtils.conexion();
		        PreparedStatement ps = connection.prepareStatement(sql);

		        ps.setInt(1, idAsignatura);
		        ps.setInt(2, nota);
		        ps.setString(3, fecha);
		        ps.setInt(4, id);

		        logger.debug("Query a ejecutar: " + ps);

		        resultado = ps.executeUpdate();

		        connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return resultado;


	}

	@Override
	public int borrarNota(String id) {
	    String sql = "DELETE FROM notas WHERE id = ?";
	    int resultado = 0;

	    try {
	        Connection connection = DBUtils.conexion();
	        PreparedStatement ps = connection.prepareStatement(sql);

	        ps.setInt(1, Integer.parseInt(id));

	        logger.debug("Query a ejecutar: " + ps);

	        resultado = ps.executeUpdate();

	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (NumberFormatException e) {
	        e.printStackTrace();
	    }

	    return resultado;


	}

	@Override
	public int actualizarNota(int id, int idAsignatura, int nota, String fecha) {
	    String sql = "UPDATE notas SET id_asignaturas = ?, nota = ?, fecha = ? WHERE id = ?";
	    int resultado = 0;

	    try (Connection connection = DBUtils.conexion();
	         PreparedStatement ps = connection.prepareStatement(sql)) {

	        ps.setInt(1, idAsignatura);
	        ps.setInt(2, nota);
	        ps.setString(3, fecha);
	        ps.setInt(4, id);

	        logger.debug("Query a ejecutar: " + ps);

	        resultado = ps.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return resultado;

	}
	
}
 