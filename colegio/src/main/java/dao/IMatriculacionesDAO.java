package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.MatriculacionesDTO;

public interface IMatriculacionesDAO {

	Integer insertarMatricula(String idAsignatura, String idAlumno, String fecha, String tasa) throws SQLException;

	ArrayList<MatriculacionesDTO> listarMatriculas(String nombreAlumno, String nombreAsignatura, String fecha, int activo);

}
