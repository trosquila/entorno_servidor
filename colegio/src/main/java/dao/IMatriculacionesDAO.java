package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.MatriculacionesDTO;

public interface IMatriculacionesDAO {

	Integer insertarMatricula(String idAsignatura, String idAlumno, String fecha, String tasa) throws SQLException;

	ArrayList<MatriculacionesDTO> listarMatriculas(String nombreAlumno, String nombreAsignatura, String fecha, int activo);

	int actualizarMatricula(int idMatricula, int idAsignatura, int idAlumno, int importe, String fecha);

	int borrarMatricula(String id);

}
