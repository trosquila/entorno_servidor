package dao;

import java.util.ArrayList;

import dto.NotasDTO;

public interface INotasDAO {

	ArrayList<NotasDTO> obtenerTodasNotas(String id, String idAlumno, String idAsignatura, String nota, String fecha,
			String activo);

	Integer insertarNota(int idAlumno, int idAsignatura, int nota, String fecha);

}
