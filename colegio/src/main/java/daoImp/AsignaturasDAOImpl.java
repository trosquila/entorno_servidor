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
	public ArrayList<AsignaturasDTO> obtenerTodasAsignaturasFiltradas(int id, String nombre, int curso, int tasa) {
		String sql = "SELECT id, nombre, curso, tasa, activo "
				+ "FROM asignaturas WHERE id = ? "
				+ "AND nombre LIKE ? "
				+ "AND curso = ? "
				+ "AND tasa = ?";

		ResultSet asignaturaResultSet = null;
		Connection connection = DBUtils.conexion();
		ArrayList<AsignaturasDTO> listaAsignaturas = new ArrayList<>();

		try {
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setInt(1, id);
			ps.setString(2, "%" + nombre + "%");
			ps.setInt(3, curso);
			ps.setInt(4, tasa);


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
