package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.IAsignaturasDAO;
import dto.AsignaturasDTO;
import utils.DBUtils;

public class AsignaturasDAOImpl implements IAsignaturasDAO {
	private static Logger logger = LoggerFactory.getLogger(AlumnosDAOImpl.class);
	@Override
	public ArrayList<AsignaturasDTO> obtenerTodasAsignaturasFiltradas(int id, String nombre, int curso, int tasa, int activo) {
		String sql = "SELECT id, nombre, curso, tasa, activo "
				+ "FROM asignaturas WHERE id LIKE ? "
				+ "AND nombre LIKE ? "
				+ "AND curso = ? "
				+ "AND tasa > ? "
				+ "AND activo = ?";

		ResultSet asignaturaResultSet = null;
		Connection connection = DBUtils.conexion();
		ArrayList<AsignaturasDTO> listaAsignaturas = new ArrayList<>();
		String IdString = "";
		if(id != 0) {
			String.valueOf(id);
		}
		try {
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, "%" + IdString + "%");
			ps.setString(2, "%" + nombre + "%");
			ps.setInt(3, curso);
			ps.setInt(4, tasa);
			ps.setInt(5, activo);


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
	@Override
	public Integer insertarAsignatura(int id, String nombre, int curso, int tasa, int activo) {
		String sql = "INSERT INTO asignaturas(nombre, curso, tasa, activo) VALUES (?,?,?,?)";
		PreparedStatement ps = null;
		int resultado = 0;
		
		try {
			Connection connection = DBUtils.conexion();
			ps = connection.prepareStatement(sql);
			ps.setString(1, nombre);
			ps.setInt(2, curso);
			ps.setInt(3, tasa);
			ps.setInt(4, activo);

			resultado = ps.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}
	@Override
	public ArrayList<AsignaturasDTO> obtenerAsignaturasModificar(String id, String nombre, String curso, String tasa) {
		String sql = "SELECT * from asignaturas WHERE id LIKE ? "
				+ "AND nombre LIKE ? AND curso LIKE ? "
				+ "AND tasa LIKE ?";

		ResultSet asignaturaResultSet = null;
		Connection connection = DBUtils.conexion();
		ArrayList<AsignaturasDTO> listaAsignaturas = new ArrayList<>();

		try {
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, "%" + id + "%");
			ps.setString(2, "%" + nombre + "%");
			ps.setString(3, "%" + curso + "%");
			ps.setString(4, "%" + tasa + "%");

			logger.debug("Query a ejecutar: " + ps);

			asignaturaResultSet = ps.executeQuery();

			while (asignaturaResultSet.next()) {
				AsignaturasDTO a = new AsignaturasDTO(asignaturaResultSet.getInt(1), asignaturaResultSet.getString(2),
						asignaturaResultSet.getInt(3), asignaturaResultSet.getInt(4), 0);
				listaAsignaturas.add(a);
			}
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaAsignaturas;
	}
	@Override
	public int actualizarAsignatura(int id, String nombre, int curso, int tasa) {
		String sql = "UPDATE asignaturas SET nombre = ?, curso = ?, tasa = ? "
				+ "WHERE id =  ? ";
		PreparedStatement ps = null;
		int resultado = 0;
		try {
			Connection connection = DBUtils.conexion();
			ps = connection.prepareStatement(sql);
			ps.setString(1, nombre);
			ps.setInt(2, curso);
			ps.setInt(3, tasa);
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
	public ArrayList<AsignaturasDTO> obtenerAsignaturasBorrar(String id, String nombre, String curso, String tasa) {
		String sql = "SELECT * from asignaturas WHERE id LIKE ? "
				+ "AND nombre LIKE ? AND curso LIKE ? "
				+ "AND tasa LIKE ?";

		ResultSet asignaturaResultSet = null;
		Connection connection = DBUtils.conexion();
		ArrayList<AsignaturasDTO> listaAsignaturas = new ArrayList<>();

		try {
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, "%" + id + "%");
			ps.setString(2, "%" + nombre + "%");
			ps.setString(3, "%" + curso + "%");
			ps.setString(4, "%" + tasa + "%");

			logger.debug("Query a ejecutar: " + ps);

			asignaturaResultSet = ps.executeQuery();

			while (asignaturaResultSet.next()) {
				AsignaturasDTO a = new AsignaturasDTO(asignaturaResultSet.getInt(1), asignaturaResultSet.getString(2),
						asignaturaResultSet.getInt(3), asignaturaResultSet.getInt(4), 0);
				listaAsignaturas.add(a);
			}
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaAsignaturas;
	}
	@Override
	public int borrarAsignatura(String id) {
		String sql = "UPDATE asignaturas SET activo = 0 "
				+ "WHERE id = ? ";
		Connection connection = DBUtils.conexion();
		PreparedStatement ps;
		int resultado = 0;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			logger.debug("Query a ejecutar: " + ps);
			resultado = ps.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}

	
}
