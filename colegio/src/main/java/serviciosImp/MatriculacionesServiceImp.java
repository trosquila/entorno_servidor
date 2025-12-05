package serviciosImp;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.IMatriculacionesDAO;
import daoImp.MatriculacionesDAOImpl;
import dto.MatriculacionesDTO;
import servicios.IMatriculacionesService;

public class MatriculacionesServiceImp implements IMatriculacionesService {

	@Override
	public Integer insertarMatriculacion(String idAsignatura, String idAlumno, String fecha, String tasa) throws SQLException {
		IMatriculacionesDAO notas = new MatriculacionesDAOImpl();
		return notas.insertarMatricula(idAsignatura, idAlumno, fecha, tasa);
	}

	@Override
	public ArrayList<MatriculacionesDTO> listarMatriculas(String nombreAlumno, String nombreAsignatura, String fecha, int activo) {
		IMatriculacionesDAO notas = new MatriculacionesDAOImpl();
		return notas.listarMatriculas(nombreAlumno, nombreAsignatura, fecha,  activo);
	}

	@Override
	public int actualizarMatricula(int idMatricula, int idAsignatura, int idAlumno, int importe, String fecha) {
		IMatriculacionesDAO notas = new MatriculacionesDAOImpl();
		return notas.actualizarMatricula( idMatricula,  idAsignatura,  idAlumno,  importe,  fecha);
	}

	@Override
	public int borrarMatricula(String id) {
		IMatriculacionesDAO notas = new MatriculacionesDAOImpl();
		return notas.borrarMatricula(id);
	}

}
