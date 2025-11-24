package daoImp;


import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.INotasDAO;
import dto.NotasDTO;


public class NotasDAOImpl implements INotasDAO {
	private static Logger logger = LoggerFactory.getLogger(AlumnosDAOImpl.class);

	@Override
	public ArrayList<NotasDTO> obtenerTodasNotas(String id, String idAlumno, String idAsignatura, String nota,
			String fecha, String activo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
 