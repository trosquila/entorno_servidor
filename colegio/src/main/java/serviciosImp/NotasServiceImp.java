package serviciosImp;

import java.util.ArrayList;

import dao.INotasDAO;
import daoImp.NotasDAOImpl;
import dto.NotasDTO;
import servicios.INotasService;

public class NotasServiceImp implements INotasService {

	@Override
	public ArrayList<NotasDTO> obtenerTodasNotas(String id, String idAlumno, String idAsignatura, String nota,
			String fecha, String activo) {
		INotasDAO asignaturas = new NotasDAOImpl();
		return asignaturas.obtenerTodasNotas(id, idAlumno, idAsignatura, nota, fecha, activo);
	}


}
