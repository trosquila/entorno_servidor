package serviciosImp;

import java.util.ArrayList;

import dao.INotasDAO;
import daoImp.NotasDAOImpl;
import dto.AsignaturasDTO;
import dto.NotasDTO;
import servicios.INotasService;

public class NotasServiceImp implements INotasService {

	@Override
	public ArrayList<NotasDTO> obtenerTodasNotas(String id, String idAlumno, String idAsignatura, String nota,
			String fecha, String activo) {
		INotasDAO notas = new NotasDAOImpl();
		return notas.obtenerTodasNotas(id, idAlumno, idAsignatura, nota, fecha, activo);
	}

	@Override
	public Integer insertarNota(int idAlumno, int idAsignatura, int nota, String fecha) {
		INotasDAO notas = new NotasDAOImpl();
		return notas.insertarNota(idAlumno, idAsignatura, nota, fecha);
	}

	@Override
	public ArrayList<NotasDTO> obtenerNotasModificar(String alumno, String asignatura, String fecha) {
		INotasDAO notas = new NotasDAOImpl();
		return notas.obtenerNotasModificar( alumno,  asignatura,  fecha);
	}

	@Override
	public int actualizarNota(int id, int idAsignatura, int nota, String fecha) {
		INotasDAO notas = new NotasDAOImpl();
		return notas.actualizarNota(id, idAsignatura, nota, fecha);
	}

	@Override
	public int borrarNota(String id) {
		INotasDAO notas = new NotasDAOImpl();
		return notas.borrarNota(id);
		
	}


}
