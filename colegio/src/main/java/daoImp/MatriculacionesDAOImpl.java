package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.IMatriculacionesDAO;
import dto.AlumnoDTO;
import dto.AsignaturasDTO;
import dto.CajaDTO;

import dto.MatriculacionesDTO;

import utils.DBUtils;

public class MatriculacionesDAOImpl implements IMatriculacionesDAO{
	private static Logger logger = LoggerFactory.getLogger(AlumnosDAOImpl.class);
	@Override
	public Integer insertarMatricula(String idAsignatura, String idAlumno, String fecha,
			String tasa) throws SQLException {
		String sql1 = "INSERT INTO matriculaciones (id_asignatura, id_alumno, fecha, activo) VALUES (?, ?, ?, 1)";
		String sql2 = "INSERT INTO caja (idmatricula, importe) VALUES (?,?)";
		int resultado = 0;
		
		Connection connection = DBUtils.conexion();
		PreparedStatement statement;
		try {
			connection.setAutoCommit(false); // Empieza la transacción
			statement = connection.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
			// Seteo de los parámetros de la primera SQL (matriculaciones)
			statement.setString(1, idAsignatura);
			statement.setString(2, idAlumno);
			statement.setString(3, fecha);
			int filasInsertadas = statement.executeUpdate();
			
			if (filasInsertadas == 0)
			    throw new SQLException("Ha fallado la inserción de la matriculación");
			

			// Este método nos devolverá la clave generada dentro un ResultSet
			// El resulset en la primera posición nos encontraremos la clave generada
			ResultSet clavesGeneradas = statement.getGeneratedKeys();
			
			// Recorremos el resultset para obtener la clave.
			int idMatriculacion;
			if (clavesGeneradas.next()) {
			    idMatriculacion = clavesGeneradas.getInt(1);
			} else {
			    throw new SQLException("Insert fallido, no se ha obtenido id.");
			}
			
			// Con el idMatriculacion obtenido hago el insert en la tabla caja
			PreparedStatement statement2 = connection.prepareStatement(sql2);
			statement2.setInt(1, idMatriculacion);
			statement2.setString(2, tasa);
			

			int filasInsertadasCaja = statement2.executeUpdate();

			if (filasInsertadasCaja == 0)
			    throw new SQLException("Ha fallado la inserción en caja");
			
			  connection.commit(); // Si todo va bien, confirmamos la transacción
			  resultado = filasInsertadasCaja;

		} catch (SQLException e) {
				connection.rollback(); // Si hay error, deshacemos todos los cambios
				e.printStackTrace();

		} finally {
			if (connection != null) {
		        connection.setAutoCommit(true); // Restauramos el autocommit
		        connection.close();
		    }
			
		}
		return resultado;
	}

	@Override
	public ArrayList<MatriculacionesDTO> listarMatriculas(String nombreAlumno, String nombreAsignatura, String fecha, int activo) {
		
		String matriculaActiva = "";
		String sql = "select matriculaciones.id, asignaturas.nombre, alumnos.nombre, matriculaciones.fecha, matriculaciones.activo, caja.importe, asignaturas.id , alumnos.id FROM matriculaciones "
				+ "inner join alumnos on alumnos.id = matriculaciones.id_alumno "
				+ "inner join asignaturas on asignaturas.id = matriculaciones.id_asignatura "
				+ "inner join caja on caja.idmatricula = matriculaciones.id "
				+ "WHERE alumnos.nombre LIKE ? AND asignaturas.nombre LIKE ? AND matriculaciones.activo LIKE ?"
				+(fecha != ""? "AND matriculaciones.fecha > ? ": "");
		
		
        ArrayList<MatriculacionesDTO> listaMatriculas = new ArrayList<>();
		ResultSet notasResultSet = null;
		Connection connection = DBUtils.conexion();
        try {
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, "%" + nombreAlumno + "%");
			ps.setString(2, "%" + nombreAsignatura + "%");
			ps.setString(3, "%" + matriculaActiva + "%");
			if(fecha != "") {
				ps.setString(5, "%" + fecha + "%");
			}

			logger.debug("Query a ejecutar: " + ps);

			notasResultSet = ps.executeQuery();

			while (notasResultSet.next()) {
				AlumnoDTO nombreAlumno2 = new AlumnoDTO(notasResultSet.getString(3));
				AsignaturasDTO nombreAsignatura2 = new AsignaturasDTO(notasResultSet.getString(2), notasResultSet.getInt(7));
				CajaDTO cajaDTO = new CajaDTO(notasResultSet.getInt(6));
				MatriculacionesDTO a = new MatriculacionesDTO(notasResultSet.getInt(1),nombreAsignatura2, nombreAlumno2, notasResultSet.getString(4), notasResultSet.getInt(5), cajaDTO);
				listaMatriculas.add(a);
				System.out.println(a.toString());
			}
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaMatriculas;
	}

	@Override
	public int actualizarMatricula(int idMatricula, int idAsignatura, int idAlumno, int importe, String fecha) {
		  String sql1 = "UPDATE matriculaciones SET id_asignatura=?, id_alumno=?, fecha=? WHERE id=?";
		    String sql2 = "UPDATE caja SET importe=? WHERE idmatricula=?";

		    int resultado = 0;

		    Connection connection = DBUtils.conexion();

		    try {
		        connection.setAutoCommit(false);


		        PreparedStatement ps1 = connection.prepareStatement(sql1);
		        ps1.setInt(1, idAsignatura);
		        ps1.setInt(2, idAlumno);
		        ps1.setString(3, fecha);
		        ps1.setInt(4, idMatricula);

		        int filas1 = ps1.executeUpdate();

		        if (filas1 == 0) {
		            throw new SQLException("No se pudo actualizar la tabla matriculaciones");
		        }

		        // UPDATE caja
		        PreparedStatement ps2 = connection.prepareStatement(sql2);
		        ps2.setInt(1, importe);
		        ps2.setInt(2, idMatricula);

		        int filas2 = ps2.executeUpdate();

		        if (filas2 == 0) {
		            throw new SQLException("No se pudo actualizar la tabla caja");
		        }

		        connection.commit();
		        resultado = 1;

		    } catch (SQLException e) {
		        try {
		            connection.rollback();
		        } catch (SQLException rollbackException) {
		            rollbackException.printStackTrace();
		        }
		        e.printStackTrace();
		    } finally {
		        try {
		            connection.setAutoCommit(true);
		            connection.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }

		    return resultado;
	}

}
