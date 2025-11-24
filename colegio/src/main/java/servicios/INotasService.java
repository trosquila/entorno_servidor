package servicios;

import java.util.ArrayList;

import dto.NotasDTO;

public interface INotasService {

	ArrayList<NotasDTO> obtenerTodasNotas(String id, String idAlumno, String idAsignatura, String nota, String fecha,String activo);


}
